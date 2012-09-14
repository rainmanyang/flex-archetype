package com.oasis.wolfburg.dao.truck;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.truck.TruckSO;
import com.oasis.wolfburg.model.truck.Truck;

public interface TruckDAO extends DAO<Truck> { 
	
    List<Truck> getPaginatedList(TruckSO truckSO);
    
    int getPaginatedListCount(TruckSO truckSO);
    
    int checkDuplication(Truck truck);
    
    Truck getTruckByLicensePlate(String licensePlate);
    
    int checkIdCard(Truck truck);
    
    Truck findTruckByLicensePlate(String licensePlate);

}
