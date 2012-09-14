package com.oasis.wolfburg.common.vo.route;

import java.util.Comparator;
import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;

public class StopVO extends BaseVO implements Comparable<Integer>, Comparator<StopVO> {

    private static final long serialVersionUID = -8527439927824037960L;
    

    private Long id;

    /**
     * 关联的线路ID
     */
    private Long routeId;

    /**
     * 物流节点ID
     */
    private Long posId;
    
    /**
     * 物流节点名称
     */
    private String posName;
    
    /**
     * 站点排序
     */
    private int seqNum;
    
    
    private int arrivalDayType;
    private int leaveDayType;
    private int arrivalHour;
    private int arrivalMinute;
    private int leaveHour;
    private int leaveMinute;
    private Date planInboundTime;
    private Date planOutboundTime;

    public Date getPlanInboundTime() {
		return planInboundTime;
	}

	public void setPlanInboundTime(Date planInboundTime) {
		this.planInboundTime = planInboundTime;
	}

	public Date getPlanOutboundTime() {
		return planOutboundTime;
	}

	public void setPlanOutboundTime(Date planOutboundTime) {
		this.planOutboundTime = planOutboundTime;
	}

	public int getArrivalDayType() {
		return arrivalDayType;
	}

	public void setArrivalDayType(int arrivalDayType) {
		this.arrivalDayType = arrivalDayType;
	}

	public int getLeaveDayType() {
		return leaveDayType;
	}

	public void setLeaveDayType(int leaveDayType) {
		this.leaveDayType = leaveDayType;
	}

	public int getArrivalHour() {
		return arrivalHour;
	}

	public void setArrivalHour(int arrivalHour) {
		this.arrivalHour = arrivalHour;
	}

	public int getArrivalMinute() {
		return arrivalMinute;
	}

	public void setArrivalMinute(int arrivalMinute) {
		this.arrivalMinute = arrivalMinute;
	}

	public int getLeaveHour() {
		return leaveHour;
	}

	public void setLeaveHour(int leaveHour) {
		this.leaveHour = leaveHour;
	}

	public int getLeaveMinute() {
		return leaveMinute;
	}

	public void setLeaveMinute(int leaveMinute) {
		this.leaveMinute = leaveMinute;
	}
	
	public int getSeqNum() {
        return seqNum;
    }
	


    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}
	@Override
    public int compare(StopVO src, StopVO target) {
        return src.compareTo(target.getSeqNum());
    }
	@Override
    public int compareTo(Integer seqNum) {
        return this.getSeqNum() < seqNum ? 0 : 1;
    }

}
