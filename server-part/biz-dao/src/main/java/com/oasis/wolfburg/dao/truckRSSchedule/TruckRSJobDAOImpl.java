package com.oasis.wolfburg.dao.truckRSSchedule;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
import com.oasis.wolfburg.common.so.truckRSSchedule.POSRSJobView;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobSO;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJob;

@Repository
public class TruckRSJobDAOImpl extends BaseDAO<TruckRSJob> implements TruckRSJobDAO {

    private final static String GET_TRUCKRSJOB_BY_CARDCODE = ".getTruckRSJobByCardCode";

    private final static String GET_TRUCKRSJOB_BY_SO = ".getTruckRSJobListBySO";

    private final static String GET_IDS = ".selectIdsByParam";

    private static final String UPDATESTATUS = ".updateStatus";

    private static final String ONEDAYTEMPJOBCOUNT = ".onedayTempJobCount";
    
    private static final String ONEDAYEMJOBCOUNT = ".onedayEmJobCount";

    private static final String GET_POS_JOBS = ".getPOSJobs";
    
    private static final String GET_NOTIFICATION_JOBS=".getNotificationJobs";

    @SuppressWarnings("unchecked")
    @Override
    public List<TruckRSJob> getTruckRSJobByCardCode(String cardCode) {
        List<TruckRSJob> ret = super.getSession().selectList(super.getStatementNamespace() + GET_TRUCKRSJOB_BY_CARDCODE, cardCode);
        return ret;
    }

    @Override
    public TruckRSJob getTruckRSJobByBarcode(String barCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SCAN_CODE", barCode);
        TruckRSJob ret = super.getModelByPara(map);
        return ret;
    }

    @Override
    public TruckRSJob getTruckRSJobByPincode(String barCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PIN_CODE", barCode);
        TruckRSJob ret = super.getModelByPara(map);
        return ret;
    }

    @SuppressWarnings("unchecked")
    public List<TruckRSJob> getTruckRSJobListBySO(TruckRSJobSO so) {
        List<TruckRSJob> ret = super.getSession().selectList(super.getStatementNamespace() + GET_TRUCKRSJOB_BY_SO, so);
        if (ret == null || ret.size() == 0) {
            return null;
        }
        return ret;
    }

    public void updateStatus(List<Long> ids, RSJobStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("ids", ids);
        super.getSession().update(getStatementNamespace() + UPDATESTATUS, map);
    }

    public List<Long> getTruckRSJobIdsByTruckRSS(Date startDate, Long rssId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("rssId", rssId);
        @SuppressWarnings("unchecked")
        List<Long> list = super.getSession().selectList(super.getStatementNamespace() + GET_IDS, map);
        return list;
    }

    public Integer onedayTempJobCount(Date startDate, Long rsScheduleId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("rsScheduleId", rsScheduleId);
        Integer ret = (Integer) super.getSession().selectOne(super.getStatementNamespace() + ONEDAYTEMPJOBCOUNT, map);
        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<POSRSJobView> getPOSRSJobs(Long posId) {
        List<POSRSJobView> ret = super.getSession().selectList(super.getStatementNamespace() + GET_POS_JOBS, posId);
        return ret;
    }
    
    @Override
    public Integer onedayEmJobCount(Date startDate, Long rsScheduleId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("rsScheduleId", rsScheduleId);
        Integer ret = (Integer) super.getSession().selectOne(super.getStatementNamespace() + ONEDAYEMJOBCOUNT, map);
        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TruckRSJob> getNotificationJobs(Date notifyDate) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notifyDate", notifyDate);
        map.put("curTime", Calendar.getInstance().getTime());
        List<TruckRSJob> ret = super.getSession().selectList(super.getStatementNamespace() + GET_NOTIFICATION_JOBS, map);
        return ret;
    }
    
}
