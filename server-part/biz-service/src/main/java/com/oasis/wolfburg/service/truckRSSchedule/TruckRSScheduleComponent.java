package com.oasis.wolfburg.service.truckRSSchedule;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.wolfburg.common.enums.status.TruckScheduleStatus;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSScheduleSO;
import com.oasis.wolfburg.common.vo.route.StopVO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSScheduleVO;
import com.oasis.wolfburg.dao.route.StopDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobTimeRecordDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSScheduleDAO;
import com.oasis.wolfburg.model.route.Stop;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSSchedule;

@Component
public class TruckRSScheduleComponent extends BaseComponent {
    @Autowired
    private TruckRSScheduleDAO truckRSScheduleDAO;
    
    @Autowired
	private StopDAO stopDAO;
    
    @Autowired
    private TruckRSJobDAO trsJobDAO;
    
    @Autowired
    private TruckRSJobTimeRecordDAO trsJobTRDAO;

    /**
     * 创建时刻表
     * @param truckRSScheduleVO，必须绑定stopList
     * @return
     */
    public Long createTruckRSSchedule(TruckRSScheduleVO truckRSScheduleVO){
    	validateDuplication(truckRSScheduleVO);
        TruckRSSchedule truckRSSchedule =  super.getDozer().convert(truckRSScheduleVO, TruckRSSchedule.class);
    	truckRSSchedule.setStatus(TruckScheduleStatus.NEW);
    	Long id = truckRSScheduleDAO.insert(truckRSSchedule);
    	return id;
    }
    
    private void validateDuplication(TruckRSScheduleVO vo){
    	TruckRSSchedule truckRSSchedule = super.getDozer().convert(vo, TruckRSSchedule.class);
    	Map<String, String> error = new HashMap<String, String>();
    	int cnt = truckRSScheduleDAO.checkDuplication(truckRSSchedule);
    	if(cnt > 0){
    		error.put("nameCN", ErrorDispHelper.getInstance().getValue("TRUCKRSSCHEDULE_ERROR"));
    		throw new ValidationException(error);
    	}
    }
    
    /**
     * 更新时刻表
     * @param truckRSScheduleVO
     */
    public Long updateTruckRSSchedule(TruckRSScheduleVO vo){
    	validateDuplication(vo);
        Long id = vo.getId();
    	TruckRSSchedule oldRSS = truckRSScheduleDAO.find(id);
    	oldRSS.setStatus(TruckScheduleStatus.CLOSED);
    	truckRSScheduleDAO.update(oldRSS);
    	
    	TruckRSSchedule newRSS =  super.getDozer().convert(vo, TruckRSSchedule.class);
    	newRSS.setId(null);
    	newRSS.setVersion(oldRSS.getVersion()+1);
    	return truckRSScheduleDAO.insert(newRSS);
    }
    
    public void closeTruckRSS(TruckRSScheduleVO vo){
    	vo.setStatus(TruckScheduleStatus.CLOSED);
    	TruckRSSchedule rss =  super.getDozer().convert(vo, TruckRSSchedule.class);
    	truckRSScheduleDAO.update(rss);
    	
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_YEAR, 1);
    	List<Long> trsJobIds = trsJobDAO.getTruckRSJobIdsByTruckRSS(cal.getTime(), vo.getId());
    	if(!trsJobIds.isEmpty()){
    		trsJobDAO.deleteByIds(trsJobIds);
        	
        	trsJobTRDAO.deleteByFKIds(trsJobIds);
    	}
    }
    
    /**
     * 删除时刻表
     * @param id
     */
    public void deleteTruckRSSchedule(Long id){
    	truckRSScheduleDAO.delete(id);
    }
    
    public TruckRSScheduleVO findTruckRSSchedule(Long id){
    	TruckRSSchedule truckRSSchedule = truckRSScheduleDAO.find(id);
    	TruckRSScheduleVO result = super.getDozer().convert(truckRSSchedule, TruckRSScheduleVO.class);
    	
    	Long routeId = truckRSSchedule.getRouteId();
    	List<Stop> stopList = stopDAO.getStopsByRoute(routeId);
    	List<StopVO> stopVOList = super.getDozer().convertList(stopList, StopVO.class);
    	
    	fillStopName(result.getStops(),stopVOList);
    	return result;
    }
    /**
     * 给Stop的网点赋值 
     * @param srcStopList 拼装了预计到达时间和预计离开时间
     * @param destStopList 从DB查找出来的 Stop
     * @return
     */
    private void fillStopName(List<StopVO> srcStopList , List<StopVO> destStopList){
    	for(StopVO srcStop : srcStopList){
    		for(StopVO destStop : destStopList){
    			if(srcStop.getId().equals(destStop.getId())){
    				srcStop.setPosName(destStop.getPosName());
    				break;
    			}
    		}
    	}
    }
    /**
	 * 分页查询
	 * @param so
	 * @return
	 */
	public PageList<TruckRSScheduleVO> getPageList(TruckRSScheduleSO so) {
		List<TruckRSSchedule> truckRSScheduleList = truckRSScheduleDAO.getPaginatedList(so);
		List<TruckRSScheduleVO> list = super.getDozer().convertList(truckRSScheduleList, TruckRSScheduleVO.class);
		for (TruckRSScheduleVO tsJob : list) {
			Long routeId = tsJob.getRouteId();
	    	List<Stop> stopList = stopDAO.getStopsByRoute(routeId);
	    	List<StopVO> stopVOList = super.getDozer().convertList(stopList, StopVO.class);
			tsJob.setStops(stopVOList);
		}
		int cnt = truckRSScheduleDAO.getPaginatedListCount(so);
		PageList<TruckRSScheduleVO> page = new PageList<TruckRSScheduleVO>();
		page.setList(list);
		page.setFullListSize(cnt);
		return page;
	}
    
	public void updateStatus(List<Long> ids){
		truckRSScheduleDAO.updateStatus(ids);
	}
}
