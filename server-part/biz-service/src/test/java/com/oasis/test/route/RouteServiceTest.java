package com.oasis.test.route;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.RouteStatus;
import com.oasis.wolfburg.common.so.route.RouteSO;
import com.oasis.wolfburg.common.vo.route.PosVO;
import com.oasis.wolfburg.common.vo.route.RouteLineVO;
import com.oasis.wolfburg.common.vo.route.RouteVO;
import com.oasis.wolfburg.dao.route.RouteDAO;
import com.oasis.wolfburg.service.route.RouteComponent;

public class RouteServiceTest extends SpringBaseTest {
	@Autowired
	private RouteComponent service;
	
	@Autowired
	private RouteDAO routeDAO;
	
	@Test
	public void select() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		routeDAO.getListByIds(ids);
	}
	
	@Test
	public void createRoute(){
		RouteVO route = this.getRouteVO();
		route.setId(null);
		service.createRoute(route);
	}
	@Test
	public void viewRoute(){
		RouteVO vo = service.viewRoute(getId());
		
		System.out.println(vo.getName());
		System.out.println(vo.getStartStopName());
		System.out.println(vo.getRouteLineList().get(0).getEndStopName());
	}
	@Test
	public void updateRoute(){
		RouteVO vo = service.viewRoute(getId());
		System.out.println(vo.getName());
		System.out.println(vo.getStartStopName());
		System.out.println(vo.getRouteLineList().get(0).getEndStopName());
		
		vo.setName("dddd");
		vo.getRouteLineList().get(0).setEndStopName("xxx");
		service.updateRoute(vo);
		
		
		RouteVO vo1 = service.viewRoute(getId());
		
		System.out.println(vo1.getName());
		System.out.println(vo1.getStartStopName());
		System.out.println(vo1.getRouteLineList().get(0).getEndStopName());
	}
	
	@Test
	public void deleteRoute(){
		service.deleteRoute(getId());
	}
	
	@Test
	public void pageList(){
		RouteSO so = new RouteSO();
		so.setName("sh");
		PageList<RouteVO> page = service.getPageList(so);
		System.out.println(page.getFullListSize());
	}
	
	private Long getId(){
		RouteSO so = new RouteSO();
		PageList<RouteVO> page = service.getPageList(so);
		return page.getList().get(0).getId();
	}
	
	private RouteVO getRouteVO(){
		PosVO startPosVO = new PosVO();
		startPosVO.setId(111L);
		startPosVO.setName("startPOs");
		
		PosVO endPosVO = new PosVO();
		endPosVO.setId(222L);
		endPosVO.setName("endPos");
		
		RouteLineVO routeLineVO = new RouteLineVO();
		routeLineVO.setStartStopId(111L);
		routeLineVO.setStartStopName("startPOs");
		routeLineVO.setEndStopId(222L);
		routeLineVO.setEndStopName("endPos");
		routeLineVO.setDistance("55");
		routeLineVO.setEnrouteDays("2");
		
		List<RouteLineVO> routeLineVOList =  new ArrayList<RouteLineVO>();
		routeLineVOList.add(routeLineVO);
		
		
		
		RouteVO route = new RouteVO();
		route.setId(100077L);
		route.setName("hz-sh");
		route.setLockVersion(5);
		route.setCharge("2000");
		route.setDistance("2001");
		route.setCode("12345677");
		route.setStatus(RouteStatus.NEW);
		route.setStartStopName("杭州");
		route.setEndStopName("上海");
		
		route.setRouteLineList(routeLineVOList);
		
		return route;
	}
}
