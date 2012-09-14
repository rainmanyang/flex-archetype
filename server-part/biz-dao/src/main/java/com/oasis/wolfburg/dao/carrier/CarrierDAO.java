package com.oasis.wolfburg.dao.carrier;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.carrier.CarrierSO;
import com.oasis.wolfburg.model.carrier.Carrier;

public interface CarrierDAO extends DAO<Carrier> { 
	
    List<Carrier> getPaginatedList(CarrierSO carrierSO);
    
    int getPaginatedListCount(CarrierSO carrierSO);
    
    List<Carrier> checkDuplication(CarrierSO carrierSO);

}
