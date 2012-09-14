package com.oasis.wolfburg.facade.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.DriverStatus;
import com.oasis.wolfburg.common.service.driver.DriverService;
import com.oasis.wolfburg.common.so.driver.DriverSO;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;
import com.oasis.wolfburg.common.vo.driver.DriverVO;

@RemotingDestination
@Service
public class DriverServiceFacade {
//	@Autowired
	private DriverService driverService;
	
	public PageList<DriverVO> getPageList(ClientContext clientContext,DriverSO so){
		return driverService.getPageList(clientContext,so);
	}
	
	public Long create(ClientContext clientContext,DriverVO vo,List<AttachmentVO> list){
		return driverService.createDriver(clientContext,vo,list);
	}
	
	public DriverVO update(ClientContext clientContext,DriverVO vo,List<AttachmentVO> list){
		return driverService.update(clientContext,vo,list);
	}
	
	public DriverVO find(ClientContext clientContext,Long id){
		DriverVO vo = driverService.load(clientContext, id);
		return vo;
	}
	
	public void updateStatus(ClientContext clientContext,List<Long> ids,DriverStatus status){
		driverService.updateStatus(ids,status);
	}
}
