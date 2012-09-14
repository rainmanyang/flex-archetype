package com.oasis.test.truckRSSchedule;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.TruckScheduleStatus;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSScheduleSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSScheduleVO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSScheduleDAO;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSSchedule;
import com.oasis.wolfburg.service.truckRSSchedule.TruckRSScheduleComponent;

public class TruckRSScheduleServiceTest extends SpringBaseTest {
	@Autowired
	private TruckRSScheduleComponent service;	
	
	@Autowired
    private TruckRSScheduleDAO truckRSScheduleDAO;
	
	@Test
	public void createRoute(){
		TruckRSScheduleVO vo = this.getRSSVO();
		service.createTruckRSSchedule(vo);
	}
	
	@Test
	public void findTruckRSScheduleVO(){
		TruckRSScheduleVO vo = this.getRSSVO();
		vo = service.findTruckRSSchedule(vo.getId());
		System.out.println(vo);
	}
	
	@Test
	public void update(){
		TruckRSScheduleVO vo = this.getRSSVO();
		Long newId = service.updateTruckRSSchedule(vo);
		System.out.println(newId);
	}
	
	private TruckRSScheduleVO getRSSVO(){
		TruckRSScheduleSO so = new TruckRSScheduleSO();
		PageList<TruckRSScheduleVO> page = service.getPageList(so);
		TruckRSScheduleVO vo = page.getList().get(0);
		vo.setRouteId(71400L);
		vo.setRouteName("hz-sh");
		vo.setLockVersion(0);
		vo.setStatus(TruckScheduleStatus.NEW);
		return vo;
	}
}
