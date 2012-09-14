package com.oasis.wolfburg.dao.route;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.model.route.Stop;

public interface StopDAO extends DAO<Stop> {

    List<Stop> getStopsByRoute(Long routeId);
	
}
