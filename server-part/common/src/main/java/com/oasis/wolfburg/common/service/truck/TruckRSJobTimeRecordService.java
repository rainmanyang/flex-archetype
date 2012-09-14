package com.oasis.wolfburg.common.service.truck;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobTimeRecordSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobTimeRecordVO;

public interface TruckRSJobTimeRecordService {
	
	public PageList<TruckRSJobTimeRecordVO> getPageList(ClientContext clientContext, TruckRSJobTimeRecordSO so);
	
	
	public String exportToExcel(ClientContext clientContext, TruckRSJobTimeRecordSO so) throws Exception;
}
