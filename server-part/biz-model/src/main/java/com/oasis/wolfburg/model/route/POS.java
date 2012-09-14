package com.oasis.wolfburg.model.route;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.wolfburg.common.enums.type.POSType;

@Table(name = "WL_POS")
@SequenceGenerator(name = "WL_POS_SEQ")
public class POS extends BaseModel {
    
    /**
     * 
     */
    private static final long serialVersionUID = -559742324747218967L;

    @Id
    private Long id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="short_name")
    private String shortName;

    @Column(name="type")
    private POSType type;

    @Column(name="road_map")
    private String roadMap;

    @Column(name="privince")
    private String privince;
    
    @Column(name="privince_id")
    private Long privinceId;

    @Column(name="city")
    private String city;
    
    @Column(name="city_id")
    private Long cityId;

    @Column(name="district")
    private String district;
    
    @Column(name="district_id")
    private Long districtId;
    
    @Column(name="organization_id")
    private Long organizationId;
    
    @Column(name="organization_treepath")
    private String organizationTreePath;

    @Column(name="address")
    private String address;
    
    @Column(name="contact_person")
    private String contactPerson;
    
    @Column(name="contact_phone")
    private String contactPhone;
    
    @Column(name="charge_person")
    private String chargePerson;
    
    @Column(name="charge_phone")
    private String chargePhone;
    
    @Column(name="gps")
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
