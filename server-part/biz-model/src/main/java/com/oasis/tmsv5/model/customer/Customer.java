package com.oasis.tmsv5.model.customer;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;

import com.oasis.tmsv5.common.enums.status.CommonStatus;
import com.oasis.tmsv5.common.enums.type.CurrencyType;
import com.oasis.tmsv5.common.enums.type.CustomerPaymentMethod;
import com.oasis.tmsv5.common.enums.type.SettlementMethod;
import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;

@Table(name = "GT_CUSTOMER")
@SequenceGenerator(name = "CUS_SEQ")
@Cache
public class Customer extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Id
    private Long id;

    private String code;

    private String name;

    private CommonStatus status;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "contact_Person_Name")
    private String contactPersonName;

    private String contactPhone;

    private Boolean byDefault = Boolean.FALSE;

    /**
     * 是否投保
     */
    private Boolean insured = Boolean.FALSE;

    /**
     * 投保费率
     */
    @Column(name = "INSURED_RATE")
    private Double insuredRate;

    /**
     * default transportation method[by truck,by air,by train,by ship...],value
     * from predefined code.
     */
    @Column(name = "PD_TRANS_TYPE")
    private Long transType;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "SHORT_CODE")
    private String shortCode;

    @Column(name = "PROFILE_ID")
    private Long profileId;

    @Column(name="brevity_code")
    private String brevityCode;
    
    private CustomerPaymentMethod paymentMethod;
    
    @Column(name = "payment_Currency")
    private CurrencyType paymentCurrency;
    
    @Column(name = "default_quotation_type")
    private SettlementMethod quotationType;
    
    @Column(name = "account_Period_Scale")
    private Double accountAmount = new Double(0.0);

    @Column(name = "PD_account_Period_Scale_unit")
    private Long accountUnitId;
    
    @Column(name = "ap_Age")
    private Double apAmount = new Double(0.0);

    @Column(name = "PD_ap_Age_unit")
    private Long apUnitId;
    
    private Boolean contracted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Boolean getByDefault() {
		return byDefault;
	}

	public void setByDefault(Boolean byDefault) {
		this.byDefault = byDefault;
	}

	public Boolean getInsured() {
		return insured;
	}

	public void setInsured(Boolean insured) {
		this.insured = insured;
	}

	public Double getInsuredRate() {
		return insuredRate;
	}

	public void setInsuredRate(Double insuredRate) {
		this.insuredRate = insuredRate;
	}

	public Long getTransType() {
		return transType;
	}

	public void setTransType(Long transType) {
		this.transType = transType;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getBrevityCode() {
		return brevityCode;
	}

	public void setBrevityCode(String brevityCode) {
		this.brevityCode = brevityCode;
	}

	public CommonStatus getStatus() {
		return status;
	}

	public void setStatus(CommonStatus status) {
		this.status = status;
	}

	public CustomerPaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(CustomerPaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public CurrencyType getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(CurrencyType paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public SettlementMethod getQuotationType() {
		return quotationType;
	}

	public void setQuotationType(SettlementMethod quotationType) {
		this.quotationType = quotationType;
	}

	public Double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(Double accountAmount) {
		this.accountAmount = accountAmount;
	}

	public Long getAccountUnitId() {
		return accountUnitId;
	}

	public void setAccountUnitId(Long accountUnitId) {
		this.accountUnitId = accountUnitId;
	}

	public Double getApAmount() {
		return apAmount;
	}

	public void setApAmount(Double apAmount) {
		this.apAmount = apAmount;
	}

	public Long getApUnitId() {
		return apUnitId;
	}

	public void setApUnitId(Long apUnitId) {
		this.apUnitId = apUnitId;
	}

	public Boolean getContracted() {
		return contracted;
	}

	public void setContracted(Boolean contracted) {
		this.contracted = contracted;
	}

}
