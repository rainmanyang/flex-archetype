package com.oasis.wolfburg.dao.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.enums.status.DriverStatus;
import com.oasis.wolfburg.common.so.driver.DriverSO;
import com.oasis.wolfburg.model.driver.Driver;

@Repository
public class DriverDAOImpl extends BaseDAO<Driver> implements DriverDAO {
	private static final String UPDATESTATUS = ".updateStatus";
	
	public List<Driver> getPaginatedList(DriverSO so) {
		return super.getPaginatedList(so);
	}

	public int getPaginatedListCount(DriverSO so) {
		return super.getPaginatedListCount(so);
	}
	
	public void updateStatus(List<Long> ids,DriverStatus status){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", status);
		map.put("ids", ids);
		super.getSession().update(getStatementNamespace()+UPDATESTATUS, map);
	}
}
