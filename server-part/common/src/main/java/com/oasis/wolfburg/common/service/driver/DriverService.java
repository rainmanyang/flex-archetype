package com.oasis.wolfburg.common.service.driver;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.DriverStatus;
import com.oasis.wolfburg.common.so.driver.DriverSO;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;
import com.oasis.wolfburg.common.vo.driver.DriverVO;

public interface DriverService {
	PageList<DriverVO> getPageList(ClientContext clientContext,DriverSO so);
	
	Long createDriver(ClientContext clientContext,DriverVO vo,List<AttachmentVO> list);
	
	DriverVO update(ClientContext clientContext,DriverVO vo,List<AttachmentVO> list);
	
	DriverVO load(ClientContext clientContext,Long id);
	
	void updateStatus(List<Long> ids,DriverStatus status);
}
