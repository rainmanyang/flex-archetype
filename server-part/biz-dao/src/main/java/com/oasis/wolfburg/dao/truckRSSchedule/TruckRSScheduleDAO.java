package com.oasis.wolfburg.dao.truckRSSchedule;

import java.util.Date;
import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSScheduleSO;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSSchedule;

public interface TruckRSScheduleDAO extends DAO<TruckRSSchedule> {

	public List<TruckRSSchedule> getPaginatedList(TruckRSScheduleSO so);

    public int getPaginatedListCount(TruckRSScheduleSO so);
    
    @Cache(action = Cache.UPDATE_LIST)
    void updateStatus(List<Long> ids);
    
    @Cache(action = Cache.UPDATE_LIST)
    void updateLastDate(List<Long> ids,Date lastDate);
    
    List<TruckRSSchedule> getPublishList(Date lastDate,int num);
    
    int checkDuplication(TruckRSSchedule truckRSSchedule);
}
