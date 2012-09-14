package com.oasis.wolfburg.common.vo.driver;

import java.util.Date;
import java.util.List;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.DriverStatus;
import com.oasis.wolfburg.common.enums.type.AllowedTruck;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;

public class DriverVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	
	private List<AttachmentVO> attachmentList;
	
	private String name;
	private String code;
	/**
	 * 手机
	 */
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
	private Date licenseDate;
	/**
	 * 有效起始日期
	 */
	private Date periodStart;
	/**
	 * 有效截止日期
	 */
	private Date periodEnd;
	/**
	 * 准驾车型
	 */
	private AllowedTruck allowedTruck;

	/**
	 * 所属承运商
	 */
	private Long carrierId;
	private String carrierName;

	/**
	 * 所驾车辆
	 */
	private Long truckId;
	private String truckName;

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

	public AllowedTruck getAllowedTruck() {
		return allowedTruck;
	}

	public void setAllowedTruck(AllowedTruck allowedTruck) {
		this.allowedTruck = allowedTruck;
	}

	public Long getCarrierId() {
		return carrierId;
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

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
}
