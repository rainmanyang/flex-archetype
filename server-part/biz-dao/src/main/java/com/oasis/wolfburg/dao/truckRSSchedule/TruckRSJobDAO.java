package com.oasis.wolfburg.dao.truckRSSchedule;

import java.util.Date;
import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
import com.oasis.wolfburg.common.so.truckRSSchedule.POSRSJobView;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobSO;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJob;

public interface TruckRSJobDAO extends DAO<TruckRSJob> {

    List<TruckRSJob> getTruckRSJobByCardCode(String cardCode);

    TruckRSJob getTruckRSJobByBarcode(String barCode);

    TruckRSJob getTruckRSJobByPincode(String barCode);

    List<TruckRSJob> getTruckRSJobListBySO(TruckRSJobSO so);

    List<Long> getTruckRSJobIdsByTruckRSS(Date startDate, Long rssId);

    @Cache(action = Cache.UPDATE_LIST)
    void updateStatus(List<Long> ids, RSJobStatus status);

    Integer onedayTempJobCount(Date startDate, Long rsScheduleId);

    Integer onedayEmJobCount(Date startDate, Long rsScheduleId);

    List<POSRSJobView> getPOSRSJobs(Long posId);

    List<TruckRSJob> getNotificationJobs(Date notifyDate);

}
