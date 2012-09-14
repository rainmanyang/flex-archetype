package com.oasis.wolfburg.common.vo.route;

import com.oasis.tmsv5.common.vo.BaseVO;

public class RouteLineVO extends BaseVO  {

    private static final long serialVersionUID = -8527439927824037960L;
    
    private Long id;

    /**
     * 关联的线路ID
     */
    private Long routeId;

    /**
     * 里程
     */
    private String distance;
    
    /**
     * 时效
     */
    private String enrouteDays;
    
    /**
     * 起点站点Id
     */
    private Long startStopId;
    
    /**
     * 起点站点名称
     */
    private String startStopName;
    
    /**
     * 终点站点Id
     */
    private Long endStopId;
    
    /**
     * 终点站点名称
     */
    private String endStopName;
    
    /**======================**/
    
    /**
     * 传值使用
     */
    private Long startPosId;
    /**
     * 传值使用
     */
    private Long endPosId;
    
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getEnrouteDays() {
		return enrouteDays;
	}

	public void setEnrouteDays(String enrouteDays) {
		this.enrouteDays = enrouteDays;
	}

	public Long getStartStopId() {
		return startStopId;
	}

	public void setStartStopId(Long startStopId) {
		this.startStopId = startStopId;
	}

	

	public Long getEndStopId() {
		return endStopId;
	}

	public void setEndStopId(Long endStopId) {
		this.endStopId = endStopId;
	}

	

	public String getStartStopName() {
		return startStopName;
	}

	public void setStartStopName(String startStopName) {
		this.startStopName = startStopName;
	}

	public String getEndStopName() {
		return endStopName;
	}

	public void setEndStopName(String endStopName) {
		this.endStopName = endStopName;
	}

	public Long getStartPosId() {
		return startPosId;
	}

	public void setStartPosId(Long startPosId) {
		this.startPosId = startPosId;
	}

	public Long getEndPosId() {
		return endPosId;
	}

	public void setEndPosId(Long endPosId) {
		this.endPosId = endPosId;
	}
	

}
