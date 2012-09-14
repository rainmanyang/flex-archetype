package com.oasis.wolfburg.dao.price;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.enums.status.PriceStatus;
import com.oasis.wolfburg.common.enums.type.TruckType;
import com.oasis.wolfburg.common.so.price.PriceSO;
import com.oasis.wolfburg.model.price.Price;

@Repository
public class PriceDAOImpl extends BaseDAO<Price> implements PriceDAO {
	private static final String UPDATESTATUS = ".updateStatus";
	
	private static final String CHECKDUPLICATE = ".checkDuplicate";
	
	private static final String DELAY = ".delay";
	
	public List<Price> getPaginatedList(PriceSO so) {
		return super.getPaginatedList(so);
	}

	public int getPaginatedListCount(PriceSO so) {
		return super.getPaginatedListCount(so);
	}
	
	public void updateStatus(List<Long> ids){
		super.getSession().update(getStatementNamespace()+UPDATESTATUS, ids);
	}
	
	public int checkDuplicate(Price price){
		return (Integer)super.getSession().selectOne(getStatementNamespace()+CHECKDUPLICATE, price);
	}
	
	public void delay(List<Long> ids,int days){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("days", days);
		map.put("ids", ids);
		super.getSession().update(getStatementNamespace()+DELAY, map);
	}

    @Override
    public Price getPrice4TrsJob(Long routeId, TruckType truckType, String truckLevel) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ROUTE_ID", routeId);
        map.put("truck_type", truckType);
        map.put("truck_level", truckLevel);
        map.put("status", PriceStatus.EFFECTIVE.name());
        Price ret=super.getModelByPara(map);
        return ret;
    }
}
