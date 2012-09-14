package com.oasis.tmsv5.common.vo.address;

import com.oasis.tmsv5.common.vo.BaseVO;

public class AddressVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private Long naturalZoneId;

    private String postCode;

    private String street;

    private String area;

	public Long getNaturalZoneId() {
		return naturalZoneId;
	}

	public void setNaturalZoneId(Long naturalZoneId) {
		this.naturalZoneId = naturalZoneId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
