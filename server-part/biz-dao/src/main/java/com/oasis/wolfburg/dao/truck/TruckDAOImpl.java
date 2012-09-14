package com.oasis.wolfburg.dao.truck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.truck.TruckSO;
import com.oasis.wolfburg.model.truck.Truck;

@Repository
public class TruckDAOImpl extends BaseDAO<Truck> implements TruckDAO {
	
    private static final String CHECK_DUPLICATION = ".checkDuplication";
    
    private static final String CHECK_IDCODE = ".checkIdCard";
    
    public int checkDuplication(Truck truck) {
        return (Integer)getSession().selectOne(getStatementNamespace() + CHECK_DUPLICATION, truck);
    }

    public List<Truck> getPaginatedList(TruckSO truckSO) {
        return super.getPaginatedList(truckSO);
    }

    public int getPaginatedListCount(TruckSO truckSO) {
        return super.getPaginatedListCount(truckSO);
    }

    public Truck getTruckByLicensePlate(String licensePlate) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("license_plate", licensePlate);
        return super.getModelByPara(map);
    }

	public int checkIdCard(Truck truck) {
		return (Integer)getSession().selectOne(getStatementNamespace() + CHECK_IDCODE, truck);
	}

	public Truck findTruckByLicensePlate(String licensePlate) {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("license_plate", licensePlate);
        Truck truck = getModelByPara(map);
        return truck;
	}

}
