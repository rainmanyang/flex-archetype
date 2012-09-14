package com.oasis.wolfburg.common.vo.truck;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.enums.type.TruckResourceType;
import com.oasis.wolfburg.common.enums.type.TruckType;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;
import com.oasis.wolfburg.common.vo.driver.DriverVO;
import com.oasis.wolfburg.common.vo.insure.InsureVO;
import com.oasis.wolfburg.common.vo.route.RouteVO;
public class TruckVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 牌照
	 */
	private String licensePlate;
	
	/**
	 * 车型
	 */
	private TruckType truckType;
	
	/**
	 * 车长
	 */
	private String truckLength;
	
	/**
	 * 车宽
	 */
	private String truckWidth;
	
	/**
	 * 车高
	 */
	private String truckHeight;
	
	/**
	 * 可装容积
	 */
	private String loadVolume;
	
	/**
	 * 可装重量
	 */
	private String loadWeight;
	
	/**
	 * 车辆状态
	 */
	private TruckStatus status;
	
	/**
	 * 联系人
	 */
	private String contactPerson;
	
	/**
	 * 联系电话1
	 */
	private String contactPhone1;
	
	/**
	 * 联系电话2
	 */
	private String contactPhone2;
	
	/**
	 * gps
	 */
	private String gps;
	
	/**
	 * 卡号
	 */
	private String cardCode;
	
	/**
	 * 承运商id
	 */
	private Long carrierId;
	
	/**
	 * 车主（承运商）
	 */
	private String ownerName;
	
	/**
	 * 车主地址
	 */
	private String ownerAddress;
	
	/**
	 * 车主电话
	 */
	private String ownerPhone;
	
	/**
	 * 整备质量
	 */
	private String emptyWeight;
	
	/**
	 * 核定载质量
	 */
	private String maxWeight;
	
	/**
	 * 总质量
	 */
	private String totalWeight;
	
	/**
	 * 品牌型号
	 */
	private String brand;
	
	/**
	 * 车辆识别代号
	 */
	private String vin;
	
	/**
	 * 引擎号
	 */
	private String engineCode;
	
	/**
	 * 车架号
	 */
	private String truckCode;
	
	/**
	 * 上牌日期
	 */
	private Date licenseDate;
	
	/**
	 * 最近年检日期
	 */
	private Date inspectionDate;
	
	/**
	 * 年检有效期限
	 */
	private Integer inspectionDur;
	
	/**
	 * 失效日期
	 */
	private Date discardDate;
	
	/**
	 * 发证机关
	 */
	private String permissionOrg;
	
	/**
	 * 保险编号1
	 */
	private String insureCode1;
	
	/**
	 * 保险编号2
	 */
	private String insureCode2;
	
	/**
	 * 保险时间起
	 */
	private Date insureFrom;
	
	/**
	 * 保险时间止
	 */
	private Date insureTo;
	
	/**
	 * 当前地点
	 */
	private String location;
	
	/**
	 * 当前城市
	 */
	private String city;
	
	/**
	 * 保险公司
	 */
	private String insurer;
	
	/**
	 * 车辆等级
	 */
	private String truckLevel;
	
	/**
	 * 司机1Id
	 */
	private Long dirver1Id;
	
	/**
	 * 司机1名字
	 */
	private String driver1Name;
	
	/**
	 * 司机1电话
	 */
	private String driver1Phone;
	
	/**
	 * 司机2Id
	 */
	private Long dirver2Id;
	
	/**
	 * 司机2名字
	 */
	private String driver2Name;
	
	/**
	 * 司机2电话
	 */
	private String driver2Phone;
	
	/**
	 * 车辆运行状态
	 */
	private TruckRunningStatus runningStatus;
	
	/**
	 * 挂车编号
	 */
	private String trailerCode;
	
	/**
	 * 合同号
	 */
	private String contractNumber;
	
	/**
	 * 合同时间
	 */
	private Date contractDate;
	
	/**
	 * 合同时间起
	 */
	private Date contractDateFrom;
	
	/**
	 * 合同时间止
	 */
	private Date contractDateTo;

	/**
	 * 保险号多个
	 */
	private String insureCodes;
	
	/**
	 * 资源类型
	 */
	private TruckResourceType resourceType;
	
	private List<InsureVO> insureList = new ArrayList<InsureVO>();
	
	private List<DriverVO> DriverList = new ArrayList<DriverVO>();
	
	private List<RouteVO> contractRouteList = new ArrayList<RouteVO>();
	
	private List<AttachmentVO> attachmentList;

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public TruckType getTruckType() {
		return truckType;
	}

	public void setTruckType(TruckType truckType) {
		this.truckType = truckType;
	}

	public String getTruckLength() {
		return truckLength;
	}

	public void setTruckLength(String truckLength) {
		this.truckLength = truckLength;
	}

	public String getTruckWidth() {
		return truckWidth;
	}

	public void setTruckWidth(String truckWidth) {
		this.truckWidth = truckWidth;
	}

	public String getTruckHeight() {
		return truckHeight;
	}

	public void setTruckHeight(String truckHeight) {
		this.truckHeight = truckHeight;
	}

	public String getLoadVolume() {
		return loadVolume;
	}

	public void setLoadVolume(String loadVolume) {
		this.loadVolume = loadVolume;
	}

	public String getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(String loadWeight) {
		this.loadWeight = loadWeight;
	}

	public TruckStatus getStatus() {
		return status;
	}

	public void setStatus(TruckStatus status) {
		this.status = status;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPhone1() {
		return contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContactPhone2() {
		return contactPhone2;
	}

	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public Long getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getEmptyWeight() {
		return emptyWeight;
	}

	public void setEmptyWeight(String emptyWeight) {
		this.emptyWeight = emptyWeight;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	public String getTruckCode() {
		return truckCode;
	}

	public void setTruckCode(String truckCode) {
		this.truckCode = truckCode;
	}

	public Date getLicenseDate() {
		return licenseDate;
	}

	public void setLicenseDate(Date licenseDate) {
		this.licenseDate = licenseDate;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public Integer getInspectionDur() {
		return inspectionDur;
	}

	public void setInspectionDur(Integer inspectionDur) {
		this.inspectionDur = inspectionDur;
	}

	public String getInsureCode1() {
		return insureCode1;
	}

	public void setInsureCode1(String insureCode1) {
		this.insureCode1 = insureCode1;
	}

	public String getInsureCode2() {
		return insureCode2;
	}

	public void setInsureCode2(String insureCode2) {
		this.insureCode2 = insureCode2;
	}

	public Date getDiscardDate() {
		return discardDate;
	}

	public void setDiscardDate(Date discardDate) {
		this.discardDate = discardDate;
	}

	public String getPermissionOrg() {
		return permissionOrg;
	}

	public void setPermissionOrg(String permissionOrg) {
		this.permissionOrg = permissionOrg;
	}

	public Date getInsureFrom() {
		return insureFrom;
	}

	public void setInsureFrom(Date insureFrom) {
		this.insureFrom = insureFrom;
	}

	public Date getInsureTo() {
		return insureTo;
	}

	public void setInsureTo(Date insureTo) {
		this.insureTo = insureTo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public String getTruckLevel() {
		return truckLevel;
	}

	public void setTruckLevel(String truckLevel) {
		this.truckLevel = truckLevel;
	}

	public Long getDirver1Id() {
		return dirver1Id;
	}

	public void setDirver1Id(Long dirver1Id) {
		this.dirver1Id = dirver1Id;
	}

	public String getDriver1Name() {
		return driver1Name;
	}

	public void setDriver1Name(String driver1Name) {
		this.driver1Name = driver1Name;
	}

	public String getDriver1Phone() {
		return driver1Phone;
	}

	public void setDriver1Phone(String driver1Phone) {
		this.driver1Phone = driver1Phone;
	}

	public Long getDirver2Id() {
		return dirver2Id;
	}

	public void setDirver2Id(Long dirver2Id) {
		this.dirver2Id = dirver2Id;
	}

	public String getDriver2Name() {
		return driver2Name;
	}

	public void setDriver2Name(String driver2Name) {
		this.driver2Name = driver2Name;
	}

	public String getDriver2Phone() {
		return driver2Phone;
	}

	public void setDriver2Phone(String driver2Phone) {
		this.driver2Phone = driver2Phone;
	}

	public TruckRunningStatus getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(TruckRunningStatus runningStatus) {
		this.runningStatus = runningStatus;
	}

	public String getTrailerCode() {
		return trailerCode;
	}

	public void setTrailerCode(String trailerCode) {
		this.trailerCode = trailerCode;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Date getContractDateFrom() {
		return contractDateFrom;
	}

	public void setContractDateFrom(Date contractDateFrom) {
		this.contractDateFrom = contractDateFrom;
	}

	public Date getContractDateTo() {
		return contractDateTo;
	}

	public void setContractDateTo(Date contractDateTo) {
		this.contractDateTo = contractDateTo;
	}

	public String getInsureCodes() {
		return insureCodes;
	}

	public void setInsureCodes(String insureCodes) {
		this.insureCodes = insureCodes;
	}

	public TruckResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(TruckResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public List<InsureVO> getInsureList() {
		return insureList;
	}

	public void setInsureList(List<InsureVO> insureList) {
		this.insureList = insureList;
	}

	public List<DriverVO> getDriverList() {
		return DriverList;
	}

	public void setDriverList(List<DriverVO> driverList) {
		DriverList = driverList;
	}

	public List<RouteVO> getContractRouteList() {
		return contractRouteList;
	}

	public void setContractRouteList(List<RouteVO> contractRouteList) {
		this.contractRouteList = contractRouteList;
	}
	
}
