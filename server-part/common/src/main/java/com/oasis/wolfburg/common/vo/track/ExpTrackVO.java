package com.oasis.wolfburg.common.vo.track;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.ExpDealStatus;
import com.oasis.wolfburg.common.enums.status.ExpGrade;
import com.oasis.wolfburg.common.enums.status.ExpType;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;

public class ExpTrackVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String licensePlate;

	private String rssJobCode;
	
	private Long rsJobId;
	
	private RSJobStatus rsJobStatus;
	
	private String rsScheduleName;
	
    private Long rsScheduleId;
    
    private String routeName;
    
    private ExpType expType;
    
    private ExpGrade expGrade;
    
    private String expContent;
    
    private String delayTime;
    
    private String reporter;
    
    private String contactPhone;
    
    private ExpDealStatus status;
    
    private String expDealer;
    
    private Date expDealTime;
    
    private String expDealContent;
    
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getRssJobCode() {
		return rssJobCode;
	}

	public void setRssJobCode(String rssJobCode) {
		this.rssJobCode = rssJobCode;
	}

	public String getRsScheduleName() {
		return rsScheduleName;
	}

	public void setRsScheduleName(String rsScheduleName) {
		this.rsScheduleName = rsScheduleName;
	}

	public Long getRsScheduleId() {
		return rsScheduleId;
	}

	public void setRsScheduleId(Long rsScheduleId) {
		this.rsScheduleId = rsScheduleId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public ExpType getExpType() {
		return expType;
	}

	public void setExpType(ExpType expType) {
		this.expType = expType;
	}

	public ExpGrade getExpGrade() {
		return expGrade;
	}

	public void setExpGrade(ExpGrade expGrade) {
		this.expGrade = expGrade;
	}

	public String getExpContent() {
		return expContent;
	}

	public void setExpContent(String expContent) {
		this.expContent = expContent;
	}

	public String getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(String delayTime) {
		this.delayTime = delayTime;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public ExpDealStatus getStatus() {
		return status;
	}

	public void setStatus(ExpDealStatus status) {
		this.status = status;
	}

	public String getExpDealer() {
		return expDealer;
	}

	public void setExpDealer(String expDealer) {
		this.expDealer = expDealer;
	}

	public Date getExpDealTime() {
		return expDealTime;
	}

	public void setExpDealTime(Date expDealTime) {
		this.expDealTime = expDealTime;
	}

	public String getExpDealContent() {
		return expDealContent;
	}

	public void setExpDealContent(String expDealContent) {
		this.expDealContent = expDealContent;
	}

	public Long getRsJobId() {
		return rsJobId;
	}

	public void setRsJobId(Long rsJobId) {
		this.rsJobId = rsJobId;
	}
	
	public RSJobStatus getRsJobStatus() {
		return rsJobStatus;
	}

	public void setRsJobStatus(RSJobStatus rsJobStatus) {
		this.rsJobStatus = rsJobStatus;
	}
}
