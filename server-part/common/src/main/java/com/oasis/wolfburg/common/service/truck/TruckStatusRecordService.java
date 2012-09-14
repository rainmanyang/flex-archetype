package com.oasis.wolfburg.common.service.truck;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.truck.TruckStatusRecordSO;
import com.oasis.wolfburg.common.vo.truck.TruckStatusRecordVO;

public interface TruckStatusRecordService {
	
	public TruckStatusRecordVO findTruckStatusRecord(ClientContext clientContext, Long truckStatusRecordId);
	
	public TruckStatusRecordVO viewTruckStatusRecord(ClientContext clientContext, Long truckStatusRecordId);
	
	public Long createTruckStatusRecord(ClientContext clientContext, TruckStatusRecordVO truckStatusRecordVO);
	
	public void updateTruckStatusRecord(ClientContext clientContext, TruckStatusRecordVO truckStatusRecordVO);
	
	public PageList<TruckStatusRecordVO> getPageList(ClientContext clientContext, TruckStatusRecordSO truckStatusRecordSO);

}
