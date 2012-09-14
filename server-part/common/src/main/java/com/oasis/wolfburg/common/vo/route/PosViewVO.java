package com.oasis.wolfburg.common.vo.route;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.type.POSType;

public class PosViewVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 2976829189323742601L;

    /**
     * 
     */

    private Long id;
    
    private String code;

    private String name;
    
    private String shortName;
    
    private POSType type;
    
    private String roadMap;
    
    private String privince;
    
    private String city;
    
    private String district;
    
    private Long privinceId;
    
    private Long cityId;
    
    private Long districtId;
    
    private Long organizationId;
    
    private String organizationTreePath;
    
    private String organizationName;
    
    private String address;

    private String contactPerson;

    private String contactPhone;

    private String chargePerson;

    private String chargePhone;
    
    private String gps;

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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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

    public String getOrganizationTreePath() {
        return organizationTreePath;
    }

    public void setOrganizationTreePath(String organizationTreePath) {
        this.organizationTreePath = organizationTreePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Long getPrivinceId() {
        return privinceId;
    }

    public void setPrivinceId(Long privinceId) {
        this.privinceId = privinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    
}
