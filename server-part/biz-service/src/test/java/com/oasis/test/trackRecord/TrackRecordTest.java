package com.oasis.test.trackRecord;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.wolfburg.common.enums.type.EventPhase;
import com.oasis.wolfburg.dao.trackRecord.TrackRecordDAO;
import com.oasis.wolfburg.model.trackRecord.TrackRecord;

public class TrackRecordTest extends SpringBaseTest {
	@Autowired
	private TrackRecordDAO dao;
	
	//@Test
	public void insert(){
		TrackRecord bean = new TrackRecord();
		bean.setTruckRsJobId(71400L);
		bean.setEventPhase(EventPhase.CHANGEVECHICLE);
		bean.setEventTime(new Date());
		bean.setDescription("车辆由A换至B");
		dao.insert(bean);
	}
	
	@Test
	public void getListByFKId(){
		Long fkId = 71400L;
		List<TrackRecord> list = dao.getListByFKId(fkId);
		if(!list.isEmpty()){
			System.out.println(list.get(0).getEventPhase());
		}
	}
}
