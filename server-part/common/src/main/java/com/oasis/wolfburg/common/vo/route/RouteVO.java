package com.oasis.wolfburg.common.vo.route;

import java.util.List;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.RouteStatus;

public class RouteVO extends BaseVO {
	private static final long serialVersionUID = 1L;

    private Long id;
    
    /**
     * 线路名称
     */
    private String name;
    
    /**
     * 线路编号
     */
    private String code;
    
    /**
     * 线路费用
     */
    private String charge;
    
    /**
     * 里程
     */
    private String distance;
    
    /**
     * 起点
     */
    private String startStopName;
    
    /**
     * 终点
     */
    private String endStopName;
    
    /**
     * 时效
     */
    private String enrouteDays;
    
    /**
     * 线路状态：新建，启用，停用
     */
    private RouteStatus status;
    
    private List<RouteLineVO> routeLineList ;
    
    /**
     * 只做显示用,从PO转过来
     */
    private String posNames;

	public String getPosNames() {
		return posNames;
	}

	public void setPosNames(String posNames) {
		this.posNames = posNames;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	

	public RouteStatus getStatus() {
		return status;
	}

	public void setStatus(RouteStatus status) {
		this.status = status;
	}

	public List<RouteLineVO> getRouteLineList() {
		return routeLineList;
	}

	public void setRouteLineList(List<RouteLineVO> routeLineList) {
		this.routeLineList = routeLineList;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
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
	
	

}
