package com.oasis.tmsv5.dao;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.util.cache.DefaultCache;

@Service
public class LocalCacheWrapperImpl implements CacheWrapper {

	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("localCache")
	private DefaultCache defaultcache;

	private static final Log log = LogFactory
			.getLog(LocalCacheWrapperImpl.class);

	@Override
	public Object get(String key) {
		Object obj = defaultcache.get(key);
		if (obj != null) {
			if (log.isDebugEnabled()) {
				log.debug("get obj: " + obj.getClass().getName()
						+ " from localCache");
			}
		}
		return defaultcache.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(String key, Object obj) {
		if (log.isDebugEnabled()) {
				log.debug("put obj: " + obj.getClass().getName()
						+ " to localCache");
		}
		defaultcache.put(key, obj);
	}

	@Override
	public void remove(String key) {
		Object obj = defaultcache.remove(key);
		if(obj != null){
			log.debug("remove obj: " + obj.getClass().getName()
					+ " from localCache");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<String> getObjectNames() {
		return defaultcache.keySet();
	}

	@Override
	public void clear() {
		defaultcache.clear();
	}
	
}
