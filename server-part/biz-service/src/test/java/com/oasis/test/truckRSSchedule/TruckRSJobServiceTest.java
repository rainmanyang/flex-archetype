package com.oasis.test.truckRSSchedule;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobVO;
import com.oasis.wolfburg.service.qzSchedule.handler.GeneratorShiftScheduleHandler;
import com.oasis.wolfburg.service.truckRSSchedule.TruckRSJobComponent;

public class TruckRSJobServiceTest extends SpringBaseTest {
	@Autowired
	private TruckRSJobComponent service;
	
	@Autowired
	private GeneratorShiftScheduleHandler handle;
	
	@Test
	public void findRSJobListBySO(){
		TruckRSJobSO so = new TruckRSJobSO();
		so.setCode("客户端");
		List<TruckRSJobVO> rsJobList = service.getTruckRSJobListBySO(so);
		if(rsJobList != null){
			System.out.println(rsJobList.size());
		}else{
			System.out.println("无数据");
		}
	}
	
	public TruckRSJobVO getTruckRSJobVO(){
		TruckRSJobSO so = new TruckRSJobSO();
		List<TruckRSJobVO> list = service.getTruckRSJobListBySO(so);
		TruckRSJobVO vo = list.get(0);
		vo.setCode(vo.getCode()+super.CODE);
		return vo;
	}
	
	@Test
	public void update(){
		TruckRSJobVO rsJobVO = getTruckRSJobVO();
		rsJobVO.setCode("111-1");
		TruckRSJobVO result = service.assignTruck2RSJob(rsJobVO);
		System.out.println(result.getCode());
	}
	
	@Test
	public void addTempJob(){
	    TruckRSJobVO vo = new TruckRSJobVO();
	    vo.setStartDate(new Date());
	    vo.setRsScheduleId(69000L);
	    vo.setTruckId(0L);
	    handle.generateTempTruckRSJob(vo);
	    
	}
}
