package com.oasis.test.price;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.util.helper.DozerHelper;
import com.oasis.wolfburg.common.enums.status.PriceStatus;
import com.oasis.wolfburg.common.enums.type.TruckType;
import com.oasis.wolfburg.common.so.price.PriceSO;
import com.oasis.wolfburg.common.vo.price.PriceVO;
import com.oasis.wolfburg.dao.price.PriceDAO;
import com.oasis.wolfburg.model.price.Price;
import com.oasis.wolfburg.service.price.PriceComponent;

public class PriceServiceTest extends SpringBaseTest {
	@Autowired
	private PriceComponent service;
	
	@Autowired
	private PriceDAO priceDAO;
	
	@Autowired
	private DozerHelper dozer;
	
	//@Test
	public void createPrice(){
		PriceVO vo = this.getVo();
		service.createPrice(vo);
	}
	
	//@Test
	public void delay(){
		List<Long> list = Arrays.asList(9L,12L);
		service.delay(list, 5);
	}
	
	@Test
	public void find(){
		Price price = priceDAO.find(9L);
		System.out.println(price.getVentingPrice());
	}
	
	public void getPageList(){
		PriceSO so = this.getSo();
		PageList<PriceVO> page = service.getPageList(so);
		System.out.println(page.getFullListSize());
	}
	
	//@Test
	public void delayPrice(){
		Price price = priceDAO.find(2L);
		PriceVO vo = dozer.convert(price, PriceVO.class);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			vo.setPeriodEnd(df.parse("2019-05-13"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		service.update(vo);
	}
	
	//@Test
	public void editPrice(){
		Price price = priceDAO.find(2L);
		price.setTruckLevel("NORMAL");
		price.setTruckType(TruckType.T4_2M);
		price.setRouteName("深圳--广州--天津--北京");
		PriceVO vo = dozer.convert(price, PriceVO.class);
		
		service.editPrice(vo);
	}
	
	
	private PriceVO getVo(){
		PriceVO vo = new PriceVO();
		vo.setRouteName("杭州-广州-深圳");
		vo.setTruckLevel("HIGH");
		vo.setTruckType(TruckType.T4_2M);
		vo.setPrice("4500");
		vo.setVentingPrice("2500");
		vo.setOvertimePrice("6000");
		vo.setStatus(PriceStatus.EFFECTIVE);
		vo.setRouteId(0L);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			vo.setPeriodStart(df.parse("2002-06-21"));
			vo.setPeriodEnd(df.parse("2017-10-08"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	private PriceSO getSo(){
		PriceSO so = new PriceSO();
		so.setStatus(PriceStatus.EFFECTIVE);
		so.setRouteName("杭州");
		
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
