package com.oasis.wolfburg.common.service.route;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.RouteStatus;
import com.oasis.wolfburg.common.so.route.RouteSO;
import com.oasis.wolfburg.common.vo.route.RouteVO;
import com.oasis.wolfburg.common.vo.route.StopVO;

public interface RouteService {

	public void create(ClientContext clientContext, RouteVO routeVO);
	
    public void delete(ClientContext clientContext, Long id) ;
    
    public PageList<RouteVO> getPageList(ClientContext clientContext, RouteSO so) ;

    public RouteVO update(ClientContext clientContext, RouteVO routeVO);
    
    public RouteVO find(ClientContext clientContext, Long id);
    
    public void batchUpdateRouteStatus(ClientContext clientContext, List<Long> ids,RouteStatus routeStatus);
    
    public void remove(ClientContext clientContext, List<Long> ids) ;
    
    
    public List<StopVO> getStopsByRouteId(ClientContext clientContext,Long routeId);
}
