package com.oasis.wolfburg.model.driver;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.enums.status.DriverStatus;
import com.oasis.wolfburg.common.enums.type.AllowedTruck;

@Table(name = "wl_driver")
@SequenceGenerator(name = "wl_driver_seq")
@Cache
public class Driver extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 编号
	 */
	private String code;
	/**
	 * 手机
	 */
	@Column(name = "mobile_phone")
	private String mobilePhone;
	/**
	 * 家庭地址
	 */
	private String address;
	/**
	 * 状态
	 */
	private DriverStatus status;
	/**
	 * 驾驶号
	 */
	private String license;
	/**
	 * 身份证
	 */
	private String idcard;
	/**
	 * 初次领证日期
	 */
	@Column(name = "license_date")
	private Date licenseDate;
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
	 * 准驾车型
	 */
	@Column(name = "allowed_truck")
	private AllowedTruck allowedTruck;
	
	/**
	 * 所属承运商
	 */
	@Column(name = "carrier_ID")
	private Long carrierId;
	@Column(name = "carrier_NAME")
	private String carrierName;
	
	/**
	 * 所驾车辆
	 */
	@Column(name = "TRUCK_ID")
	private Long truckId;
	@Column(name = "TRUCK_NAME")
	private String truckName;

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

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DriverStatus getStatus() {
		return status;
	}

	public void setStatus(DriverStatus status) {
		this.status = status;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Date getLicenseDate() {
		return licenseDate;
	}

	public void setLicenseDate(Date licenseDate) {
		this.licenseDate = licenseDate;
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

	public Long getCarrierId() {
		return carrierId;
	}

	public AllowedTruck getAllowedTruck() {
		return allowedTruck;
	}

	public void setAllowedTruck(AllowedTruck allowedTruck) {
		this.allowedTruck = allowedTruck;
	}

	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Long getTruckId() {
		return truckId;
	}

	public void setTruckId(Long truckId) {
		this.truckId = truckId;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

}
