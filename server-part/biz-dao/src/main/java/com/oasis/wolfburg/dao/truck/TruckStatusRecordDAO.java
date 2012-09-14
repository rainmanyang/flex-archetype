package com.oasis.wolfburg.dao.truck;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.truck.TruckStatusRecordSO;
import com.oasis.wolfburg.model.truck.TruckStatusRecord;

public interface TruckStatusRecordDAO extends DAO<TruckStatusRecord> {
	
    public List<TruckStatusRecord> getPaginatedList(TruckStatusRecordSO truckStatusRecordSO);

    public int getPaginatedListCount(TruckStatusRecordSO truckStatusRecordSO);
	
}
