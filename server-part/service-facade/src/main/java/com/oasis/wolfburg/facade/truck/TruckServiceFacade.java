package com.oasis.wolfburg.facade.truck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.service.truck.TruckService;
import com.oasis.wolfburg.common.so.truck.TruckSO;
import com.oasis.wolfburg.common.vo.truck.TruckVO;

@RemotingDestination
@Service
public class TruckServiceFacade {
	
//    @Autowired
    private TruckService truckService;
    
    public PageList<TruckVO> getPageList(ClientContext clientContext, TruckSO truckSO) {
		return truckService.getPageList(clientContext, truckSO);
	}
    
    public TruckVO findTruck(ClientContext clientContext, Long truckId) {
		return truckService.findTruck(clientContext, truckId);
	}
    
    public Long createAllTruckInfo(ClientContext clientContext, TruckVO truckVO) {
		return truckService.createAllTruckInfo(clientContext, truckVO);
	}
    
    public TruckVO updateAllTruckInfo(ClientContext clientContext, TruckVO truckVO) {
    	return truckService.updateAllTruckInfo(clientContext, truckVO);
	}
    
    public void batchUpdateTruckStatus(ClientContext clientContext, List<Long> truckIdList,TruckStatus truckStatus){
	    truckService.batchUpdateTruckStatus(clientContext, truckIdList,truckStatus);
    }
    
    public TruckVO updateRunningStatus(ClientContext clientContext, TruckVO truckVO, String desc) {
    	return truckService.updateRunningStatus(clientContext, truckVO, desc);
	}
    
    public TruckVO updateTruckStatus(ClientContext clientContext, TruckVO truckVO, String desc) {
    	return truckService.updateTruckStatus(clientContext, truckVO, desc);
	}
    
    public TruckVO updateResourceType(ClientContext clientContext, TruckVO truckVO, String desc) {
    	return truckService.updateResourceType(clientContext, truckVO, desc);
	}
}
