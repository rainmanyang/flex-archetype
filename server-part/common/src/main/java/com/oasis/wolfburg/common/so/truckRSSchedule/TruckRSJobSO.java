package com.oasis.wolfburg.common.so.truckRSSchedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;

public class TruckRSJobSO extends BasePageSO {

    private static final long serialVersionUID = 2800136123549821225L;

    /**
     * 关联时刻表ID
     */
    private Long rsScheduleId;

    private String code;

    private Date startDate;
    
    /**
     * 用于区间查询
     */
    private Date endDate;

    private String licensePlate;

    private String driver;

    /**
     * 车辆标示卡
     */
    private String identityCard;

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

    private RSJobStatus status ;

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
     * 精确车牌号
     */
    private String exactLicensePlate;
    
    private Long startPos;
    
    private Long endPos;
    
    private List<RSJobStatus> statuses = new ArrayList<RSJobStatus>();

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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

	public List<RSJobStatus> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<RSJobStatus> statuses) {
		this.statuses = statuses;
	}

	public String getExactLicensePlate() {
		return exactLicensePlate;
	}

	public void setExactLicensePlate(String exactLicensePlate) {
		this.exactLicensePlate = exactLicensePlate;
	}

    public Long getStartPos() {
        return startPos;
    }

    public void setStartPos(Long startPos) {
        this.startPos = startPos;
    }

    public Long getEndPos() {
        return endPos;
    }

    public void setEndPos(Long endPos) {
        this.endPos = endPos;
    }
	
}
