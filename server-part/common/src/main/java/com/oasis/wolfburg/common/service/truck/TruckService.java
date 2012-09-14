package com.oasis.wolfburg.common.service.truck;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.so.truck.TruckSO;
import com.oasis.wolfburg.common.vo.route.RouteVO;
import com.oasis.wolfburg.common.vo.truck.ContractRouteVO;
import com.oasis.wolfburg.common.vo.truck.TruckVO;

public interface TruckService {
	
	TruckVO findTruck(ClientContext clientContext, Long truckId);
	
	Long createAllTruckInfo(ClientContext clientContext, TruckVO truckVO);
	
	TruckVO updateAllTruckInfo(ClientContext clientContext, TruckVO truckVO) ;
	
	void addContractRoute(ClientContext clientContext, ContractRouteVO contractRouteVO) ;
	
	void deleteContractRoute(ClientContext clientContext, ContractRouteVO contractRouteVO);
	
	PageList<RouteVO> listContractRoute(ClientContext clientContext, Long truckId) ;

	int deleteTruck(ClientContext clientContext, Long id) ;

	PageList<TruckVO> getPageList(ClientContext clientContext, TruckSO truckSO) ;
	
	void batchUpdateTruckStatus(ClientContext clientContext, List<Long> truckIdList,TruckStatus truckStatus);
	
	TruckVO updateRunningStatus(ClientContext clientContext, TruckVO truckVO, String desc);
	
	TruckVO updateTruckStatus(ClientContext clientContext, TruckVO truckVO, String desc);
	 
	TruckVO updateResourceType(ClientContext clientContext, TruckVO truckVO, String desc);

}
