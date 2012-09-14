package com.oasis.wolfburg.service.route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.base.Constants;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.wolfburg.common.enums.status.RouteStatus;
import com.oasis.wolfburg.common.so.route.RouteSO;
import com.oasis.wolfburg.common.vo.route.RouteLineVO;
import com.oasis.wolfburg.common.vo.route.RouteVO;
import com.oasis.wolfburg.common.vo.route.StopVO;
import com.oasis.wolfburg.dao.route.RouteDAO;
import com.oasis.wolfburg.dao.route.RouteLineDAO;
import com.oasis.wolfburg.dao.route.StopDAO;
import com.oasis.wolfburg.model.route.Route;
import com.oasis.wolfburg.model.route.RouteLine;
import com.oasis.wolfburg.model.route.Stop;
@Service
public class RouteComponent extends BaseComponent {
	
	@Autowired
	private RouteDAO routeDAO;
	
	@Autowired
	private RouteLineDAO routeLineDAO;
	
	@Autowired
	private StopDAO stopDAO;
	
	/**
	 * 批量删除Route
	 * @param ids
	 */
	public void removeByIds(List<Long> ids) {
		for(Long id : ids){
			deleteRouteRelateData(id);
		}
		routeDAO.deleteByIds(ids);
	}
	
	/**
	 * 创建线路
	 * @param routeVO
	 * 需要赋值的有：
	 * 1.RouteVO对象的List<RouteLineVO> routeLineList
	 * 2.routeLineList中的startStopId,startStopname,endStopId,endStopName,enrouteDays,distance
	 * 备注：RouteLineList需要排过序的
	 * @return
	 */
	public Long createRoute(RouteVO routeVO) {
		checkDuplicate(routeVO.getName(),routeVO.getId(),routeVO.getCode());
		routeVO.setStatus(RouteStatus.NEW);
		Route route = super.getDozer().convert(routeVO, Route.class);
		Long routeId = routeDAO.insert(route);
		saveRouteRelateData(routeVO,routeId);
		return routeId;
	}
	/**
	 * 保存Route相关数据，比如：RouteLine，Stop
	 * @param routeVO
	 * @param routeId
	 */
	private void saveRouteRelateData(RouteVO routeVO,Long routeId){
		String posNames = "";
		
		/**
		 * key:posId
		 * value:stopId
		 */
		Map<Long,Long> idMap = new HashMap<Long,Long>();
		/**
		 * 需要排序,因为stop有seqNum,
		       传进来的RouteLineList需要排过序的
		 */
		List<RouteLineVO> routeLineList = routeVO.getRouteLineList();
		for(RouteLineVO routeLineVO : routeLineList){
			Long startPosId = routeLineVO.getStartPosId();
			String startPosName = routeLineVO.getStartStopName();
			Long startStopId = composedStop(idMap,routeId,startPosId,startPosName);
			posNames += Constants.COMMA+ startPosName;
			/**
			 * 创建Stop
			 */
			Long endPosId = routeLineVO.getEndPosId();
			String endPosName = routeLineVO.getEndStopName();
			Long endStopId = composedStop(idMap,routeId,endPosId,endPosName);
			if(routeLineList.indexOf(routeLineVO) == routeLineList.size()-1){
				posNames += Constants.COMMA+ endPosName;
			}
			
			/**
			 * 创建RouteLinie
			 */
			routeLineVO.setRouteId(routeId);
			routeLineVO.setStartStopId(startStopId);
			routeLineVO.setStartStopName(startPosName);
			routeLineVO.setEndStopId(endStopId);
			routeLineVO.setEndStopName(endPosName);
			RouteLine routeLine = super.getDozer().convert(routeLineVO, RouteLine.class);
			routeLineDAO.insert(routeLine);
		}
		
		/**
		 * 更新posNames
		 */
		if(StringUtils.isNotBlank(posNames)){
			posNames = posNames.substring(1);
		}
		Route route = routeDAO.find(routeId);
		route.setPosNames(posNames);
		routeDAO.update(route);
	}
	
	
	/**
	 * 组装Stop对象,并创建Stop
	 * @param routeId
	 * @param posId
	 * @param posName
	 * @param seqNum
	 * @return stopId
	 */
	private Long composedStop(Map<Long,Long> idMap , Long routeId,Long posId,String posName){
		StopVO stopVO = new StopVO();
		stopVO.setPosName(posName);
		stopVO.setPosId(posId);
		stopVO.setRouteId(routeId);
		stopVO.setSeqNum(idMap.size()+1);
		Stop stop = super.getDozer().convert(stopVO, Stop.class);
		Long stopId = null;
		/**
		 * 如果为空，说明没有保存过该Stop
		 */
		if(idMap.get(posId) == null){
			stopId = stopDAO.insert(stop);
			idMap.put(posId,stopId);
		}else{
			stopId = idMap.get(posId);
		}
		return stopId;
	}
	
	/**
	 * 更新线路
	 * @param routeVO
	 */
	public RouteVO updateRoute(RouteVO routeVO){
		checkDuplicate(routeVO.getName(),routeVO.getId(),routeVO.getCode());
		Long routeId = routeVO.getId();
		//删除
		deleteRouteRelateData(routeId);
		//新增
		Route route = super.getDozer().convert(routeVO, Route.class);
		//保存线路相关数据
		routeDAO.update(route);
		saveRouteRelateData(routeVO,routeId);
		return super.getDozer().convert(route,RouteVO.class);
	}
	
	/**
	 * 查询线路
	 * 查询不需要去操作Stop，需要的数据都做了冗余
	 * @param routeId
	 * @return
	 */
	public RouteVO viewRoute(Long routeId){
		/**
		 * 查询Route
		 */
		Route route = routeDAO.find(routeId);
		RouteVO routeVO = super.getDozer().convert(route, RouteVO.class);
		/**
		 * 查询RouteLine
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("routeId", routeId);
		/**
		 * 需要排序：asc
		 */
		List<RouteLineVO> routeLineVOList = new ArrayList<RouteLineVO>();
		List<RouteLine> routeLineList = routeLineDAO.getQueryList(paramMap);
		for(RouteLine rl : routeLineList){
			RouteLineVO rlvo = super.getDozer().convert(rl, RouteLineVO.class);
			rlvo.setStartPosId(this.getPosIdByStopId(rlvo.getStartStopId()));
			rlvo.setEndPosId(this.getPosIdByStopId(rlvo.getEndStopId()));
			routeLineVOList.add(rlvo);
		}
		//List<RouteLineVO> routeLineVOList = super.getDozer().convertList(routeLineList, RouteLineVO.class);
		
		routeVO.setRouteLineList(routeLineVOList);
		return routeVO;
	}
	
	private Long getPosIdByStopId(Long stopId){
		return stopDAO.find(stopId).getPosId();
	}
	/**
	 * 删除线路
	 * @param routeId
	 */
	public void deleteRoute(Long routeId){
		deleteRouteRelateData(routeId);
		
		/**
		 * 删除线路
		 */
		routeDAO.delete(routeId);
	}
	/**
	 * 删除线路相关数据
	 * @param routeId
	 */
	private void deleteRouteRelateData(Long routeId){
		/**
		 * 查询RouteLine
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("routeId", routeId);
		/**
		 * 排不排序无所谓
		 */
		List<RouteLine> routeLineList = routeLineDAO.getQueryList(paramMap);
		
		/**
		 * 线路所关联的所有StopLine
		 */
		List<Long> stopLineIdList = new ArrayList<Long>();
		/**
		 * 线路所关联的所有站点
		 */
		List<Long> stopIdList = new ArrayList<Long>();
		for(RouteLine routeLine : routeLineList){
			stopIdList.add(routeLine.getStartStopId());
			stopIdList.add(routeLine.getEndStopId());
			
			stopLineIdList.add(routeLine.getId());
		}
		/**
		 * 删除RouteLine
		 */
		routeLineDAO.deleteByIds(stopLineIdList);
		
		/**
		 * 删除线路关联的所有站点
		 */
		stopDAO.deleteByIds(stopIdList);
	}
	
	/**
	 * 分页查询
	 * @param so
	 * @return
	 */
	public PageList<RouteVO> getPageList(RouteSO so) {
		List<Route> routeList = routeDAO.getPaginatedList(so);
		List<RouteVO> list = super.getDozer().convertList(routeList, RouteVO.class);
		int cnt = routeDAO.getPaginatedListCount(so);
		PageList<RouteVO> page = new PageList<RouteVO>();
		page.setList(list);
		page.setFullListSize(cnt);
		return page;
	}
	
	private void checkDuplicate(String name,Long id,String code){
		Map<String, String> errors = new HashMap<String, String>();
		int cnt = routeDAO.checkNameDuplicate(name,id);
		if(cnt > 0){
			/**
			 * reviewer:中文放入资源文件
			 */
			errors.put("nameCN", ErrorDispHelper.getInstance().getValue("ROUTE_NAME_ERROR"));
            throw new ValidationException(errors);
		}
		
		int cnt1 = routeDAO.checkCodeDuplicate(code,id);
		if(cnt1 > 0){
			errors.put("code", ErrorDispHelper.getInstance().getValue("ROUTE_CODE_ERROR"));
            throw new ValidationException(errors);
		}
	}
	
	public void batchUpdateRouteStatus(List<Long> ids,RouteStatus routeStatus){
		List<Route> routeList = routeDAO.getListByIds(ids);
		switch (routeStatus) {
			case ACTIVE:{
				for (Route route : routeList) {
					if (RouteStatus.NEW.equals(route.getStatus()) || RouteStatus.FROZEN.equals(route.getStatus())) {
						route.setStatus(RouteStatus.ACTIVE);
						routeDAO.update(route);
					}
				}
				break;
			}
			case FROZEN:{
				for (Route route : routeList) {
					if (RouteStatus.NEW.equals(route.getStatus()) || RouteStatus.ACTIVE.equals(route.getStatus())) {
						route.setStatus(RouteStatus.FROZEN);
						routeDAO.update(route);
					}
				}
				break;
			}
			
			case NEW:
			default:{
				break;
			}
	    }
	}
	/**
	 * 根据线路ID查找出所有站点
	 * @param routeId
	 * @return
	 */
	public List<StopVO> getStopsByRouteId(Long routeId){
		List<Stop> stops = stopDAO.getStopsByRoute(routeId);
		List<StopVO> list = super.getDozer().convertList(stops, StopVO.class);
		return list;
	}
	
}