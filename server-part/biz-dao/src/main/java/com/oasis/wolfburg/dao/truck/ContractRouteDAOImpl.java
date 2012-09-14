package com.oasis.wolfburg.dao.truck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.truck.TruckSO;
import com.oasis.wolfburg.model.route.Route;
import com.oasis.wolfburg.model.truck.ContractRoute;

@Repository
public class ContractRouteDAOImpl extends BaseDAO<ContractRoute> implements ContractRouteDAO {
	
	private static final String LIST_CONTRACT_ROUTE = ".listContractRoute4truckId";
	
	private static final String LIST_CONTRACT_ROUTE_4TRUCKIDLIST = ".listContractRoute4truckIdList";

	@Override
	public void deleteContractRoute(ContractRoute contractRoute) {
	}

	@Override
	public List<Route> listContractRoute(TruckSO truckSO) {
		 return super.getPaginatedList(truckSO);
	}

	@Override
	public int listContractRouteCount(TruckSO truckSO) {
		return super.getPaginatedListCount(truckSO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Route> listContractRoute4truckId(Long truckId) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("truckId", truckId);
		return (List<Route>) super.getSession().selectList(getStatementNamespace()+ LIST_CONTRACT_ROUTE, map);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Route> listContractRoute4TruckIdList(List<Long> truckIdList) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("truckIdList", truckIdList);
		return (List<Route>) super.getSession().selectList(getStatementNamespace()+ LIST_CONTRACT_ROUTE_4TRUCKIDLIST, map);
	}
	

}
