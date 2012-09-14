package com.oasis.wolfburg.model.truck;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.enums.type.TruckResourceType;
import com.oasis.wolfburg.common.enums.type.TruckType;


@Table(name = "wl_truck")
@SequenceGenerator(name = "wl_truck_seq")
public class Truck extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	@Id
	private Long id;
	
	/**
	 * 牌照
	 */
	@Column(name = "license_plate")
	private String licensePlate;
	
	/**
	 * 车型
	 */
	@Column(name = "truck_type")
	private TruckType truckType;
	
	/**
	 * 车长
	 */
	@Column(name = "truck_length")
	private String truckLength;
	
	/**
	 * 车宽
	 */
	@Column(name = "truck_width")
	private String truckWidth;
	
	/**
	 * 车高
	 */
	@Column(name = "truck_height")
	private String truckHeight;
	
	/**
	 * 可装容积
	 */
	@Column(name = "load_volume")
	private String loadVolume;
	
	/**
	 * 可装重量
	 */
	@Column(name = "load_weight")
	private String loadWeight;
	
	/**
	 * 车辆状态
	 */
	@Column(name = "status")
	private TruckStatus status;
	
	/**
	 * 联系人
	 */
	@Column(name = "contact_person")
	private String contactPerson;
	
	/**
	 * 联系电话
	 */
	@Column(name = "contact_phone1")
	private String contactPhone1;
	
	/**
	 * 联系电话
	 */
	@Column(name = "contact_phone2")
	private String contactPhone2;
	
	/**
	 * gps
	 */
	@Column(name = "gps")
	private String gps;
	
	/**
	 * 卡号
	 */
	@Column(name = "card_code")
	private String cardCode;
	
	/**
	 * 承运商id
	 */
	@Column(name = "carrier_id")
	private Long carrierId;
	
	/**
	 * 车主（承运商）
	 */
	@Column(name = "owner_name")
	private String ownerName;
	
	/**
	 * 车主地址
	 */
	@Column(name = "owner_address")
	private String ownerAddress;
	
	/**
	 * 车主电话
	 */
	@Column(name = "owner_phone")
	private String ownerPhone;
	
	/**
	 * 整备质量
	 */
	@Column(name = "empty_weight")
	private String emptyWeight;
	
	/**
	 * 核定载质量
	 */
	@Column(name = "max_weight")
	private String maxWeight;
	
	/**
	 * 总质量
	 */
	@Column(name = "total_weight")
	private String totalWeight;
	
	/**
	 * 品牌型号
	 */
	@Column(name = "brand")
	private String brand;
	
	/**
	 * 车辆识别代号
	 */
	@Column(name = "vin")
	private String vin;
	
	/**
	 * 引擎号
	 */
	@Column(name = "engine_code")
	private String engineCode;
	
	/**
	 * 车架号
	 */
	@Column(name = "truck_code")
	private String truckCode;
	
	/**
	 * 上牌日期
	 */
	@Column(name = "license_date")
	private Date licenseDate;
	
	/**
	 * 最近年检日期
	 */
	@Column(name = "inspection_date")
	private Date inspectionDate;
	
	/**
	 * 年检有效期限
	 */
	@Column(name = "inspection_dur")
	private Integer inspectionDur;
	
	/**
	 * 失效日期
	 */
	@Column(name = "discard_date")
	private Date discardDate;
	
	/**
	 * 发证机关
	 */
	@Column(name = "permission_org")
	private String permissionOrg;
	
	/**
	 * 当前地点
	 */
	@Column(name = "location")
	private String location;
	
	/**
	 * 当前城市
	 */
	@Column(name = "city")
	private String city;
	
	/**
	 * 车辆等级
	 */
	@Column(name = "truck_level")
	private String truckLevel;
	
	/**
	 * 司机1Id
	 */
	@Column(name = "dirver1_id")
	private Long dirver1Id;
	
	/**
	 * 司机1名字
	 */
	@Column(name = "driver1_name")
	private String driver1Name;
	
	/**
	 * 司机1电话
	 */
	@Column(name = "driver1_phone")
	private String driver1Phone;
	
	/**
	 * 司机2Id
	 */
	@Column(name = "dirver2_id")
	private Long dirver2Id;
	
	/**
	 * 司机2名字
	 */
	@Column(name = "driver2_name")
	private String driver2Name;
	
	/**
	 * 司机2电话
	 */
	@Column(name = "driver2_phone")
	private String driver2Phone;
	
	/**
	 * 车辆运行状态
	 */
	@Column(name = "running_status")
	private TruckRunningStatus runningStatus = TruckRunningStatus.FREE;
	
	/**
	 * 挂车编号
	 */
	@Column(name = "trailer_code")
	private String trailerCode;
	
	/**
	 * 合同号
	 */
	@Column(name = "contract_number")
	private String contractNumber;
	
	/**
	 * 合同时间
	 */
	@Column(name = "contract_date")
	private Date contractDate;
	
	/**
	 * 合同时间起
	 */
	@Column(name = "contract_date_from")
	private Date contractDateFrom;
	
	/**
	 * 合同时间止
	 */
	@Column(name = "contract_date_to")
	private Date contractDateTo;
	

	/**
	 * 保险号多个
	 */
	@Column(name = "insure_codes")
	private String insureCodes;
	
	/**
	 * 资源类型
	 */
	@Column(name = "resource_type")
	private TruckResourceType resourceType = TruckResourceType.TEMP;
	
	/**
	 * 是否被计划
	 */
	@Column(name = "planed")
	private Integer planed = 0;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getPlaned() {
		return planed;
	}

	public void setPlaned(Integer planed) {
		this.planed = planed;
	}

}
