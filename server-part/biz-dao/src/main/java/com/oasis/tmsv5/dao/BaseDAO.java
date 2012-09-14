package com.oasis.tmsv5.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.security.ClientContextHolder;
import com.oasis.tmsv5.util.exception.OptLockException;
import com.oasis.tmsv5.util.exception.QueryException;
import com.oasis.tmsv5.util.helper.JPAHelper;
import com.oasis.tmsv5.util.helper.ModelColumn;
import com.oasis.tmsv5.util.helper.PropertyHelper;

public abstract class BaseDAO<T extends Serializable> implements DAO<T> {

    /**
     * if sqlmapping include chinese character ,have to fix the charset
     */
    static {
        Resources.setCharset(Charset.forName("UTF-8"));
    }

    private static final Log logger = LogFactory.getLog(BaseDAO.class);

    private static final String ST_FIND = ".find";

    private static final String ST_INSERT = ".insert";

    private static final String ST_UPDATE = ".update";

    private static final String ST_DELETE = ".delete";

    private static final String ST_SELECT = ".select";

    private static final String ST_SELECT_LIST = ".selectList";

    private static final String ST_SELECT_COUNT = ".selectCount";

    private static final String ST_SELECT_PAGELIST = ".selectPageList";

    private static final String ST_DELETE_IDS = ".deleteByIds";

    private static final String ST_SELECT_IDS = ".selectByIds";

    private static final String ST_SEARCHLIST_BY_PARA = ".getModelListByPara";

    private static final String ST_SELECT_BY_FK = ".selectListByFKId";

    private static final String ID = "id";

    private static final String TABLE = "table";

    private static final String SEQUENCE = "sequence";

    protected Class<T> type = null;

    @SuppressWarnings("unchecked")
    public BaseDAO() {
        type = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected SqlSession getSession() {
        return SqlSessionHolder.getSession();
    }

    @SuppressWarnings("unchecked")
    public T find(Long id) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            String table = JPAHelper.getTableName(type);
            map.put(ID, id);
            map.put(TABLE, table);

            T ret = (T) SqlSessionHolder.getSession().selectOne(getStatementNamespace() + ST_FIND, map);
            if (ret == null) {
                logger.warn("Cann't find record by ID=" + String.valueOf(id));
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        }
    }

    public T update(T paraObject) {
        try {
            Map<String, Object> map = getUpdateMap(paraObject);
            int records = SqlSessionHolder.getSession().update(getStatementNamespace() + ST_UPDATE, map);
            if (records == 0 || records == -1) {
                throw new OptLockException("This record modified by another thread before commit,please try again");
            }

            T ret = find((Long) PropertyHelper.getValue(paraObject, JPAHelper.getPrimaryKey(type)));
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        }
    }

    public Long insert(T paraObject) {
        try {
            Map<String, Object> map = getInsertMap(paraObject);
            SqlSessionHolder.getSession().insert(getStatementNamespace() + ST_INSERT, map);
            return new Long(map.get("id").toString());

        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        }
    }

    public List<Long> batchInsert(List<T> list) {
        Long startTime = System.currentTimeMillis();
        List<Long> idList = new ArrayList<Long>();
        try {
            for (T paraObject : list) {
                Map<String, Object> map = getInsertMap(paraObject);
                SqlSessionHolder.getSession(ExecutorType.BATCH).insert(getStatementNamespace() + ST_INSERT, map);
                idList.add(new Long(map.get("id").toString()));
            }
            SqlSessionHolder.getSession().flushStatements();
            return idList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("Record batch insert took " + (System.currentTimeMillis() - startTime));
        }
    }

    public int deleteByIds(List<Long> ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        String table = JPAHelper.getTableName(type);
        map.put(TABLE, table);
        map.put("ids", ids);
        return SqlSessionHolder.getSession().delete(this.getStatementNamespace() + ST_DELETE_IDS, map);
    }

    public int delete(Long id) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            String table = JPAHelper.getTableName(type);
            map.put(ID, id);
            map.put(TABLE, table);

            return SqlSessionHolder.getSession().delete(getStatementNamespace() + ST_DELETE, map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        }
    }

    public T getModelByPara(Map<String, Object> map) {
        List<T> ret = getModelListByPara(map);
        if (ret.size() > 0) {
            return ret.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<T> getModelListByPara(Map<String, Object> map) {
        try {

            String table = JPAHelper.getTableName(type);
            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put(TABLE, table);
            StringBuilder sb = new StringBuilder();
            for (String key : map.keySet()) {
                if (sb.length() > 0) {
                    sb.append(" and ");
                }
                sb.append(" ");
                sb.append(key);
                sb.append("=#{");
                sb.append(key);
                sb.append("}");
                paraMap.put(key, map.get(key));
            }
            paraMap.put("Clause", sb.toString());
            List<T> ret = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(
                    getStatementNamespace() + ST_SEARCHLIST_BY_PARA, paraMap);
            return ret;

        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        }
    }

    protected int getPaginatedListCount(BasePageSO bpo) {
        Long startTime = System.currentTimeMillis();
        try {
            List<?> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT_COUNT,
                    bpo);
            return retList.size() > 0 ? (Integer) retList.get(0) : 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("Total record count loading took " + (System.currentTimeMillis() - startTime));
        }

    }

    @SuppressWarnings( { "unchecked" })
    protected <E> List<E> getPaginatedList(BasePageSO bpo) {
        Long startTime = System.currentTimeMillis();
        try {
            RowBounds rowBounds = new RowBounds((bpo.getPageNumber() - 1) * bpo.getObjectsPerPage(), bpo.getObjectsPerPage());
            List<E> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(
                    getStatementNamespace() + ST_SELECT_PAGELIST, bpo, rowBounds);

            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("One page record loading took " + (System.currentTimeMillis() - startTime));
        }
    }

    @SuppressWarnings( { "unchecked" })
    public <E> List<E> getQueryList(BasePageSO bpo) {
        Long startTime = System.currentTimeMillis();
        try {
            List<E> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT, bpo);
            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("Record loading took " + (System.currentTimeMillis() - startTime));
        }
    }

    @SuppressWarnings( { "unchecked" })
    public <E> List<E> getQueryList(Map inputParameter) {
        Long startTime = System.currentTimeMillis();
        try {
            List<E> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT_LIST,
                    inputParameter);
            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("Record loading took " + (System.currentTimeMillis() - startTime));
        }
    }

    @SuppressWarnings( { "unchecked" })
    public <E> List<E> getListByIds(List<Long> ids) {
        Long startTime = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<String, Object>();
        String table = JPAHelper.getTableName(type);
        map.put(TABLE, table);
        map.put("ids", ids);
        try {
            List<E> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT_IDS,
                    map);
            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("Record loading took " + (System.currentTimeMillis() - startTime));
        }
    }

    public List<T> getListByFKId(Long fkId) {
        @SuppressWarnings("unchecked")
        List<T> list = (List<T>) SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(
                getStatementNamespace() + ST_SELECT_BY_FK, fkId);
        return list;
    }

    private Map<String, Object> getInsertMap(T paraObject) {
        Map<String, Object> map = new HashMap<String, Object>();
        /**
         * 填入表名，sequence
         */
        String seq = JPAHelper.getSequenceName(type);
        String table = JPAHelper.getTableName(type);
        map.put(SEQUENCE, seq);
        map.put(TABLE, table);
        /**
         * 填入时间戳，创建人
         */
        if (BaseModel.class.isAssignableFrom(type)) {
            PropertyHelper.setValue(paraObject, "creatorId", ClientContextHolder.getContext().getAccountId());
            PropertyHelper.setValue(paraObject, "createdTime", Calendar.getInstance().getTime());
            PropertyHelper.setValue(paraObject, "lockVersion", 0);
            // PropertyHelper.setValue(paraObject, "status",
            // CommonStatus.ACTIVE);
        }

        /**
         * 组装insertField,insertValues
         */
        List<ModelColumn> colList = JPAHelper.getColumnsByObj(paraObject);
        StringBuilder fieldSb = new StringBuilder();
        StringBuilder valuesSb = new StringBuilder();
        for (ModelColumn col : colList) {
            if (col.getValue() != null || col.getField().equalsIgnoreCase("id")) {
                map.put(col.getField(), col.getValue());
                if (fieldSb.length() > 0) {
                    fieldSb.append(",");
                }
                fieldSb.append(col.getName());

                if (valuesSb.length() > 0) {
                    valuesSb.append(",");
                }
                valuesSb.append("#{" + col.getField() + "}");
            }
        }
        map.put("insertField", fieldSb);
        map.put("insertValues", valuesSb);
        return map;
    }

    private Map<String, Object> getUpdateMap(T paraObject) {
        Map<String, Object> map = new HashMap<String, Object>();
        /**
         * 填入表名
         */
        String table = JPAHelper.getTableName(type);
        map.put(TABLE, table);

        /**
         * 填入时间戳，更新人
         */
        if (BaseModel.class.isAssignableFrom(type)) {
            ((BaseModel) paraObject).setUpdatedTime(Calendar.getInstance().getTime());
            // 用户登录时account为null
            if (ClientContextHolder.getContext().getAccountId() != null) {
                ((BaseModel) paraObject).setUpdatorId(ClientContextHolder.getContext().getAccountId());
            }
        }

        /**
         * 组装updateSql
         */
        List<ModelColumn> colList = JPAHelper.getColumnsByObj(paraObject);
        StringBuilder sb = new StringBuilder();
        String lockVersion = JPAHelper.getVersionName(type);

        for (ModelColumn col : colList) {
            if (col.getValue() != null) {
                map.put(col.getField(), col.getValue());
                if (ID.equalsIgnoreCase(col.getField())) {
                    continue;
                }
                if (lockVersion != null && lockVersion.equalsIgnoreCase(col.getField())) {
                    continue;
                }
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(" " + col.getName() + "=#{" + col.getField() + "}");

            }
        }
        map.put("updateSql", sb.toString());

        return map;
    }

    protected String getStatementNamespace() {
        Class<?> clazz = this.getClass().getInterfaces()[0];
        return clazz.getName();
    }

}
