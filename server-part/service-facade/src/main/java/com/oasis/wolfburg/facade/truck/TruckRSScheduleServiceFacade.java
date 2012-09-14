package com.oasis.wolfburg.facade.truck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.truck.TruckRSScheduleService;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSScheduleSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSScheduleVO;

@RemotingDestination
@Service
public class TruckRSScheduleServiceFacade {
	
//    @Autowired
    private TruckRSScheduleService truckRSScheduleService;
	
    public Long createTruckRSSchedule(ClientContext clientContext, TruckRSScheduleVO truckRSScheduleVO) {
    	return truckRSScheduleService.createTruckRSSchedule(clientContext, truckRSScheduleVO);
	}

    public void deleteTruckRSSchedule(ClientContext clientContext, Long id) {
    	truckRSScheduleService.deleteTruckRSSchedule(clientContext,id);
	}
	

	public void updateTruckRSSchedule(ClientContext clientContext, TruckRSScheduleVO truckRSScheduleVO) {
		truckRSScheduleService.updateTruckRSSchedule(clientContext,truckRSScheduleVO);
	}
	
	public PageList<TruckRSScheduleVO> getPageList(ClientContext clientContext, TruckRSScheduleSO so){
		return truckRSScheduleService.getPageList(clientContext, so);
	}
	
	public TruckRSScheduleVO findTruckRSSchedule(ClientContext clientContext,Long id){
		return truckRSScheduleService.findTruckRSSchedule(clientContext, id);
	}
	
	public void updateStatus(ClientContext clientContext,List<Long> ids){
		truckRSScheduleService.updateStatus(clientContext, ids);
	}
	
	public void close(ClientContext clientContext,TruckRSScheduleVO vo){
		truckRSScheduleService.closeTruckRSS(clientContext, vo);
	}
}
