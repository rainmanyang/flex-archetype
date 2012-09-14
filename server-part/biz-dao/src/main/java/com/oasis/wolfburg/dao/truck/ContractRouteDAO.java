package com.oasis.wolfburg.dao.truck;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.truck.TruckSO;
import com.oasis.wolfburg.model.route.Route;
import com.oasis.wolfburg.model.truck.ContractRoute;

public interface ContractRouteDAO extends DAO<ContractRoute> {
	
    List<Route> listContractRoute(TruckSO truckSO);
    
    int listContractRouteCount(TruckSO truckSO);
    
    void deleteContractRoute(ContractRoute contractRoute);
    
    List<Route> listContractRoute4truckId(Long truckId);
    
    List<Route> listContractRoute4TruckIdList(List<Long> truckIdList);

}
