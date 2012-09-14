package com.oasis.wolfburg.facade.truck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.truck.TruckStatusRecordService;
import com.oasis.wolfburg.common.so.truck.TruckStatusRecordSO;
import com.oasis.wolfburg.common.vo.truck.TruckStatusRecordVO;

@RemotingDestination
@Service
public class TruckStatusRecordServiceFacade {
	
//	@Autowired
	private TruckStatusRecordService truckStatusRecordService;

	public Long createTruckStatusRecord(ClientContext clientContext, TruckStatusRecordVO truckStatusRecordVO) {
		return truckStatusRecordService.createTruckStatusRecord(clientContext, truckStatusRecordVO);
	}

	public TruckStatusRecordVO findTruckStatusRecord(ClientContext clientContext, Long truckStatusRecordId) {
		return truckStatusRecordService.findTruckStatusRecord(clientContext, truckStatusRecordId);
	}

	public PageList<TruckStatusRecordVO> getPageList(ClientContext clientContext, TruckStatusRecordSO truckStatusRecordSO) {
		return truckStatusRecordService.getPageList(clientContext, truckStatusRecordSO);
	}

	public void updateTruckStatusRecord(ClientContext clientContext, TruckStatusRecordVO truckStatusRecordVO) {
		truckStatusRecordService.updateTruckStatusRecord(clientContext, truckStatusRecordVO);
	}

	public TruckStatusRecordVO viewTruckStatusRecord(ClientContext clientContext, Long truckStatusRecordId) {
		return truckStatusRecordService.viewTruckStatusRecord(clientContext, truckStatusRecordId);
	}

}
