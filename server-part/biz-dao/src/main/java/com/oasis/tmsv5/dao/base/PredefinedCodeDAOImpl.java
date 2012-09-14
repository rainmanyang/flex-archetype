package com.oasis.tmsv5.dao.base;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.common.enums.type.PredefinedCodeType;
import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.model.base.PredefinedCode;
import com.oasis.tmsv5.util.helper.DomainHelper;
import com.oasis.wolfburg.common.so.predefinedCode.PredefinedCodeSO;

@Repository
public class PredefinedCodeDAOImpl extends BaseDAO<PredefinedCode> implements PredefinedCodeDAO {

    private static final String FIND_PARA = ".findByPara";

    private static final String GETLIST_PARA = ".getListByPara";

    private static Map<String, PredefinedCode> codeKeyCacheMap = new HashMap<String, PredefinedCode>();

    private static Map<PredefinedCodeType, List<PredefinedCode>> typeKeyCacheMap = new HashMap<PredefinedCodeType, List<PredefinedCode>>();

    private static final int REFRESH_TIME = 60;

    private static Date loadTime = Calendar.getInstance().getTime();

    private static final Log logger = LogFactory.getLog(PredefinedCodeDAOImpl.class);

    @Override
    public PredefinedCode getCachePredefinedCodeByCode(String code) {
        if (codeKeyCacheMap.isEmpty() || isLoadTime() || codeKeyCacheMap.get(code) == null) {
            putAllPredefinedCodeToMap();
        }

        return codeKeyCacheMap.get(code);
    }

    public List<PredefinedCode> getCachePredefinedCodesByType(PredefinedCodeType type) {
        if (typeKeyCacheMap.isEmpty() || isLoadTime() || typeKeyCacheMap.get(type) == null) {
            putAllPredefinedCodeToMap();
        }
        return typeKeyCacheMap.get(type);
    }
    
    public List<PredefinedCode> getPredefinedCodesByType(PredefinedCodeType type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type.name());
        map.put("DOMAIN_ID", DomainHelper.DEFAULT_DOMAIN_ID);
        List<PredefinedCode> list = super.getModelListByPara(map);
        return list;
    }

    private void putAllPredefinedCodeToMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DOMAIN_ID", 60000L);
        List<PredefinedCode> ret = super.getModelListByPara(map);
        for (PredefinedCode prd : ret) {
            /**
             * full codeKeyCacheMap
             */
            codeKeyCacheMap.put(prd.getCode(), prd);
            /**
             * full typeKeyCacheMap
             */
            List<PredefinedCode> typeCodeList = typeKeyCacheMap.get(prd.getType());
            if (typeCodeList == null) {
                typeCodeList = new ArrayList<PredefinedCode>();
            }
            typeCodeList.add(prd);
            typeKeyCacheMap.put(prd.getType(), typeCodeList);
        }
        loadTime = Calendar.getInstance().getTime();
        logger.info("PredefinedCode relaoded.");
    }

    public boolean hasPredefinedCodeByTypeAndValue(PredefinedCodeType type, String value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);
        map.put("value", value);

        @SuppressWarnings("unchecked")
        List<PredefinedCode> res = super.getSession().selectList(getStatementNamespace() + GETLIST_PARA, map);
        if (res.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    public List<PredefinedCode> queryPredefinedCodes(PredefinedCodeSO so) {
        return super.getSession().selectList(super.getStatementNamespace() + FIND_PARA, so);
    }

    private boolean isLoadTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, REFRESH_TIME * (-1));
        if (cal.getTime().after(loadTime)) {
            return true;
        }
        return false;
    }
    public static void main(String... s) {
        loadTime=Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, REFRESH_TIME * (-1));
        System.out.print(cal.getTime());
        if (cal.getTime().after(loadTime)) {
            System.out.print(true);
        }
    }
}
