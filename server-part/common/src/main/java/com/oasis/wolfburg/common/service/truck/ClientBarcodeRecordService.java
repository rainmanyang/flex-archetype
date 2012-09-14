package com.oasis.wolfburg.common.service.truck;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.truckRSSchedule.ClientBarcodeRecordSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.ClientBarcodeRecordVO;

public interface ClientBarcodeRecordService {

	 PageList<ClientBarcodeRecordVO> getPageList(ClientContext clientContext,ClientBarcodeRecordSO so);
}
