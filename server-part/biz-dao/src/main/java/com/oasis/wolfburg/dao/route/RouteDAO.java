package com.oasis.wolfburg.dao.route;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.route.RouteSO;
import com.oasis.wolfburg.model.route.Route;

public interface RouteDAO extends DAO<Route> {
	
	 public List<Route> getPaginatedList(RouteSO so);
	 
	 public int getPaginatedListCount(RouteSO so);
	 
	 
	 
	 public int checkNameDuplicate(String  name ,Long id);
	    
	 public int checkCodeDuplicate(String  code,Long id);
}
