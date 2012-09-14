package com.oasis.test.driver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.DriverStatus;
import com.oasis.wolfburg.common.enums.type.AllowedTruck;
import com.oasis.wolfburg.common.so.driver.DriverSO;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;
import com.oasis.wolfburg.common.vo.driver.DriverVO;
import com.oasis.wolfburg.dao.driver.DriverDAO;
import com.oasis.wolfburg.model.driver.Driver;
import com.oasis.wolfburg.service.driver.DriverComponent;

public class DriverServiceTest extends SpringBaseTest {
	@Autowired
	private DriverComponent service;
	
	@Autowired
	private DriverDAO dao;
	
	@Test
	public void frozen(){
		List<Long> list = Arrays.asList(9L,10L);
		service.updateStatus(list, DriverStatus.FROZEN);
	}
	
	@Test
	public void find(){
		DriverSO so = this.getSo();
		List<Driver> list = dao.getPaginatedList(so);
		if(!list.isEmpty()){
			System.out.println(list.get(0));
		}
	}
	
	@Test
	public void getPageList(){
		DriverSO so = this.getSo();
		PageList<DriverVO> page = service.getPageList(so);
		System.out.println(page.getFullListSize());
	}
	
	@Test
	public void createDriver(){
		DriverVO vo = this.getVo();
		vo.setId(null);
		service.createDriver(vo,new ArrayList<AttachmentVO>());
	}
	
	@Test
	public void update(){
		DriverVO vo = this.getVo();
		vo.setName("李师傅");
		service.update(vo,new ArrayList<AttachmentVO>());
	}
	
	private DriverVO getVo(){
		DriverSO so = new DriverSO();
		PageList<DriverVO> page = service.getPageList(so);
		DriverVO vo = page.getList().get(0);
		vo.setName("张师傅");
		vo.setCode("zh001");
		vo.setAllowedTruck(AllowedTruck.B);
		vo.setLicense("浙A 7985");
		vo.setLicenseDate(Calendar.getInstance().getTime());
		vo.setStatus(DriverStatus.NORMAL);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			vo.setPeriodStart(df.parse("2003-06-21"));
			vo.setPeriodEnd(df.parse("2017-10-08"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	private DriverSO getSo(){
		DriverSO so = new DriverSO();
		so.setStatus(DriverStatus.NORMAL);
		so.setLicense("浙A");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			so.setPeriodStart(df.parse("2008-06-21"));
			so.setPeriodEnd(df.parse("2015-10-08"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return so;
	}
}
