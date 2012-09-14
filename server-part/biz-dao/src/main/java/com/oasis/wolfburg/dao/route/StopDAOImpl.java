package com.oasis.wolfburg.dao.route;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.model.route.Stop;

@Repository
public class StopDAOImpl extends BaseDAO<Stop> implements StopDAO {

    @Override
    public List<Stop> getStopsByRoute(Long routeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ROUTE_ID", routeId);
        List<Stop> retList = super.getModelListByPara(map);
        Collections.sort(retList, new Stop());
        return retList;
    }

}
