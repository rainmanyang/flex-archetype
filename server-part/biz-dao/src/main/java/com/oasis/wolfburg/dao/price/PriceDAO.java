package com.oasis.wolfburg.dao.price;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.wolfburg.common.enums.type.TruckType;
import com.oasis.wolfburg.common.so.price.PriceSO;
import com.oasis.wolfburg.model.price.Price;

public interface PriceDAO extends DAO<Price> {
	List<Price> getPaginatedList(PriceSO so);
	
	int getPaginatedListCount(PriceSO so);
	
	@Cache(action = Cache.UPDATE_LIST)
	void updateStatus(List<Long> ids);
	
	int checkDuplicate(Price price);
	
	@Cache(action = Cache.UPDATE_LIST)
	void delay(List<Long> ids,int days);

    Price getPrice4TrsJob(Long routeId, TruckType truckType, String truckLevel);
}
