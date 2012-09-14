package com.oasis.tmsv5.model.address;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Cache
@Table(name = "GT_ADDRESS")
@SequenceGenerator(name = "ADDR_SEQ")
public class Address extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	@Id
    private Long id;

    @Column(name = "NATURAL_ZONE")
    private Long naturalZoneId;

    private String postCode;

    private String street;

    private String area;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
