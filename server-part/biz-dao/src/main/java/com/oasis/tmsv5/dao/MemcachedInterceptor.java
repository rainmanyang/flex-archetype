package com.oasis.tmsv5.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.meetup.memcached.MemcachedClient;
import com.meetup.memcached.SockIOPool;
import com.oasis.tmsv5.util.helper.JPAHelper;
import com.oasis.tmsv5.util.helper.PropertyHelper;
import com.oasis.tmsv5.util.query.Cache;
import com.oasis.tmsv5.util.tools.LogMessageUtil;

public class MemcachedInterceptor implements MethodInterceptor {

    private static MemcachedClient memCachedClient = null;

    private static final Log logger = LogFactory.getLog(MemcachedInterceptor.class);

    private static final String FILE = "memcache.properties";

    static {
        initialize();
    }

    private static void initialize() {
        Configuration config = null;
        try {
            config = new PropertiesConfiguration(FILE);
            String server = config.getString("server");
            if ("0.0.0.0".equals(server)) {
                logger.info("Memcached disabled.");
                return;
            }
            String[] servers = { server };
            SockIOPool pool = SockIOPool.getInstance();
            pool.setServers(servers);
            pool.setFailover(true);
            pool.setInitConn(10);
            pool.setMinConn(5);
            pool.setMaxConn(250);
            pool.setMaintSleep(30);
            pool.setNagle(false);
            pool.setSocketTO(3000);
            pool.setAliveCheck(true);
            pool.initialize();
            /* 建立MemcachedClient实例 */
            memCachedClient = new MemcachedClient();
        } catch (Exception e) {
            logger.error(LogMessageUtil.printStack(e));
            return;
        }

    }

    @Override
    public Object invoke(MethodInvocation inv) throws Throwable {
        if (memCachedClient == null) {
            return inv.proceed();
        }

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
                inv.getArguments();
                String key = type.getName() + inv.getArguments()[0];
                Object mObj = memCachedClient.get(key);
                if (mObj != null) {
                    logger.info(type.getSimpleName() + inv.getArguments()[0] + " loaded from memCache.");
                    return mObj;
                } else {
                    mObj = inv.proceed();
                    memCachedClient.set(key, mObj);
                    logger.info(type.getSimpleName() + inv.getArguments()[0] + " put into memCache.");
                    return mObj;
                }

            }

            if (cache.action().equals(Cache.UPDATE)) {
                Long keyId = (Long) PropertyHelper.getValue(inv.getArguments()[0], JPAHelper.getPrimaryKey(type));
                String key = type.getName() + String.valueOf(keyId);
                memCachedClient.delete(key);
                logger.info(type.getSimpleName() + String.valueOf(keyId) + " removed from memCache.");
            }
            if (cache.action().equals(Cache.UPDATE_LIST)) {
                for (Long keyId : (List<Long>) inv.getArguments()[0]) {
                    String key = type.getName() + String.valueOf(keyId);
                    memCachedClient.delete(key);
                    logger.info(type.getSimpleName() + String.valueOf(keyId) + " removed from memCache.");
                }
            }

            if (cache.action().equals(Cache.DELETE)) {
                String key = type.getName() + inv.getArguments()[0];
                memCachedClient.delete(key);
                logger.info(type.getSimpleName() + inv.getArguments()[0] + " removed from memCache.");
            }
            if (cache.action().equals(Cache.DEL_LIST)) {
                for (Long keyId : (List<Long>) inv.getArguments()[0]) {
                    String key = type.getName() + String.valueOf(keyId);
                    memCachedClient.delete(key);
                    logger.info(type.getSimpleName() + String.valueOf(keyId) + " removed from memCache.");
                }
            }
        } catch (Exception e) {
            logger.error("Memcache handling failed.");
            e.printStackTrace();
        }

        return inv.proceed();

    }

    public static void main(String... s) {
        /* 初始化SockIOPool，管理memcached的连接池 */
        String[] servers = { "172.18.9.171:12111" };
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(10);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();
        /* 建立MemcachedClient实例 */
        MemcachedClient memCachedClient = new MemcachedClient();
        memCachedClient.set("10001", "Pick");
        System.out.println(memCachedClient.get("10001"));

    }

}
