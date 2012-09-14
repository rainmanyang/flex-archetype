package com.oasis.wolfburg.service.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.wolfburg.common.enums.status.AttachmentAssocTable;
import com.oasis.wolfburg.common.enums.status.DriverStatus;
import com.oasis.wolfburg.common.so.driver.DriverSO;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;
import com.oasis.wolfburg.common.vo.driver.DriverVO;
import com.oasis.wolfburg.dao.driver.DriverDAO;
import com.oasis.wolfburg.model.driver.Driver;
import com.oasis.wolfburg.service.attachmentHelper.AttachmentHelper;

@Service
public class DriverComponent extends BaseComponent {
	@Autowired
	private DriverDAO driverDAO;
	
	@Autowired
	private AttachmentHelper attachmentHelper;
	
	public PageList<DriverVO> getPageList(DriverSO so){
		int count = driverDAO.getPaginatedListCount(so);
		List<Driver> driverList = driverDAO.getPaginatedList(so);
		List<DriverVO> list = getDozer().convertList(driverList, DriverVO.class);
		PageList<DriverVO> pageList = new PageList<DriverVO>(so);
		pageList.setFullListSize(count);
		pageList.setList(list);
		return pageList;
	}
	
	public Long createDriver(DriverVO vo,List<AttachmentVO> list){
		Driver driver = super.getDozer().convert(vo, Driver.class);
		driver.setStatus(DriverStatus.NORMAL);
		Long id = driverDAO.insert(driver);
		
		attachmentHelper.insert(list, id, AttachmentAssocTable.DRIVER);
		
		return id;
	}
	
	public DriverVO update(DriverVO vo,List<AttachmentVO> list){
		Driver driver = super.getDozer().convert(vo, Driver.class);
		driverDAO.update(driver);
		
		attachmentHelper.edit(list, driver.getId(), AttachmentAssocTable.DRIVER);
		
		return vo;
	}
	
	public DriverVO load(Long id){
		Driver driver = driverDAO.find(id);
		DriverVO vo = super.getDozer().convert(driver, DriverVO.class);
		
		vo.setAttachmentList(attachmentHelper.getList(id, AttachmentAssocTable.DRIVER));
		
		return vo;
	}
	
	public void updateStatus(List<Long> ids,DriverStatus status){
		driverDAO.updateStatus(ids, status);
	}
}
