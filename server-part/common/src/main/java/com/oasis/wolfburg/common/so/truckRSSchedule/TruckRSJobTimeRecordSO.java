package com.oasis.wolfburg.common.so.truckRSSchedule;

import java.util.Date;

import com.oasis.tmsv5.common.util.page.BasePageSO;

public class TruckRSJobTimeRecordSO extends BasePageSO {

    private static final long serialVersionUID = -7012848245686479326L;
    
    
  //以下字段临时使用的，没有对应的数据库列
    private String truckRSJobName;
    /**
     * 车牌号
     */
    private String licensePlate;
    
    
    private String stopName;
    
    private String routeName;
    
    private String requestUrl ;
    
	private String contextPath;
	
	
	public Date beginDate;
	
	public Date endDate;
	

	public String getTruckRSJobName() {
		return truckRSJobName;
	}

	public void setTruckRSJobName(String truckRSJobName) {
		this.truckRSJobName = truckRSJobName;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
    

	
}
