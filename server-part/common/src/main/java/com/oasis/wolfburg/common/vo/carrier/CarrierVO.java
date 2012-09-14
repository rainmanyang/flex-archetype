package com.oasis.wolfburg.common.vo.carrier;

import java.util.List;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.CarrierStatus;
import com.oasis.wolfburg.common.enums.type.CarrierType;
import com.oasis.wolfburg.common.enums.type.LicenseType;
import com.oasis.wolfburg.common.enums.type.PayWay;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;

public class CarrierVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;

	private String carrierCode;
	
	private String carrierName;
	
	private String carrierShortName;
	
	private CarrierStatus status;
	
	private CarrierType carrierType;
	
	private LicenseType licenseType;
	
	private String licenseCode;
	
	private String guarantee;
	
	private String contactPerson;
	
	private String contactAddress;
	
	private String contactPhone;
	
	private String contactMobile;
	
	private String contactFX;
	
	private String contactEmail;
	
	private String contactQQ;
	
	private Boolean invoice;
	
	private Integer apAge;
	
	private String bank;
	
	private String bankAccount;
	
	private String remark;
	
	private PayWay payWay;
	
	/**
	 * 挂靠公司
	 */
	private Long  parentCompanyId;
	
	/**
	 * 挂靠公司
	 */
	private String parentCompanyName;
	
	private List<AttachmentVO> attachmentList;

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getCarrierShortName() {
		return carrierShortName;
	}

	public void setCarrierShortName(String carrierShortName) {
		this.carrierShortName = carrierShortName;
	}

	public CarrierStatus getStatus() {
		return status;
	}

	public void setStatus(CarrierStatus status) {
		this.status = status;
	}

	public CarrierType getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(CarrierType carrierType) {
		this.carrierType = carrierType;
	}

	public LicenseType getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(LicenseType licenseType) {
		this.licenseType = licenseType;
	}

	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	public String getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactFX() {
		return contactFX;
	}

	public void setContactFX(String contactFX) {
		this.contactFX = contactFX;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactQQ() {
		return contactQQ;
	}

	public void setContactQQ(String contactQQ) {
		this.contactQQ = contactQQ;
	}

	public Boolean getInvoice() {
		return invoice;
	}

	public void setInvoice(Boolean invoice) {
		this.invoice = invoice;
	}

	public Integer getApAge() {
		return apAge;
	}

	public void setApAge(Integer apAge) {
		this.apAge = apAge;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public PayWay getPayWay() {
		return payWay;
	}

	public void setPayWay(PayWay payWay) {
		this.payWay = payWay;
	}

	public Long getParentCompanyId() {
		return parentCompanyId;
	}

	public void setParentCompanyId(Long parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}

	public String getParentCompanyName() {
		return parentCompanyName;
	}

	public void setParentCompanyName(String parentCompanyName) {
		this.parentCompanyName = parentCompanyName;
	}

}
