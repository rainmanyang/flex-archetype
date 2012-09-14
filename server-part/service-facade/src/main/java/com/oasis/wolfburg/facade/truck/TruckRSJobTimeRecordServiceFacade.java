package com.oasis.wolfburg.facade.truck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.truck.TruckRSJobTimeRecordService;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobTimeRecordSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobTimeRecordVO;

@RemotingDestination
@Service
public class TruckRSJobTimeRecordServiceFacade {
	
//    @Autowired
    private TruckRSJobTimeRecordService truckRSJobTimeRecordService;
	
	
	public PageList<TruckRSJobTimeRecordVO> getPageList(ClientContext clientContext, TruckRSJobTimeRecordSO so){
		
		return truckRSJobTimeRecordService.getPageList(clientContext, so);
	}
	
	public String exportToExcel(ClientContext clientContext, TruckRSJobTimeRecordSO so) throws Exception{
		return truckRSJobTimeRecordService.exportToExcel(clientContext, so);
	}
	
}
