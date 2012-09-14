package com.oasis.tmsv5.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.oasis.tmsv5.util.helper.JPAHelper;
import com.oasis.tmsv5.util.helper.PropertyHelper;
import com.oasis.tmsv5.util.query.Cache;

public class CacheInterceptor implements MethodInterceptor {

    private static final Log logger = LogFactory.getLog(CacheInterceptor.class);
    
	@Autowired
    @Qualifier("localCacheWrapperImpl")
    private CacheWrapper cacheImpl;

    @Override
    public Object invoke(MethodInvocation inv) throws Throwable {
        
        Type gsType = inv.getThis().getClass().getGenericSuperclass();
        // 没有继承BaseDAO,直接执行方法
        if (gsType == Object.class) {
            return inv.proceed();
        }
        Class<?> type = (Class<?>) ((ParameterizedType) gsType).getActualTypeArguments()[0];
        if (!(type.isAnnotationPresent(Cache.class) && inv.getMethod().getAnnotation(Cache.class) != null)) {
            return inv.proceed();
        }

        return invokeCache(type, inv);

    }

    @SuppressWarnings("unchecked")
    private Object invokeCache(Class<?> type, MethodInvocation inv) throws Throwable {
        try {
            Cache cache = inv.getMethod().getAnnotation(Cache.class);
            if (cache.action().equals(Cache.FIND)) {
                String key = type.getName() + inv.getArguments()[0];
                Object mObj = cacheImpl.get(key);
                if (mObj != null) {
                    logger.debug(type.getSimpleName() + inv.getArguments()[0] + " loaded from cache.");
                    return mObj;
                } else {
                    mObj = inv.proceed();
                    if (mObj != null) {
						cacheImpl.put(key, mObj);
						logger.debug(type.getSimpleName()
								+ inv.getArguments()[0] + " put into cache.");
					}
					return mObj;
                }

            }

            if (cache.action().equals(Cache.UPDATE)) {
                Long keyId = (Long) PropertyHelper.getValue(inv.getArguments()[0], JPAHelper.getPrimaryKey(type));
                String key = type.getName() + String.valueOf(keyId);
                cacheImpl.remove(key);
                logger.debug(type.getSimpleName() + String.valueOf(keyId) + " removed from cache.");
            }
            if (cache.action().equals(Cache.UPDATE_LIST)) {
                for (Long keyId : (List<Long>) inv.getArguments()[0]) {
                    String key = type.getName() + String.valueOf(keyId);
                    cacheImpl.remove(key);
                    logger.debug(type.getSimpleName() + String.valueOf(keyId) + " removed from cache.");
                }
            }

            if (cache.action().equals(Cache.DELETE)) {
                String key = type.getName() + inv.getArguments()[0];
                cacheImpl.remove(key);
                logger.debug(type.getSimpleName() + inv.getArguments()[0] + " removed from cache.");
            }
            if (cache.action().equals(Cache.DEL_LIST)) {
                for (Long keyId : (List<Long>) inv.getArguments()[0]) {
                    String key = type.getName() + String.valueOf(keyId);
                    cacheImpl.remove(key);
                    logger.debug(type.getSimpleName() + String.valueOf(keyId) + " removed from cache.");
                }
            }
        } catch (Exception e) {
            logger.error("cache handling failed.");
            e.printStackTrace();
        }

        return inv.proceed();

    }

}
