package com.oasis.wolfburg.facade.carrier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.CarrierStatus;
import com.oasis.wolfburg.common.service.carrier.CarrierService;
import com.oasis.wolfburg.common.so.carrier.CarrierSO;
import com.oasis.wolfburg.common.vo.carrier.CarrierVO;

@RemotingDestination
@Service
public class CarrierServiceFacade {

//	@Autowired
	private CarrierService carrierService;

	public Long createCarrier(ClientContext clientContext, CarrierVO carrierVO) {
		return carrierService.createCarrier(clientContext, carrierVO);
	}

	public int deleteCarrier(ClientContext clientContext, Long id) {
		return carrierService.deleteCarrier(clientContext, id);
	}

	public CarrierVO findCarrier(ClientContext clientContext, Long carrierId) {
		CarrierVO vo = carrierService.findCarrier(clientContext, carrierId);
		return vo;
	}

	public PageList<CarrierVO> getPageList(ClientContext clientContext, CarrierSO carrierSO) {
		return carrierService.getPageList(clientContext, carrierSO);
	}

	public CarrierVO updateCarrier(ClientContext clientContext, CarrierVO carrierVO) {
		return carrierService.updateCarrier(clientContext, carrierVO);
	}

	public CarrierVO viewCarrier(ClientContext clientContext, Long carrierId) {
		return carrierService.viewCarrier(clientContext, carrierId);
	}
	
	public void batchUpdateCarrierStatus(ClientContext clientContext, List<Long> carrierIdList,CarrierStatus carrierStatus){
		carrierService.batchUpdateCarrierStatus(clientContext, carrierIdList, carrierStatus);
	}
}
