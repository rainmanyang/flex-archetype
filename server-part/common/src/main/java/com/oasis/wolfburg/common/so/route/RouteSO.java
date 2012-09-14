package com.oasis.wolfburg.common.so.route;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.status.RouteStatus;

public class RouteSO extends BasePageSO {

    private static final long serialVersionUID = -7012848245686479326L;
    
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
    private Float charge;
    
    /**
     * 里程
     */
    private Float distance;
    
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
    private Float enrouteDays;
    
    private String passStop;
    
    /**
     * 线路状态：新建，启用，停用
     */
    private RouteStatus status;
    
   

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

	public Float getCharge() {
		return charge;
	}

	public void setCharge(Float charge) {
		this.charge = charge;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
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

	public Float getEnrouteDays() {
		return enrouteDays;
	}

	public void setEnrouteDays(Float enrouteDays) {
		this.enrouteDays = enrouteDays;
	}

	public RouteStatus getStatus() {
		return status;
	}

	public void setStatus(RouteStatus status) {
		this.status = status;
	}

	public String getPassStop() {
		return passStop;
	}

	public void setPassStop(String passStop) {
		this.passStop = passStop;
	}
    
    
    
	
}
