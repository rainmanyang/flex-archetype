package com.oasis.wolfburg.service.qzSchedule.handler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oasis.tmsv5.common.base.Constants;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.util.helper.BarCodeHelper;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
import com.oasis.wolfburg.common.enums.type.EventPhase;
import com.oasis.wolfburg.common.enums.type.RSJobType;
import com.oasis.wolfburg.common.vo.route.StopVO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobVO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobTimeRecordDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSScheduleDAO;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJob;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJobTimeRecord;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSSchedule;
import com.oasis.wolfburg.service.route.StopHelper;

@Component
public class GeneratorShiftScheduleHandler extends BaseComponent {
    private static final Log log = LogFactory.getLog(GeneratorShiftScheduleHandler.class);

    @Autowired
    private TruckRSScheduleDAO rssdao;

    @Autowired
    private TruckRSJobDAO rsJobdao;

    @Autowired
    private TruckRSJobTimeRecordDAO rsJobTimeRecorddao;

    @Autowired
    private StopHelper stopHelper;

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private static DateFormat df1 = new SimpleDateFormat("yyMMdd");

    private static int num = 31;
    
    public void handler() {

        Map<String, String> map = this.getDateMap(num + 2);
        Set<Long> ids = new HashSet<Long>();
        Calendar cal = this.getCalendar();
        long t1 = System.currentTimeMillis();

        List<TruckRSSchedule> list = rssdao.getPublishList(cal.getTime(), num - 1);

        for (TruckRSSchedule truckRSSchedule : list) {
            ids.add(truckRSSchedule.getId());

            cal.add(Calendar.DAY_OF_YEAR, -1);
            for (int k = 0; k < num; k++) {
                cal.add(Calendar.DAY_OF_YEAR, 1);
                if (isInclude(truckRSSchedule, cal, df)) {
                    // 生成TruckRSJob记录
                    TruckRSJob truckRSJob = this.getRSJob(truckRSSchedule, df1, cal);
                    Long trsJobId = rsJobdao.insert(truckRSJob);
                    String pinCode = BarCodeHelper.getPinCode(String.valueOf(trsJobId));
                    String barCode = BarCodeHelper.getBarcodeByPinCode(pinCode);
                    truckRSJob.setId(trsJobId);
                    truckRSJob.setPinCode(pinCode);
                    truckRSJob.setScanCode(barCode);
                    truckRSJob.setRsJobType(RSJobType.REGULAR);
                    rsJobdao.update(truckRSJob);

                    // 根据Stop的数量生成TruckRSJobTimeRecord记录
                    List<StopVO> stops = this.getStopsByStr(truckRSSchedule.getStopPlanTime(), k, map);

                    for (StopVO stop : stops) {
                        /**
                         * 创建TruckRSTimeRecord, 中间站点2条，头尾各一条
                         */
                        createTruckRSTimeRecord(truckRSSchedule, stop, trsJobId, pinCode, barCode, stops);
                    }
                }
            }
            cal = this.getCalendar();
        }

        if (!ids.isEmpty()) {
            List<Long> idsList = new ArrayList<Long>();
            idsList.addAll(ids);
            cal.add(Calendar.DAY_OF_YEAR, num - 1);
            rssdao.updateLastDate(idsList, cal.getTime());
        }
        long t2 = System.currentTimeMillis();
        log.info("TruckRSSchedule job run cost" + (t2 - t1) + "ms");
    }

    /**
     * 日历,只有年月日
     */
    private Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    private TruckRSJob getRSJob(TruckRSSchedule rss, DateFormat df1, Calendar cal) {
        TruckRSJob bean = new TruckRSJob();
        bean.setRsScheduleId(rss.getId());
        bean.setStartDate(cal.getTime());
        bean.setRouteId(rss.getRouteId());
        bean.setRouteName(rss.getRouteName());
        bean.setRsJobType(RSJobType.REGULAR);
        String code = rss.getName() + "-" + df1.format(cal.getTime());
        bean.setCode(code);
        return bean;
    }

    private TruckRSJobTimeRecord getRSJobInboundTimeRecord(TruckRSSchedule rss, StopVO stop, Long trsJobId, String pinCode,
            String barCode) {
        TruckRSJobTimeRecord bean = new TruckRSJobTimeRecord();
        bean.setTrsJobId(trsJobId);
        bean.setStopId(stop.getId());
        bean.setStopSeq(String.valueOf(stop.getSeqNum()));
        bean.setPlanTime(stop.getPlanInboundTime());
        bean.setPosId(stop.getPosId());
        bean.setPinCode(pinCode);
        bean.setScanCode(barCode);
        bean.setScanType(EventPhase.INBOUND.value());
        return bean;
    }

    private TruckRSJobTimeRecord getRSJobOutboundTimeRecord(TruckRSSchedule rss, StopVO stop, Long trsJobId, String pinCode,
            String barCode) {
        TruckRSJobTimeRecord bean = new TruckRSJobTimeRecord();
        bean.setTrsJobId(trsJobId);
        bean.setStopId(stop.getId());
        bean.setStopSeq(String.valueOf(stop.getSeqNum()));
        bean.setPlanTime(stop.getPlanOutboundTime());
        bean.setPosId(stop.getPosId());
        bean.setPinCode(pinCode);
        bean.setScanCode(barCode);
        bean.setScanType(EventPhase.OUTBOUND.value());
        return bean;
    }

    /**
     * 判断传进来的date是否包含于开班日内
     */
    private static boolean isInclude(TruckRSSchedule bean, Calendar cal, DateFormat df) {
        Date date = cal.getTime();

        /**
         * 传进来的时间早于开始日期或迟于结束日期,则不发班
         */
        Date beginDate = bean.getBeginDate();
        Date endDate = bean.getEndDate();
        if (date.before(beginDate) || date.after(endDate)) {
            return false;
        }

        /**
         * lastDate不为空,传进来的时间早于或等于lastDate,则不发班
         */
        Date lastDate = bean.getLastDate();
        if (lastDate != null && !date.after(lastDate)) {
            return false;
        }

        int week = cal.get(Calendar.DAY_OF_WEEK);
        if (bean.getIncludingDates().indexOf(String.valueOf(week)) == -1) {
            return false;
        }

        String text = df.format(date);
        if (bean.getExcludingDates() != null && bean.getExcludingDates().indexOf(text) != -1) {
            return false;
        }
        return true;
    }

    private Map<String, String> getDateMap(int cnt) {
    	/**
    	 * reviewer:定义成全局
    	 */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> map = new HashMap<String, String>();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        for (int i = 0; i < cnt; i++) {
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put(String.valueOf(i), df.format(cal.getTime()));
        }
        return map;
    }

    private List<StopVO> getStopsByStr(String stopPlanTime, int k, Map<String, String> map) {
    	/**
    	 * reviewer:定义成全局
    	 */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<StopVO> stops = new ArrayList<StopVO>();
        String[] arrs = stopPlanTime.split(Constants.SEMICOLON);
        for (String str : arrs) {
            String[] strs = str.split(Constants.UNDERLINE);
            StopVO stop = new StopVO();
            stop.setId(Long.valueOf(strs[0]));
            stop.setSeqNum(Integer.valueOf(strs[1]));

            String arrival = StringUtils.EMPTY;
            String leave = StringUtils.EMPTY;

            String str2 = strs[2];
            if (!str2.equals(Constants.X)) {
                str2 = String.valueOf(Integer.valueOf(str2) + k);
                arrival += map.get(str2) + " " + strs[3];
            }

            String str4 = strs[4];
            if (!str4.equals(Constants.X)) {
                str4 = String.valueOf(Integer.valueOf(str4) + k);
                leave += map.get(str4) + " " + strs[5];
            }

            try {
                if (!StringUtils.isEmpty(arrival)) {
                    stop.setPlanInboundTime(df.parse(arrival));
                }
                if (!StringUtils.isEmpty(leave)) {
                    stop.setPlanOutboundTime(df.parse(leave));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            stop.setPosId(Long.valueOf(strs[6]));
            stops.add(stop);
        }
        /**
         * order by asc
         */
        Collections.sort(stops, new StopVO());
        return stops;
    }

    /**
     * 创建临时任务单
     * 
     * @param truckRSJob
     * @return
     */
    public TruckRSJobVO generateTempTruckRSJob(TruckRSJobVO truckRSJob) {
        TruckRSSchedule truckRSSchedule = rssdao.find(truckRSJob.getRsScheduleId());
        truckRSJob.setLockVersion(0);
        Integer count = rsJobdao.onedayTempJobCount(truckRSJob.getStartDate(), truckRSJob.getRsScheduleId());
        String code = truckRSSchedule.getName() + "-" + df1.format(truckRSJob.getStartDate()) + "_L" + (count + 1);
        truckRSJob.setCode(code);
        if (truckRSJob.getTruckId() != 0) {
            truckRSJob.setStatus(RSJobStatus.PLANED);
        } else {
            truckRSJob.setStatus(RSJobStatus.NEW);
        }
        Long trsJobId = rsJobdao.insert(dozer.convert(truckRSJob, TruckRSJob.class));
        TruckRSJob job = rsJobdao.find(trsJobId);

        String pinCode = BarCodeHelper.getPinCode(String.valueOf(trsJobId));
        String barCode = BarCodeHelper.getBarcodeByPinCode(pinCode);
        job.setPinCode(pinCode);
        job.setScanCode(barCode);
        job.setRsJobType(RSJobType.TEMP);
        rsJobdao.update(job);
        // 根据Stop的数量生成TruckRSJobTimeRecord记录
        List<StopVO> stops = stopHelper.getStopsByStr(truckRSSchedule.getStopPlanTime(), truckRSJob.getStartDate());
        for (StopVO stop : stops) {
            /**
             * 创建TruckRSTimeRecord, 中间站点2条，头尾各一条
             */
            createTruckRSTimeRecord(truckRSSchedule, stop, trsJobId, pinCode, barCode, stops);
        }
        return dozer.convert(job, TruckRSJobVO.class);
    }

    /**
     * 创建紧急任务单
     * 
     * @param truckRSJob
     * @return
     */
    public TruckRSJobVO generateEmergentTruckRSJob(TruckRSJobVO truckRSJob) {
        TruckRSSchedule truckRSSchedule = rssdao.find(truckRSJob.getRsScheduleId());
        truckRSJob.setLockVersion(0);
        Integer count = rsJobdao.onedayEmJobCount(truckRSJob.getStartDate(), truckRSJob.getRsScheduleId());
        String code = truckRSSchedule.getName() + "-" + df1.format(truckRSJob.getStartDate()) + "_E" + (count + 1);
        String startStop = truckRSJob.getRouteName();
        List<StopVO> stops = stopHelper.getStopsByStr(truckRSSchedule.getStopPlanTime(), truckRSJob.getStartDate());
        String endStop = stops.get(stops.size() - 1).getPosName();
        truckRSJob.setRouteName(startStop + "--" + endStop);
        truckRSJob.setCode(code);
        if (truckRSJob.getTruckId() != 0) {
            truckRSJob.setStatus(RSJobStatus.DISPATCHED);
        } else
            truckRSJob.setStatus(RSJobStatus.NEW);
        truckRSJob.setRsJobType(RSJobType.EMERGENCY);
        long id = rsJobdao.insert(dozer.convert(truckRSJob, TruckRSJob.class));
        truckRSJob.setId(id);
        return truckRSJob;
    }

    private void createTruckRSTimeRecord(TruckRSSchedule truckRSSchedule, StopVO stop, Long trsJobId, String pinCode,
            String barCode, List<StopVO> stops) {
        if (stop.getId() == stops.get(0).getId()) {
            TruckRSJobTimeRecord truckRSJobOutboundTimeRecord = this.getRSJobOutboundTimeRecord(truckRSSchedule, stop, trsJobId,
                    pinCode, barCode);
            rsJobTimeRecorddao.insert(truckRSJobOutboundTimeRecord);
            return;
        }
        if (stop.getId() == stops.get(stops.size() - 1).getId()) {
            TruckRSJobTimeRecord truckRSJobInboundTimeRecord = this.getRSJobInboundTimeRecord(truckRSSchedule, stop, trsJobId,
                    pinCode, barCode);
            rsJobTimeRecorddao.insert(truckRSJobInboundTimeRecord);
            return;
        }
        TruckRSJobTimeRecord truckRSJobInboundTimeRecord = this.getRSJobInboundTimeRecord(truckRSSchedule, stop, trsJobId, pinCode,
                barCode);
        rsJobTimeRecorddao.insert(truckRSJobInboundTimeRecord);
        TruckRSJobTimeRecord truckRSJobOutboundTimeRecord = this.getRSJobOutboundTimeRecord(truckRSSchedule, stop, trsJobId,
                pinCode, barCode);
        rsJobTimeRecorddao.insert(truckRSJobOutboundTimeRecord);
    }

}
