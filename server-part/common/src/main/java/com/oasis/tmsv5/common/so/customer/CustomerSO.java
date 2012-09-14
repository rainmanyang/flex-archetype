package com.oasis.tmsv5.common.so.customer;

import com.oasis.tmsv5.common.util.page.BasePageSO;

public class CustomerSO extends BasePageSO {
	private static final long serialVersionUID = 1L;

	private String codeName;
	
	private String parentCodeName;
	
	private String shortName;

    private String shortCode;
    
    private String paymentMethod;
    
    private Boolean contracted;

	private String code;

    private String name;

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getParentCodeName() {
		return parentCodeName;
	}

	public void setParentCodeName(String parentCodeName) {
		this.parentCodeName = parentCodeName;
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

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Boolean getContracted() {
		return contracted;
	}

	public void setContracted(Boolean contracted) {
		this.contracted = contracted;
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
}
