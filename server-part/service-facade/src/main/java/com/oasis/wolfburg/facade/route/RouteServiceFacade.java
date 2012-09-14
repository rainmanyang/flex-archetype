package com.oasis.wolfburg.facade.route;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.RouteStatus;
import com.oasis.wolfburg.common.service.route.RouteService;
import com.oasis.wolfburg.common.so.route.RouteSO;
import com.oasis.wolfburg.common.vo.route.RouteVO;
import com.oasis.wolfburg.common.vo.route.StopVO;

@RemotingDestination
@Service
public class RouteServiceFacade {
	
//	@Autowired
	private RouteService routeService;
	
	public void create(ClientContext clientContext,RouteVO routeVO){
		routeService.create(clientContext, routeVO);
	}
	
	public RouteVO find(ClientContext clientContext,Long id){
		return routeService.find(clientContext, id);
	}
	
	public PageList<RouteVO> getPageList(ClientContext clientContext,RouteSO so){
		return routeService.getPageList(clientContext, so);
	}
	
	public void remove(ClientContext clientContext,List<Object> ids){
	    List<Long> l_ids = new ArrayList<Long>();
	    for(int i=0;i<ids.size();i++){
	        Long id = Long.parseLong(ids.get(i).toString());
	        l_ids.add(id);
	    }
	    routeService.remove(clientContext, l_ids);
	}
	
	public RouteVO update(ClientContext clientContext,RouteVO routeVO){
		 return routeService.update(clientContext,routeVO);
	}
	
	public void batchUpdateRouteStatus(ClientContext clientContext, List<Long> ids,RouteStatus routeStatus){
		routeService.batchUpdateRouteStatus(clientContext, ids, routeStatus);
	}
	
	public List<StopVO> getStopsByRouteId(ClientContext clientContext,Long routeId){
		return routeService.getStopsByRouteId(clientContext,routeId);
	}
//	
//	public List<Role> getAllRole(ClientContext clientContext){
//	    return roleService.getAllRole(clientContext);
//	}
}
