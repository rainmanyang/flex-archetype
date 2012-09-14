package com.oasis.wolfburg.model.price;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.enums.status.PriceStatus;
import com.oasis.wolfburg.common.enums.type.TruckType;

@Table(name = "wl_price")
@SequenceGenerator(name = "wl_price_seq")
@Cache
public class Price extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private PriceStatus status;

	/**
	 * 线路
	 */
	@Column(name = "ROUTE_ID")
	private Long routeId;
	@Column(name = "ROUTE_NAME")
	private String routeName;

	/**
	 * 车辆档次
	 */
	@Column(name = "truck_level")
	private String truckLevel;

	/**
	 * 车型
	 */
	@Column(name = "truck_type")
	private TruckType truckType;

	/**
	 * 正常结算价格
	 */
	private String price;

	/**
	 * 放空结算价格
	 */
	@Column(name = "venting_price")
	private String ventingPrice;

	/**
	 * 加班车结算价格
	 */
	@Column(name = "overtime_price")
	private String overtimePrice;

	/**
	 * 有效起始日期
	 */
	@Column(name = "period_start")
	private Date periodStart;
	/**
	 * 有效截止日期
	 */
	@Column(name = "period_end")
	private Date periodEnd;

	/**
	 * 版本号
	 */
	private int version;
	
	/**
	 * 系统生效日期
	 */
	@Column(name = "effective_start")
	private Date effectiveStart;
	@Column(name = "effective_end")
	private Date effectiveEnd;

	private String remark;
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PriceStatus getStatus() {
		return status;
	}

	public void setStatus(PriceStatus status) {
		this.status = status;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getTruckLevel() {
		return truckLevel;
	}

	public void setTruckLevel(String truckLevel) {
		this.truckLevel = truckLevel;
	}

	public TruckType getTruckType() {
		return truckType;
	}

	public void setTruckType(TruckType truckType) {
		this.truckType = truckType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVentingPrice() {
		return ventingPrice;
	}

	public void setVentingPrice(String ventingPrice) {
		this.ventingPrice = ventingPrice;
	}

	public String getOvertimePrice() {
		return overtimePrice;
	}

	public void setOvertimePrice(String overtimePrice) {
		this.overtimePrice = overtimePrice;
	}

	public Date getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	public Date getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getEffectiveStart() {
		return effectiveStart;
	}

	public void setEffectiveStart(Date effectiveStart) {
		this.effectiveStart = effectiveStart;
	}

	public Date getEffectiveEnd() {
		return effectiveEnd;
	}

	public void setEffectiveEnd(Date effectiveEnd) {
		this.effectiveEnd = effectiveEnd;
	}
}
