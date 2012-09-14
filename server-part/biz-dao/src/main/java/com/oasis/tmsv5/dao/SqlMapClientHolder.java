package com.oasis.tmsv5.dao;

import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oasis.tmsv5.util.tools.LogMessageUtil;

public class SqlMapClientHolder {

    private static SqlSessionFactory sqlMapper;

    private static final Log logger = LogFactory.getLog(SqlMapClientHolder.class);

    private static SqlMapClientHolder sqlMapClientHolder = new SqlMapClientHolder();

    private SqlMapClientHolder() {
        if (sqlMapper == null) {
            try {
                String ibatisResource = "ibatis-config.xml";
                Reader ibatisReader = Resources.getResourceAsReader(ibatisResource);
                sqlMapper = new SqlSessionFactoryBuilder().build(ibatisReader);
                logger.info("SqlSessionFactory built successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(LogMessageUtil.printStack(e));
                throw new RuntimeException(e);
            }
        }
    }

    public static SqlMapClientHolder getInstance() {
        return sqlMapClientHolder;
    }

    public SqlSessionFactory getSqlMapper() {
        return sqlMapper;
    }
}
