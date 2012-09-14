package com.oasis.wolfburg.dao.route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.route.RouteSO;
import com.oasis.wolfburg.model.route.Route;

@Repository
public class RouteDAOImpl extends BaseDAO<Route> implements RouteDAO {
	
	private static final String CHECKDUPLICATE = ".checkDuplicate";
	
	public List<Route> getPaginatedList(RouteSO so) {
        return super.getPaginatedList(so);
    }

    public int getPaginatedListCount(RouteSO so) {
        return super.getPaginatedListCount(so);
    }
    
    public int checkNameDuplicate(String  name ,Long id){
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("id", id);
    	map.put("name", name);
		return (Integer)super.getSession().selectOne(getStatementNamespace()+CHECKDUPLICATE, map);
	}
    
    public int checkCodeDuplicate(String  code,Long id){
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("id", id);
    	map.put("code", code);
		return (Integer)super.getSession().selectOne(getStatementNamespace()+CHECKDUPLICATE, map);
	}
    
}
