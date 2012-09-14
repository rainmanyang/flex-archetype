package com.oasis.wolfburg.model.carrier;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.enums.status.CarrierStatus;
import com.oasis.wolfburg.common.enums.type.CarrierType;
import com.oasis.wolfburg.common.enums.type.LicenseType;
import com.oasis.wolfburg.common.enums.type.PayWay;

@Table(name = "wl_carrier")
@SequenceGenerator(name = "wl_carrier_seq")
@Cache
public class Carrier extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	private Long id;
	
	/**
	 * 承运商编号
	 */
	@Column(name = "carrier_code")
	private String carrierCode;
	
	/**
	 * 承运商全称
	 */
	@Column(name = "carrier_name")
	private String carrierName;
	
	/**
	 * 承运商简称
	 */
	@Column(name = "carrier_Short_Name")
	private String carrierShortName;
	
	/**
	 * 承运商状态
	 */
	@Column(name = "status")
	private CarrierStatus status;
	
	
	/**
	 * 承运商类型
	 */
	@Column(name = "carrier_type")
	private CarrierType carrierType;
	
	/**
	 * 证件类型
	 */
	@Column(name = "license_type")
	private LicenseType licenseType;
	
	/**
	 * 证件号
	 */
	@Column(name = "license_code")
	private String licenseCode;
	
	/**
	 * 安全保证金
	 */
	@Column(name = "guarantee")
	private String guarantee;
	
	/**
	 * 联系人
	 */
	@Column(name = "contact_person")
	private String contactPerson;
	
	/**
	 * 联系地址
	 */
	@Column(name = "contact_address")
	private String contactAddress;
	
	/**
	 * 联系电话
	 */
	@Column(name = "contact_phone")
	private String contactPhone;
	
	/**
	 * 联系手机
	 */
	@Column(name = "contact_mobile")
	private String contactMobile;
	
	/**
	 * 传真
	 */
	@Column(name = "contact_fx")
	private String contactFX;
	
	/**
	 * 电子邮件
	 */
	@Column(name = "contact_email")
	private String contactEmail;
	
	/**
	 * 联系QQ
	 */
	@Column(name = "contact_qq")
	private String contactQQ;
	
	/**
	 * 是否提供发票
	 */
	@Column(name = "invoice")
	private Boolean invoice;
	
	/**
	 * 结算周期
	 */
	@Column(name = "ap_age")
	private Integer apAge;
	
	/**
	 * 开户银行
	 */
	@Column(name = "bank")
	private String bank;
	
	/**
	 * 银行帐号
	 */
	@Column(name = "bank_account")
	private String bankAccount;
	
	/**
	 * 备注
	 */
	@Column(name = "remark")
	private String remark;
	
	/**
	 * 支付方式
	 */
	@Column(name = "pay_way")
	private PayWay payWay;
	
	/**
	 * 挂靠公司
	 */
	@Column(name = "parent_company_id")
	private Long  parentCompanyId;
	
	/**
	 * 挂靠公司
	 */
	@Column(name = "parent_company_name")
	private String parentCompanyName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
