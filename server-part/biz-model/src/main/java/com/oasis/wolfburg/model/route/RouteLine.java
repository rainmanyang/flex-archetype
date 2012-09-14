package com.oasis.wolfburg.model.route;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;

@Table(name = "WL_ROUTE_LINE")
@SequenceGenerator(name = "WL_ROUTE_LINE_SEQ")
@Cache
public class RouteLine extends BaseModel {

    private static final long serialVersionUID = -8527439927824037960L;
    

    @Id
    private Long id;

    /**
     * 关联的线路ID
     */
    @Column(name = "ROUTE_ID")
    private Long routeId;

    /**
     * 里程
     */
    @Column(name="distance")
    private String distance;
    
    /**
     * 时效
     */
    @Column(name="enroute_days")
    private String enrouteDays;
    
    /**
     * 起点站点Id
     */
    @Column(name="start_stop_id")
    private Long startStopId;
    
    /**
     * 起点站点名称
     */
    @Column(name="start_stop_name")
    private String startStopName;
    
    /**
     * 终点站点Id
     */
    @Column(name="end_stop_id")
    private Long endStopId;
    
    /**
     * 终点站点名称
     */
    @Column(name="end_stop_name")
    private String endStopName;

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

	
    

}
