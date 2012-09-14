package com.oasis.wolfburg.model.insure;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;

@Table(name = "wl_insure")
@SequenceGenerator(name = "wl_insure_seq")
public class Insure extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	@Id
	private Long id;
	
	/**
	 * 保险公司
	 */
	@Column(name = "insurer")
	private String insurer;

	/**
	 * 保险编号
	 */
	@Column(name = "insure_code")
	private String insureCode;
	
	/**
	 * 保险时间起
	 */
	@Column(name = "insure_from")
	private Date insureFrom;
	
	/**
	 * 保险时间止
	 */
	@Column(name = "insure_to")
	private Date insureTo;
	
	/**
	 * 保险车辆
	 */
	@Column(name = "truck_id")
	private Long truckId;
	
	/**
	 * 保险车牌
	 */
	@Column(name = "license_plate")
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

	public String getInsureCode() {
		return insureCode;
	}

	public void setInsureCode(String insureCode) {
		this.insureCode = insureCode;
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
