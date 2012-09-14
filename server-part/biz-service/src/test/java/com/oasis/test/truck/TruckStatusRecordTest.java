package com.oasis.test.truck;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.so.truck.TruckStatusRecordSO;
import com.oasis.wolfburg.common.vo.truck.TruckStatusRecordVO;
import com.oasis.wolfburg.service.truck.TruckStatusRecordComponent;

public class TruckStatusRecordTest extends SpringBaseTest {
	
	@Autowired
	private TruckStatusRecordComponent service;
	
	@Test
	public void create(){
		TruckStatusRecordVO truckStatusChangeRecordVO = getVO();
		truckStatusChangeRecordVO.setId(null);
		service.createTruckStatusRecord(truckStatusChangeRecordVO);
	}
	
	@Test
	public void update()throws Exception {
		TruckStatusRecordSO so = new TruckStatusRecordSO();
	    so.setLicensePlate("licensePlate");
		PageList<TruckStatusRecordVO> page = service.getPageList(so);
		if (page.getFullListSize() > 0) {
			TruckStatusRecordVO vo = service.findTruckStatusRecord(page.getList().get(0).getId());
			vo.setLicensePlate("licensePlate1");
			service.updateTruckStatusRecord(vo);
		} else {
			throw new Exception("getPageList() error!");
		}
	}
	
	@Test
	public void getPageList(){
		TruckStatusRecordSO so = new TruckStatusRecordSO();
	    so.setLicensePlate("licensePlate");
	    PageList<TruckStatusRecordVO> page= service.getPageList(so);
	    Assert.notNull(page.getPages());
	}
	
	private TruckStatusRecordVO getVO(){
		TruckStatusRecordVO vo = new TruckStatusRecordVO();
	    vo.setId(1L);
		vo.setLicensePlate("licensePlate") ;
		vo.setExecuteDate(new Date());
		vo.setTruckStatus(TruckStatus.ENABLE);
		vo.setRunningStatus(TruckRunningStatus.FREE);
		vo.setUpdatePerson("updatePerson");
		vo.setReason("reason");
	    return vo;
	}

}
