package com.oasis.wolfburg.dao.truck;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.truck.TruckStatusRecordSO;
import com.oasis.wolfburg.model.truck.TruckStatusRecord;
@Repository
public class TruckStatusRecordDAOImpl extends BaseDAO<TruckStatusRecord> implements TruckStatusRecordDAO {
	
	@Override
    public List<TruckStatusRecord> getPaginatedList(TruckStatusRecordSO truckStatusRecordSO) {
        return super.getPaginatedList(truckStatusRecordSO);
    }

    @Override
    public int getPaginatedListCount(TruckStatusRecordSO truckStatusRecordSO) {
        return super.getPaginatedListCount(truckStatusRecordSO);
    }
	
}
