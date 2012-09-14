package com.oasis.wolfburg.facade.truck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.truck.ClientBarcodeRecordService;
import com.oasis.wolfburg.common.so.truckRSSchedule.ClientBarcodeRecordSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.ClientBarcodeRecordVO;

@RemotingDestination
@Service
public class ClientBarcodeRecordServiceFacade {

//	@Autowired
	private ClientBarcodeRecordService clientBarcodeRecordService;

	 public PageList<ClientBarcodeRecordVO> getPageList(ClientContext clientContext, ClientBarcodeRecordSO so) {
	        return clientBarcodeRecordService.getPageList(clientContext, so);
	    }

}
