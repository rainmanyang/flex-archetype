package com.oasis.wolfburg.common.so.route;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.type.POSType;

public class PosSO extends BasePageSO {

    private static final long serialVersionUID = -7012848245686479326L;
    
    private String code;

    private String name;
    
    private String shortName;
    
    private POSType type;
    
    private String roadMap;
    
    private String privince;
    
    private String city;
    
    private String district;
    
    private Long organizationId;
    
    private String organizationTreePath;

    private String address;

    private String contactPerson;

    private String contactPhone;

    private String chargePerson;

    private String chargePhone;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public POSType getType() {
        return type;
    }

    public void setType(POSType type) {
        this.type = type;
    }

    public String getRoadMap() {
        return roadMap;
    }

    public void setRoadMap(String roadMap) {
        this.roadMap = roadMap;
    }

    public String getPrivince() {
        return privince;
    }

    public void setPrivince(String privince) {
        this.privince = privince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationTreePath() {
        return organizationTreePath;
    }

    public void setOrganizationTreePath(String organizationTreePath) {
        this.organizationTreePath = organizationTreePath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getChargePhone() {
        return chargePhone;
    }

    public void setChargePhone(String chargePhone) {
        this.chargePhone = chargePhone;
    }
    
    
	
}
