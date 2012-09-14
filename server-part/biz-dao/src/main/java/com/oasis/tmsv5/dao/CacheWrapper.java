package com.oasis.tmsv5.dao;

import java.util.Set;

public interface CacheWrapper {
	
	public Object get(String key);
	
	public void put(String key,Object obj);
	
	public void remove(String key);
	
	public Set<String> getObjectNames();
	
	public void clear();
}
