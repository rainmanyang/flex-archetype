package com.oasis.wolfburg.facade.truck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.wolfburg.common.service.truck.TruckRSJobService;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobVO;

@RemotingDestination
@Service
public class TruckRSJobServiceFacade {

//	@Autowired
	private TruckRSJobService truckRSJobService;

	public TruckRSJobVO findTruckRSJob(ClientContext clientContext, Long rsJobId) {
		return truckRSJobService.findTruckRSJob(clientContext, rsJobId);
	}

	public List<TruckRSJobVO> getTruckRSJobListBySO(
			ClientContext clientContext, TruckRSJobSO so) {
		List<TruckRSJobVO> list = truckRSJobService.getTruckRSJobListBySO(clientContext, so);
		return list;
	}

	public TruckRSJobVO assignTruck2RSJob(ClientContext clientContext,
			TruckRSJobVO rsJobVO) {
		return truckRSJobService.assignTruck2RSJob(clientContext, rsJobVO);
	}
	
    public TruckRSJobVO publish(ClientContext clientContext,TruckRSJobVO job) {
    
        return truckRSJobService.publish(clientContext, job);
    }
    
    public List<TruckRSJobVO> getCalendarByRs(ClientContext clientContext,Long rsId){
        return truckRSJobService.getCalendarByRs(clientContext, rsId);
    }
    
    public TruckRSJobVO terminatJob(ClientContext clientContext,Long id) {
        return truckRSJobService.terminatJob(clientContext,id);
    }
    
    public TruckRSJobVO cancleJob(ClientContext clientContext,Long id) {
        return truckRSJobService.cancleJob(clientContext,id);
    }
    
    public TruckRSJobVO generateTempTruckRSJob(ClientContext clientContext,TruckRSJobVO truckRSJob) {
        return truckRSJobService.generateTempTruckRSJob(clientContext,truckRSJob);
    }
    
    public TruckRSJobVO generateEmergentTruckRSJob(ClientContext clientContext,TruckRSJobVO truckRSJob) {
        return truckRSJobService.generateEmergentTruckRSJob(clientContext,truckRSJob);
    }
    
    public void batchArrange(ClientContext clientContext,List<Integer>truckList,List<Long> rsList) {
        truckRSJobService.batchArrange(clientContext, truckList, rsList);
    }
}
