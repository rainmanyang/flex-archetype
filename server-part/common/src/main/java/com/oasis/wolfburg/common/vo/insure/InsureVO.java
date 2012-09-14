package com.oasis.wolfburg.common.vo.insure;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;

public class InsureVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	/**
	 * 保险公司
	 */
	private String insurer;

	/**
	 * 保险编号
	 */
	private String insureCode;
	
	/**
	 * 保险时间起
	 */
	private Date insureFrom;
	
	/**
	 * 保险时间止
	 */
	private Date insureTo;
	
	/**
	 * 保险车辆
	 */
	private Long truckId;
	
	/**
	 * 保险车牌
	 */
	private String licensePlate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public Date getInsureFrom() {
		return insureFrom;
	}

	public void setInsureFrom(Date insureFrom) {
		this.insureFrom = insureFrom;
	}

	public Date getInsureTo() {
		return insureTo;
	}

	public void setInsureTo(Date insureTo) {
		this.insureTo = insureTo;
	}

	public String getInsureCode() {
		return insureCode;
	}

	public void setInsureCode(String insureCode) {
		this.insureCode = insureCode;
	}

	public Long getTruckId() {
		return truckId;
	}

	public void setTruckId(Long truckId) {
		this.truckId = truckId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
}
