package com.oasis.wolfburg.dao.driver;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.enums.status.DriverStatus;
import com.oasis.wolfburg.common.so.driver.DriverSO;
import com.oasis.wolfburg.model.driver.Driver;

public interface DriverDAO extends DAO<Driver> {
	List<Driver> getPaginatedList(DriverSO so);
	
	int getPaginatedListCount(DriverSO so);
	
	@Cache(action = Cache.UPDATE_LIST)
	void updateStatus(List<Long> ids,DriverStatus status);
}
