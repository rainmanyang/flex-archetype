package com.oasis.wolfburg.dao.truckRSSchedule;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSScheduleSO;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSSchedule;

@Repository
public class TruckRSScheduleDAOImpl extends BaseDAO<TruckRSSchedule> implements TruckRSScheduleDAO {
	private static final String UPDATESTATUS = ".updateStatus";
	
	private static final String UPDATELASTDATE = ".updateLastDate";
	
	private static final String ST_PUBLISH = ".selectPublishList";
	
	private static final String CHECK_DUPLICATION = ".checkDuplication";
	
	public List<TruckRSSchedule> getPaginatedList(TruckRSScheduleSO so) {
        return super.getPaginatedList(so);
    }

    public int getPaginatedListCount(TruckRSScheduleSO so) {
        return super.getPaginatedListCount(so);
    }

    public void updateStatus(List<Long> ids){
		super.getSession().update(getStatementNamespace()+UPDATESTATUS, ids);
	}
    
    public void updateLastDate(List<Long> ids,Date lastDate){
    	Map<String,Object> map = new HashMap<String,Object>();
		map.put("lastDate", lastDate);
		map.put("ids", ids);
    	super.getSession().update(getStatementNamespace()+UPDATELASTDATE, map);
    }
    
	public List<TruckRSSchedule> getPublishList(Date lastDate,int num){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("date", lastDate);
		map.put("num", num);
		@SuppressWarnings("unchecked")
    	List<TruckRSSchedule> list = super.getSession().selectList(getStatementNamespace()+ST_PUBLISH, map);
    	return list;
    }
	
	public int checkDuplication(TruckRSSchedule truckRSSchedule) {
        return (Integer)getSession().selectOne(getStatementNamespace() + CHECK_DUPLICATION, truckRSSchedule);
    }
}
