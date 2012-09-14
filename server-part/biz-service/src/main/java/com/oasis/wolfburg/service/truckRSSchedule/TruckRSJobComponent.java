package com.oasis.wolfburg.service.truckRSSchedule;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oasis.tmsv5.common.util.web.DateUtils;
import com.oasis.tmsv5.dao.base.PredefinedCodeDAO;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.EnumDispHelper;
import com.oasis.tmsv5.service.helper.ResourceDispHelper;
import com.oasis.tmsv5.service.message.MailMessageSender;
import com.oasis.tmsv5.util.exception.GLException;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.tmsv5.util.helper.BarCodeHelper;
import com.oasis.wolfburg.common.enums.status.ClientException;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.type.EventPhase;
import com.oasis.wolfburg.common.enums.type.RSJobType;
import com.oasis.wolfburg.common.so.truckRSSchedule.POSRSJobView;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobSO;
import com.oasis.wolfburg.common.vo.client.TRSJobOrder;
import com.oasis.wolfburg.common.vo.client.TRSStop;
import com.oasis.wolfburg.common.vo.route.StopVO;
import com.oasis.wolfburg.common.vo.system.Mail;
import com.oasis.wolfburg.common.vo.system.NotifyMail;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobVO;
import com.oasis.wolfburg.dao.route.PosDAO;
import com.oasis.wolfburg.dao.trackRecord.TrackRecordDAO;
import com.oasis.wolfburg.dao.truck.TruckDAO;
import com.oasis.wolfburg.dao.truck.TruckStatusRecordDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSScheduleDAO;
import com.oasis.wolfburg.model.route.POS;
import com.oasis.wolfburg.model.trackRecord.TrackRecord;
import com.oasis.wolfburg.model.truck.Truck;
import com.oasis.wolfburg.model.truck.TruckStatusRecord;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJob;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSSchedule;
import com.oasis.wolfburg.service.mail.MailHelper;
import com.oasis.wolfburg.service.route.StopHelper;
import com.oasis.wolfburg.service.trackrecord.TrackRecordHelper;
import com.oasis.wolfburg.service.truck.TruckStatusRecordHelper;

@Component
public class TruckRSJobComponent extends BaseComponent {

    @Autowired
    private TruckRSJobDAO truckRSJobDAO;

    @Autowired
    private TruckRSScheduleDAO truckRSScheduleDAO;

    @Autowired
    private TruckStatusRecordDAO truckStatusRecordDAO;

    @Autowired
    private TruckDAO truckDAO;

    @Autowired
    private TrackRecordDAO trackRecordDAO;

    @Autowired
    private PosDAO posDAO;

    @Autowired
    private TruckRSScheduleDAO truckRsScheduleDAO;

    @Autowired
    private PredefinedCodeDAO predefinedCodeDAO;

    @Autowired
    private StopHelper stopHelper;

    @Autowired
    private MailHelper mailHelper;

    @Autowired(required=false)
    private MailMessageSender mailSender;

    private TRSJobOrder trsJob2TRSJobOrder(TruckRSJob trsJob) {
        TRSJobOrder jobOrder = super.dozer.convert(trsJob, TRSJobOrder.class);
        TruckRSSchedule truckRSSchedule = truckRSScheduleDAO.find(trsJob.getRsScheduleId());
        String stopPlanTime = truckRSSchedule.getStopPlanTime();
        List<StopVO> stops = stopHelper.getStopsByStr(stopPlanTime, trsJob.getStartDate());
        List<TRSStop> trsStops = new ArrayList<TRSStop>();
        for (StopVO stop : stops) {
            TRSStop trsStop = new TRSStop();
            trsStop.setId(stop.getPosId());
            trsStop.setName(stop.getPosName());
            trsStop.setInBoundTime(stop.getPlanInboundTime());
            trsStop.setOutBoundTime(stop.getPlanOutboundTime());
            trsStop.setSeqNum(stop.getSeqNum());

            POS pos = posDAO.find(stop.getPosId());
            trsStop.setContactPhone(pos.getContactPhone());
            trsStop.setContactPerson(pos.getContactPerson());
            trsStop.setRoadMap(pos.getRoadMap());
            trsStop.setCity(pos.getCity());
            trsStop.setPrivince(pos.getPrivince());
            trsStop.setAddress(pos.getAddress());
            trsStop.setGps(pos.getGps());

            trsStops.add(trsStop);
        }

        jobOrder.setStops(trsStops);
        /**
         * 车型
         */
        if (trsJob.getTruckId() != null) {
            Truck truck = truckDAO.find(trsJob.getTruckId());
            String preCode = truck.getTruckType().getValue();
            jobOrder.setTruckType(predefinedCodeDAO.getCachePredefinedCodeByCode(preCode).getDescription());
        }
        jobOrder.setTrsCode(truckRSSchedule.getName());
        jobOrder.setLicence(trsJob.getLicensePlate());
        jobOrder.setJobType(EnumDispHelper.getInstance().getValue(trsJob.getRsJobType().name()));
        return jobOrder;
    }

    public List<TruckRSJobVO> getTruckRSJobListBySO(TruckRSJobSO so) {
        List<TruckRSJob> rsJobList = truckRSJobDAO.getTruckRSJobListBySO(so);
        List<TruckRSJobVO> result = super.dozer.convertList(rsJobList, TruckRSJobVO.class);
        return result;
    }

    public TruckRSJobVO findTruckRSJob(Long rsJobId) {
        TruckRSJob rsJob = truckRSJobDAO.find(rsJobId);
        TruckRSJobVO result = super.dozer.convert(rsJob, TruckRSJobVO.class);
        return result;
    }

    public TruckRSJobVO assignTruck2RSJob(TruckRSJobVO rsJobVO) {
        // 1.得到原job
        boolean isChangeTruck = Boolean.FALSE;
        TruckRSJob oldRSJob = truckRSJobDAO.find(rsJobVO.getId());
        // 2.检查是否需要进入换车流程
        if (oldRSJob.getLicensePlate() != null && !oldRSJob.getLicensePlate().equalsIgnoreCase(rsJobVO.getLicensePlate())) {
            // 换车流程
        	changeTruck4RSJobChanged(oldRSJob);
            isChangeTruck = Boolean.TRUE;
        }
        // 3.更新job信息
        oldRSJob.setLicensePlate(rsJobVO.getLicensePlate());
        oldRSJob.setTruckId(rsJobVO.getTruckId());
        oldRSJob.setDriver(rsJobVO.getDriver());
        oldRSJob.setIdentityCard(rsJobVO.getIdentityCard());
        oldRSJob.setStatus(rsJobVO.getStatus());
        
        oldRSJob = truckRSJobDAO.update(oldRSJob);
        // 4.更新车辆信息
        updateTruckInfoByRSJob(oldRSJob);
        TruckRSJobVO ret = dozer.convert(oldRSJob, TruckRSJobVO.class);
        if (isChangeTruck) {
        	//通知车主
            sendMessage(rsJobVO);
            // 記錄trackRecord
            TrackRecord po = TrackRecordHelper.logTrackRecord(oldRSJob,EventPhase.CHANGEVECHICLE);
            trackRecordDAO.insert(po);
        } else {
        	if(rsJobVO.getRsJobType().equals(RSJobType.TEMP)) {
               	//通知车主
               	sendMessage(rsJobVO);
            }
               // 記錄trackRecord
        	   TrackRecord po = TrackRecordHelper.logTrackRecord(oldRSJob,EventPhase.ASSIGNVECHICLE);
               trackRecordDAO.insert(po);
        }
        return ret;
    }

    private void sendMessage(TruckRSJobVO rsJobVO) {
        /**
         * whom to send
         */
        Set<Mail> mailSet = new HashSet<Mail>();
        Mail mail = new Mail();
        Truck truck = truckDAO.find(rsJobVO.getTruckId());
        TruckRSSchedule rs = truckRsScheduleDAO.find(rsJobVO.getRsScheduleId());
        mail.setPhoneCode(truck.getContactPhone1());
        mailSet.add(mail);
        /**
         * title is
         */
        String notifyTitle = truck.getLicensePlate();
        /**
         * what content is
         */
        List<StopVO> stops = stopHelper.getStopsByStr(rs.getStopPlanTime(), rsJobVO.getStartDate());
        String content = ResourceDispHelper.getInstance().getValue("TRUCKRSJOB_MESSAGE");
		Object[] objs = new Object[] {
				truck.getLicensePlate(),
				DateUtils.formatDate(rsJobVO.getStartDate()),
				rs.getRouteName(),
				DateUtils.formatDateTime(stops.get(0).getPlanOutboundTime()),
				DateUtils.formatDateTime(stops.get(stops.size() - 1).getPlanInboundTime()) };
		content = MessageFormat.format(content, objs);
//        NotifyMail notifyMail = mailHelper.getPhoneNotifyMail(mailSet, notifyTitle, content);
//        mailSender.send(notifyMail);
    }

    private void changeTruck4RSJobChanged(TruckRSJob oldRSJob) {
        // 1.得到原车辆信息
        Long truckId = oldRSJob.getTruckId();
        // 2.比较原状态信息和TruckRunningStatus.FREE
        Truck truck = truckDAO.find(truckId);
        // 3.存入状态信息
        truck.setRunningStatus(TruckRunningStatus.FREE);
        truck.setPlaned(truck.getPlaned() - 1);
        // 4.更新车辆信息
        truckDAO.update(truck);
        // 5.更新车辆跟踪信息
        TruckStatusRecord truckStatusRecord = 
        	TruckStatusRecordHelper.logStatusRecored(truck, TruckStatusRecordHelper.CHANGE_TRUCK, null);
        truckStatusRecordDAO.insert(truckStatusRecord);
        
    }

    private void updateTruckInfoByRSJob(TruckRSJob rsJob) {
    	Long truckId = rsJob.getTruckId();
        Truck truck = truckDAO.find(truckId);
    	updateTruckPlanedAndRunningStatus(truck, rsJob.getStatus());
    	truckDAO.update(truck);
    }

    private void updateTruckPlanedAndRunningStatus(Truck truck, RSJobStatus status) {
        changeRunningStatus(truck, status);
        if (TruckRunningStatus.FREE.equals(truck.getRunningStatus())) {
            truck.setPlaned(truck.getPlaned() - 1);
        }
    }

    private void changeRunningStatus(Truck truck, RSJobStatus status) {
        switch (status) {
        case PLANED:
            truck.setPlaned(truck.getPlaned() + 1);
            break;
        case DISPATCHED:
            truck.setRunningStatus(TruckRunningStatus.READY);
            // TODO:短信提醒
            break;
        case ENROUTE:
            truck.setRunningStatus(TruckRunningStatus.ENROUTE);
            break;
        case ARRIEVED:
            truck.setRunningStatus(TruckRunningStatus.ARRIVAL);
            break;
        case TERMINATED:
        case CANCLED:
            truck.setRunningStatus(TruckRunningStatus.FREE);
            truck.setPlaned(truck.getPlaned() - 1);
            break;
        default:
            break;
        }
    }

    public TruckRSJobVO terminatJob(Long id) {
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        truckRSJobDAO.updateStatus(ids, RSJobStatus.TERMINATED);

        TruckRSJob rsJob = truckRSJobDAO.find(id);

        /**
         * 记录trackrecord
         */
        TrackRecord po = TrackRecordHelper.logTrackRecord(rsJob,EventPhase.TERMINATE);
        trackRecordDAO.insert(po);

        return dozer.convert(rsJob, TruckRSJobVO.class);
    }

    public TruckRSJobVO cancleJob(Long id) {
        TruckRSJob rsJob = truckRSJobDAO.find(id);

        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        rsJob.setStatus(RSJobStatus.CANCLED);
        truckRSJobDAO.updateStatus(ids, RSJobStatus.CANCLED);
        rsJob = truckRSJobDAO.find(id);

        return dozer.convert(rsJob, TruckRSJobVO.class);
    }

    /**
     * 任务单发布
     * 
     * @param rsJob
     * @return
     */
    public TruckRSJobVO publish(TruckRSJobVO rsJob) {
    	if (!RSJobStatus.NEW.equals(rsJob.getStatus()) && !RSJobStatus.PLANED.equals(rsJob.getStatus())) {
    		throw new ValidationException("WRONG_STATUS");
    	}
    	TruckRSJob po = truckRSJobDAO.find(rsJob.getId());
        po.setStatus(RSJobStatus.DISPATCHED);
        po = truckRSJobDAO.update(po);
        rsJob = getDozer().convert(po, TruckRSJobVO.class);
        Truck truck = truckDAO.find(rsJob.getTruckId());
        /**
         * 发布仅在车辆状态为free时改变车辆状态
         */
        changeRunningStatus(truck, rsJob.getStatus());
        truckDAO.update(truck);

        /**
         * 记录trackrecord
         */
        TrackRecord tr = TrackRecordHelper.logTrackRecord(po,EventPhase.PUBLISH);
        trackRecordDAO.insert(tr);
        return rsJob;
    }

    public List<TRSJobOrder> getTRSJobOrderListByCardCode(String cardCode) {
        List<TruckRSJob> trsJobList = truckRSJobDAO.getTruckRSJobByCardCode(cardCode);
        List<TRSJobOrder> orderList = new ArrayList<TRSJobOrder>();
        if (trsJobList.size() > 0) {
            for (TruckRSJob job : trsJobList) {
                orderList.add(trsJob2TRSJobOrder(job));
            }
            setDefaultOrder(orderList);
        }

        return orderList;
    }

    /**
     * 
     * 设置默认打印任务单
     */
    private void setDefaultOrder(List<TRSJobOrder> orderList) {
        /**
         * 当天优先
         */
        boolean todayOrder = false;
        for (TRSJobOrder jobOrder : orderList) {
            Calendar cal = Calendar.getInstance();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(jobOrder.getStartDate());
            if (cal.get(Calendar.DAY_OF_YEAR) == cal1.get(Calendar.DAY_OF_YEAR)) {
                jobOrder.setDefaultOrder(true);
                todayOrder = true;
                return;
            }
        }
        /**
         * 'DISPATCHED' 优先
         */
        boolean dispatchedOrder = false;
        if (!todayOrder) {
            for (TRSJobOrder jobOrder : orderList) {
                if (RSJobStatus.DISPATCHED == jobOrder.getStatus()) {
                    jobOrder.setDefaultOrder(true);
                    dispatchedOrder = true;
                    return;
                }
            }
        }

        /**
         * PLANED 优先
         */
        boolean planOrder = false;
        if (!dispatchedOrder) {
            for (TRSJobOrder jobOrder : orderList) {
                if (RSJobStatus.PLANED == jobOrder.getStatus()) {
                    jobOrder.setDefaultOrder(true);
                    planOrder = true;
                    return;
                }
            }
        }
        /**
         * 'ENROUTE' 优先
         */
        boolean enrouteOrder = false;
        if (!planOrder) {
            for (TRSJobOrder jobOrder : orderList) {
                if (RSJobStatus.ENROUTE == jobOrder.getStatus()) {
                    jobOrder.setDefaultOrder(true);
                    enrouteOrder = true;
                    return;
                }
            }
        }
        /**
         * 随便填一个
         */
        if (!enrouteOrder) {
            orderList.get(0).setDefaultOrder(true);
        }

    }

    public TruckRSJob generateTruckRSJob(TruckRSJob truckRSJob, TruckRSSchedule truckRSSchedule) {
        Long trsJobId = truckRSJobDAO.insert(truckRSJob);
        String pinCode = BarCodeHelper.getPinCode(String.valueOf(trsJobId));
        String barCode = BarCodeHelper.getBarcodeByPinCode(pinCode);
        truckRSJob.setPinCode(pinCode);
        truckRSJob.setScanCode(barCode);
        truckRSJob = truckRSJobDAO.update(truckRSJob);
        // 根据Stop的数量生成TruckRSJobTimeRecord记录
        // List<StopVO> stops =
        // this.getStopsByStr(truckRSSchedule.getStopPlanTime(), k, map);
        // for (StopVO stop : stops) {
        // TruckRSJobTimeRecord truckRSJobTimeRecord =
        // this.getRSJobTimeRecord(truckRSSchedule, stop, trsJobId, pinCode,
        // barCode);
        // truckRSJobTimeRecordDAO.insert(truckRSJobTimeRecord);
        // }
        return truckRSJob;
    }

    /**
     * 获取此班次已排班日历
     * 
     * @param rsId
     * @return
     */
    public List<TruckRSJobVO> getCalendarByRs(Long rsId) {
        TruckRSJobSO so = new TruckRSJobSO();
        setDateSpan(so);
        so.setStatuses(RSJobStatus.getCalendarStatus());
        so.setRsScheduleId(rsId);
        return getDozer().convertList(truckRSJobDAO.getTruckRSJobListBySO(so), TruckRSJobVO.class);
    }

    private void setDateSpan(TruckRSJobSO so) {
        Date start = new Date();
        Date end = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -(Calendar.DAY_OF_WEEK + 6));
        start = cal.getTime();
        cal.setTime(start);
        /**
         * 根据前台显示规则+42
         */
        cal.add(Calendar.DAY_OF_MONTH, 41);
        end = cal.getTime();
        so.setStartDate(start);
        so.setEndDate(end);
    }

    public void printTSTaskOrderDone(Long jobId) {
        TruckRSJob job = truckRSJobDAO.find(jobId);
        if (job == null) {
            throw new GLException(ClientException.JOB_NOT_FOUND);
        }
        job.setPrintCount(job.getPrintCount() + 1);
        truckRSJobDAO.update(job);

    }

    public List<POSRSJobView> getPOSRSJobs(Long posId) {
        return truckRSJobDAO.getPOSRSJobs(posId);
    }

    public void batchArrange(List<Integer> truckIdList, List<Long> rsIdList) {

        int truckSize = truckIdList.size();
        List<Truck> truckList = new ArrayList<Truck>();
        /**
         * reviewer：可以使用getList方法避免for
         */
        for(Integer id:truckIdList){
            truckList.add(truckDAO.find(Long.valueOf(id.toString())));
        }
        List<TruckRSJob> rsList = truckRSJobDAO.getListByIds(rsIdList);
        for (int i = 0; i < rsList.size(); i++) {
            TruckRSJob rs = rsList.get(i);
            Truck truck = truckList.get(i % truckSize);
            rs.setLicensePlate(truck.getLicensePlate());
            rs.setIdentityCard(truck.getCardCode());
            rs.setTruckId(truck.getId());
            rs.setDriver(truck.getDriver1Name());
            // 如果任务单未派车，改变任务单状态为计划中
            // 其他状态更改车辆不改变任务单状态
            if (rs.getStatus().equals(RSJobStatus.NEW)) {
                rs.setStatus(RSJobStatus.PLANED);
            }
            // 修改任务单状态
            assignTruck2RSJob(getDozer().convert(rs, TruckRSJobVO.class));
        }

    }

}
