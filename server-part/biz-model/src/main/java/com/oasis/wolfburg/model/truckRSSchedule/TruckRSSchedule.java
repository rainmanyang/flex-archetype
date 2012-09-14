package com.oasis.wolfburg.model.truckRSSchedule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.enums.status.TruckScheduleStatus;

@Table(name = "WL_TRUCKRS_SCHEDULE")
@SequenceGenerator(name = "WL_TRUCKRS_SCHEDULE_SEQ")
@Cache
public class TruckRSSchedule extends BaseModel {

	private static final long serialVersionUID = 6900817259612978849L;

	@Id
	private Long id;

	/**
	 * 班车时刻表名称
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 线路ID
	 */
	@Column(name = "routeId")
	private Long routeId;

	/**
	 * 线路名称
	 */
	@Column(name = "route_name")
	private String routeName;

	/**
	 * 组织ID
	 */
	@Column(name = "op_org_id")
	private Long opOrgId;

	/**
	 * 组织名称
	 */
	@Column(name = "op_org_name")
	private String opOrgName;

	/**
	 * 车型ID
	 */
	@Column(name = "truck_id")
	private Long truckId;

	/**
	 * 车辆类型
	 */
	@Column(name = "truck_type")
	private String truckType;

	/**
	 * 花费总时间
	 */
	@Column(name = "all_time")
	private String allTime;

	/**
	 * 开始时间
	 */
	@Column(name = "begin_date")
	private Date beginDate;

	/**
	 * 结束时间
	 */
	@Column(name = "end_date")
	private Date endDate;

	/**
	 * 开班日:不开班为0;开班,周日为1,周一为2,周六为7;例:1234567(全开)
	 */
	@Column(name = "including_dates")
	private String includingDates;

	/**
	 * 例外日期：2011-07-24;2011-07-23 分号分隔
	 */
	@Column(name = "excluding_dates")
	private String excludingDates;

	/**
	 * 班车计划状态：正常、停用
	 */
	@Column(name = "status")
	private TruckScheduleStatus status;

	/**
	 * 线路上各个站点预计达到时间的基础数据，格式如下：
	 * stopId_seqNum_预计到达日_预计到达时间_预计离开日_预计离开时间_posId 首站到达日和时间无意义,用X_XXXXX表示
	 * 末站离开日和时间无意义,用X_XXXXX表示
	 * 79200_1_X_XXXXX_0_12:30_63201;79400_2_1_06:50_1_07:23_63000;
	 * 78200_3_1_23:45_2_00:35_63201;82200_4_2_11:40_X_XXXXX_63201;
	 */
	@Column(name = "stop_plan_time")
	private String stopPlanTime;

	/**
	 * 版本号
	 */
	private int version;

	/**
	 * 此日期含及以前的JOB记录均已生成
	 */
	@Column(name = "last_date")
	private Date lastDate;

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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

	public Long getOpOrgId() {
		return opOrgId;
	}

	public void setOpOrgId(Long opOrgId) {
		this.opOrgId = opOrgId;
	}

	public String getOpOrgName() {
		return opOrgName;
	}

	public void setOpOrgName(String opOrgName) {
		this.opOrgName = opOrgName;
	}

	public Long getTruckId() {
		return truckId;
	}

	public void setTruckId(Long truckId) {
		this.truckId = truckId;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public String getAllTime() {
		return allTime;
	}

	public void setAllTime(String allTime) {
		this.allTime = allTime;
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

	public String getIncludingDates() {
		return includingDates;
	}

	public void setIncludingDates(String includingDates) {
		this.includingDates = includingDates;
	}

	public String getExcludingDates() {
		return excludingDates;
	}

	public void setExcludingDates(String excludingDates) {
		this.excludingDates = excludingDates;
	}

	public TruckScheduleStatus getStatus() {
		return status;
	}

	public void setStatus(TruckScheduleStatus status) {
		this.status = status;
	}

	public String getStopPlanTime() {
		return stopPlanTime;
	}

	public void setStopPlanTime(String stopPlanTime) {
		this.stopPlanTime = stopPlanTime;
	}

}
