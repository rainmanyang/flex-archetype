package com.oasis.wolfburg.common.so.predefinedCode;

import com.oasis.tmsv5.common.enums.type.PredefinedCodeType;
import com.oasis.tmsv5.common.util.page.BasePageSO;

public class PredefinedCodeSO extends BasePageSO {
	private static final long serialVersionUID = 1L;
	
	private String value;
	
	private String description;
	
	private PredefinedCodeType type;

	public PredefinedCodeType getType() {
		return type;
	}

	public void setType(PredefinedCodeType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
