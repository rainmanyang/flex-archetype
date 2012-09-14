package com.oasis.wolfburg.model.route;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.enums.status.RouteStatus;
@Table(name = "WL_ROUTE")
@SequenceGenerator(name = "WL_ROUTE_SEQ")
@Cache
public class Route extends BaseModel {

    private static final long serialVersionUID = 2349948052655951595L;

    @Id
    private Long id;
    
    /**
     * 线路名称
     */
    @Column(name = "name")
    private String name;
    
    /**
     * 线路编号
     */
    @Column(name = "code")
    private String code;
    
    /**
     * 线路费用
     */
    @Column(name = "charge")
    private String charge;
    
    /**
     * 里程
     */
    @Column(name = "distance")
    private String distance;
    
    /**
     * 起点
     */
    @Column(name = "start_stop_name")
    private String startStopName;
    
    /**
     * 终点
     */
    @Column(name = "end_stop_name")
    private String endStopName;
    
    /**
     * 时效
     */
    @Column(name = "enroute_days")
    private String enrouteDays;
    
    /**
     * 线路状态：新建，启用，停用
     */
    @Column(name = "status")
    private RouteStatus status;
    
    /**
     * 所有关联的物流节点名称,例网点1,网点2,网点3
     */
    @Column(name = "pos_names")
    private String posNames;

    public String getPosNames() {
		return posNames;
	}

	public void setPosNames(String posNames) {
		this.posNames = posNames;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public RouteStatus getStatus() {
		return status;
	}

	public void setStatus(RouteStatus status) {
		this.status = status;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
