package com.oasis.wolfburg.common.vo.client;

import java.io.Serializable;
import java.util.Date;

public class TRSStop implements Serializable {

    private static final long serialVersionUID = 929501000013035770L;

    /**
     * 网点Id
     */
    private Long id;

    /**
     * 网点名称
     */
    private String name;

    /**
     * 站点序号
     */
    private int seqNum;

    /**
     * 进站时间
     */
    private Date inBoundTime;

    /**
     * 离站时间
     */
    private Date outBoundTime;
    /**
     * 路书
     */
    private String roadMap;
    /**
     * 省份
     */
    private String privince;
    /**
     * 城市
     */
    private String city;
    /**
     * 街区
     */
    private String district;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系人
     */
    private String contactPerson;
    /**
     * 联系电话
     */
    private String contactPhone;

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

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    private String chargePerson;

    private String chargePhone;

    private String gps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public Date getInBoundTime() {
        return inBoundTime;
    }

    public void setInBoundTime(Date inBoundTime) {
        this.inBoundTime = inBoundTime;
    }

    public Date getOutBoundTime() {
        return outBoundTime;
    }

    public void setOutBoundTime(Date outBoundTime) {
        this.outBoundTime = outBoundTime;
    }

}
