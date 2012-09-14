package com.oasis.tmsv5.common.vo.customer;

import com.oasis.tmsv5.common.enums.status.CommonStatus;
import com.oasis.tmsv5.common.enums.type.CurrencyType;
import com.oasis.tmsv5.common.enums.type.CustomerPaymentMethod;
import com.oasis.tmsv5.common.enums.type.SettlementMethod;
import com.oasis.tmsv5.common.vo.BaseVO;


public class CustomerVO extends BaseVO{

	private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private CommonStatus status;

    private Long parentId;

    private Long addressId;

    private String contactPersonName;

    private String contactPhone;

    private boolean byDefault;

    /**
     * 是否投保
     */
    private boolean insured;

    /**
     * 投保费率
     */
    private Double insuredRate;

    /**
     * default transportation method[by truck,by air,by train,by ship...],value
     * from predefined code.
     */
    private Long transType;

    private String shortName;

    private String shortCode;

    private Long profileId;

    private String brevityCode;
    
    private CustomerPaymentMethod paymentMethod;
    
    private CurrencyType paymentCurrency;
    
    private SettlementMethod quotationType;
    
    private Double accountAmount;

    private Long accountUnitId;
    
    private Double apAmount;

    private Long apUnitId;
    
    private Boolean contracted;

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

	public boolean isByDefault() {
		return byDefault;
	}

	public void setByDefault(boolean byDefault) {
		this.byDefault = byDefault;
	}

	public boolean isInsured() {
		return insured;
	}

	public void setInsured(boolean insured) {
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
