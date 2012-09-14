package com.oasis.wolfburg.common.vo.truckRSSchedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.TruckScheduleStatus;
import com.oasis.wolfburg.common.vo.route.StopVO;

public class TruckRSScheduleVO extends BaseVO {

    private static final long serialVersionUID = 6900817259612978849L;
    
    private String name;
    
    private Long routeId;
    
    private String routeName;
    
    private Long opOrgId;
    
    private String opOrgName;
    
    private Long truckId;
    
    private String truckType;
    
    private String allTime;
    
    private Date beginDate;
    
    private Date endDate;
    
    private String includingDates;
    
    private String excludingDates;
    
    private TruckScheduleStatus status;
    
    private String stopPlanTime;
    
    /**
     * 周日  ----  周六
     */
    private boolean sunday;
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;
    private List<StopVO> stops = new ArrayList<StopVO>();
    
    /**
     * 列表中用于显示
     */
    private String departureTime;
    private String arrivalTime;
    
    public void setStopPlanTime(String stopPlanTime) {
		this.stopPlanTime = stopPlanTime;
		
		/**
		 * TruckRSSchedule转VO时,给stops填值
		 */
		fillStopsByStr(stopPlanTime,stops);
		sortStops();
	}
    
	public void setStops(List<StopVO> stops) {
		this.stops = stops;
		sortStops();
		/**
		 * Flex转VO时,给stopPlanTime组装值
		 */
		this.stopPlanTime = comStrByStops(stops);
	}

	public void setIncludingDates(String includingDates) {
		this.includingDates = includingDates;
		for(int k=0;k<7;k++){
			String str = includingDates.substring(k, k+1);
			switch(Integer.valueOf(str)){
				case Calendar.SUNDAY:
					this.sunday = true;
					break;
				case Calendar.MONDAY:
					this.monday = true;
					break;
				case Calendar.TUESDAY:
					this.tuesday =true;
					break;
				case Calendar.WEDNESDAY:
					this.wednesday = true;
					break;
				case Calendar.THURSDAY:
					this.thursday = true;
					break;
				case Calendar.FRIDAY:
					this.friday = true;
					break;
				case Calendar.SATURDAY:
					this.saturday = true;
					break;
				default:
					break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void sortStops(){
		Collections.sort(stops, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				StopVO stop1 = (StopVO)o1;
				StopVO stop2 = (StopVO)o2;
				return stop1.getSeqNum() < stop2.getSeqNum() ? 0 : 1;
			}
    	});
	}
	
	private String comStrByStops(List<StopVO> stops){
		String result = "";
		for(StopVO stop : stops){
			int seq = stop.getSeqNum();
			
			result += stop.getId();
			result += "_";
			result += seq;
			result += "_";
			if(seq == 1){
				result += "X_XXXXX";
			}else{
				result += stop.getArrivalDayType();
				result += "_";
				result += stop.getArrivalHour();
				result += ":";
				result += stop.getArrivalMinute();
			}
			result += "_";
			if(seq == stops.size()){
				result += "X_XXXXX";
			}else{
				result += stop.getLeaveDayType();
				result += "_";
				result += stop.getLeaveHour();
				result += ":";
				result += stop.getLeaveMinute();
			}
			
			result += "_"+stop.getPosId()+";";
		}
		return result;
	}
    
    private void fillStopsByStr(String stopPlanTime,List<StopVO> stops){
    	if(stops == null){
    		return;
    	}
    	String[] arrs = stopPlanTime.split(";");
    	for(String str : arrs){
			String[] strs = str.split("_");
			StopVO stop = new StopVO();
			int seq = Integer.valueOf(strs[1]);
			stop.setId(Long.valueOf(strs[0]));
			stop.setSeqNum(seq);
			
			String str2 = strs[2];
			if(!str2.equals("X")){
				stop.setArrivalDayType(Integer.valueOf(str2));
				String str3 = strs[3];
				String[] str3s = str3.split(":");
				stop.setArrivalHour(Integer.valueOf(str3s[0]));
				stop.setArrivalMinute(Integer.valueOf(str3s[1]));
			}
			
			String str4 = strs[4];
			if(!str4.equals("X")){
				stop.setLeaveDayType(Integer.valueOf(strs[4]));
				String str5 = strs[5];
				String[] str5s = str5.split(":");
				stop.setLeaveHour(Integer.valueOf(str5s[0]));
				stop.setLeaveMinute(Integer.valueOf(str5s[1]));
			}
			
			stop.setPosId(Long.valueOf(strs[6]));
			stops.add(stop);
			
			if(seq == 1){
				departureTime = getDayDesc(strs[4]) + strs[5];
			}else{
				arrivalTime = getDayDesc(strs[2]) + strs[3];
			}
		}
    	
    }
    
	private String getDayDesc(String day) {
		int dd = Integer.valueOf(day);
		String res = "";
		switch (dd) {
		case 0:
			res = "当日";
			break;
		case 1:
			res = "次日";
			break;
		case 2:
			res = "第三日";
			break;
		}
		return res;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
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

	public boolean isSunday() {
		return sunday;
	}

	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}

	public boolean isMonday() {
		return monday;
	}

	public void setMonday(boolean monday) {
		this.monday = monday;
	}

	public boolean isTuesday() {
		return tuesday;
	}

	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}

	public boolean isWednesday() {
		return wednesday;
	}

	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}

	public boolean isThursday() {
		return thursday;
	}

	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}

	public boolean isFriday() {
		return friday;
	}

	public void setFriday(boolean friday) {
		this.friday = friday;
	}

	public boolean isSaturday() {
		return saturday;
	}

	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}
	
	public List<StopVO> getStops() {
		return stops;
	}
}
