package com.oasis.wolfburg.common.vo.truckRSSchedule;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
import com.oasis.wolfburg.common.enums.type.RSJobType;

public class TruckRSJobVO extends BaseVO {

    private static final long serialVersionUID = 2800136123549821225L;

    /**
     * 关联时刻表ID
     */
    private Long rsScheduleId;

    private String code;

    private Date startDate;

    private String licensePlate;

    private String driver;

    /**
     * 车辆标示卡
     */
    private String identityCard;

    private Long truckId;

    /**
     * 任务单打印唯一码
     */
    private String pinCode;

    /**
     * 任务单扫描唯一码
     */
    private String scanCode;

    /**
     * 铅封号
     */
    private String sealCode;

    private RSJobStatus status = RSJobStatus.NEW;

    private Long routeId;

    private String routeName;

    /**
     * 合同费用
     */
    private String contrackPrice;

    /**
     * 空驶费用
     */
    private String emptyPrice;

    /**
     * 加班费用
     */
    private String overTimePrice;

    /**
     * 费率本编号
     */
    private String priceCode;

    /**
     * 班车类型
     */
    private RSJobType rsJobType;
    
    private String rsName;

    private int asco_RsJobId;

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    public String getCode() {
        return code;
    }

    public Long getRsScheduleId() {
        return rsScheduleId;
    }

    public void setRsScheduleId(Long rsScheduleId) {
        this.rsScheduleId = rsScheduleId;
    }

    public String getSealCode() {
        return sealCode;
    }

    public void setSealCode(String sealCode) {
        this.sealCode = sealCode;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getContrackPrice() {
        return contrackPrice;
    }

    public void setContrackPrice(String contrackPrice) {
        this.contrackPrice = contrackPrice;
    }

    public String getEmptyPrice() {
        return emptyPrice;
    }

    public void setEmptyPrice(String emptyPrice) {
        this.emptyPrice = emptyPrice;
    }

    public String getOverTimePrice() {
        return overTimePrice;
    }

    public void setOverTimePrice(String overTimePrice) {
        this.overTimePrice = overTimePrice;
    }

    public void setCode(String code) {
    	if (code != null) {
    		rsName = code.substring(0, code.lastIndexOf("-"));
    	}
        this.code = code;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getScanCode() {
        return scanCode;
    }

    public void setScanCode(String scanCode) {
        this.scanCode = scanCode;
    }

    public RSJobStatus getStatus() {
        return status;
    }

    public void setStatus(RSJobStatus status) {
        this.status = status;
    }

    public RSJobType getRsJobType() {
        return rsJobType;
    }

    public void setRsJobType(RSJobType rsJobType) {
        this.rsJobType = rsJobType;
    }

    public int getAsco_RsJobId() {
        return asco_RsJobId;
    }

    public void setAsco_RsJobId(int ascoRsJobId) {
        asco_RsJobId = ascoRsJobId;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public String getRsName() {
        return rsName;
    }

	public void setRsName(String rsName) {
		this.rsName = rsName;
	}
}
