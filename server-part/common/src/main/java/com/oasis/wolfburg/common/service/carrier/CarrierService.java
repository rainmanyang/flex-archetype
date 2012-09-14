package com.oasis.wolfburg.common.service.carrier;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.CarrierStatus;
import com.oasis.wolfburg.common.so.carrier.CarrierSO;
import com.oasis.wolfburg.common.vo.carrier.CarrierVO;

public interface CarrierService {

	CarrierVO findCarrier(ClientContext clientContext, Long carrierId);

	CarrierVO viewCarrier(ClientContext clientContext, Long carrierId);

	Long createCarrier(ClientContext clientContext, CarrierVO carrierVO);

	int deleteCarrier(ClientContext clientContext, Long id);

	CarrierVO updateCarrier(ClientContext clientContext, CarrierVO carrierVO);

	PageList<CarrierVO> getPageList(ClientContext clientContext, CarrierSO carrierSO);
	
	void batchUpdateCarrierStatus(ClientContext clientContext, List<Long> carrierIdList,CarrierStatus carrierStatus);

}
