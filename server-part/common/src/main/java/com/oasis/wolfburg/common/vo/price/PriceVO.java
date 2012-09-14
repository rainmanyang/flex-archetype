package com.oasis.wolfburg.common.vo.price;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.PriceStatus;
import com.oasis.wolfburg.common.enums.type.TruckType;

public class PriceVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private PriceStatus status;

	/**
	 * 线路
	 */
	private Long routeId;
	private String routeName;

	/**
	 * 车辆档次
	 */
	private String truckLevel;

	/**
	 * 车型
	 */
	private TruckType truckType;

	/**
	 * 正常结算价格
	 */
	private String price;

	/**
	 * 放空结算价格
	 */
	private String ventingPrice;

	/**
	 * 加班车结算价格
	 */
	private String overtimePrice;

	/**
	 * 有效起始日期
	 */
	private Date periodStart;
	/**
	 * 有效截止日期
	 */
	private Date periodEnd;
	
	private int version;
	
	private Date effectiveStart;
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
