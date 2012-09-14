package com.oasis.wolfburg.common.service.truck;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSScheduleSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSScheduleVO;

public interface TruckRSScheduleService {
	Long createTruckRSSchedule(ClientContext clientContext, TruckRSScheduleVO truckRSScheduleVO);
	
	public void  deleteTruckRSSchedule(ClientContext clientContext, Long id) ;
	
	void updateTruckRSSchedule(ClientContext clientContext, TruckRSScheduleVO truckRSScheduleVO) ;
	
	public PageList<TruckRSScheduleVO> getPageList(ClientContext clientContext, TruckRSScheduleSO so);
	
    public TruckRSScheduleVO findTruckRSSchedule(ClientContext clientContext,Long id);

    void updateStatus(ClientContext clientContext, List<Long> ids);
    
    void closeTruckRSS(ClientContext clientContext,TruckRSScheduleVO vo);
}
