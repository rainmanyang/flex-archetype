package com.oasis.wolfburg.common.service.truck;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobVO;

public interface TruckRSJobService {

//	TRSJobOrderVO getTRSJobOrderByCardCode(ClientContext clientContext,String cardCode);
//
//	TRSJobOrderVO trsJob2TRSJobOrder(ClientContext clientContext,TruckRSJobVO trsJob);

	List<TruckRSJobVO> getTruckRSJobListBySO(ClientContext clientContext,TruckRSJobSO so);

	TruckRSJobVO findTruckRSJob(ClientContext clientContext,Long rsJobId);

	TruckRSJobVO assignTruck2RSJob(ClientContext clientContext,TruckRSJobVO rsJobVO);
	
	TruckRSJobVO publish(ClientContext clientContext,TruckRSJobVO job) ;
	
	List<TruckRSJobVO> getCalendarByRs(ClientContext clientContext,Long  rsId);
	
	TruckRSJobVO terminatJob(ClientContext clientContext,Long id);
	
	TruckRSJobVO cancleJob(ClientContext clientContext,Long id);
	
	TruckRSJobVO generateTempTruckRSJob(ClientContext clientContext, TruckRSJobVO truckRSJob);
	
	TruckRSJobVO generateEmergentTruckRSJob(ClientContext clientContext, TruckRSJobVO truckRSJob);
	
	void batchArrange(ClientContext clientContext,List<Integer>truckList,List<Long> rsList);
}
