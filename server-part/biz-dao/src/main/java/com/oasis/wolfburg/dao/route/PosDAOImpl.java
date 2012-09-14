package com.oasis.wolfburg.dao.route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.route.PosSO;
import com.oasis.wolfburg.common.vo.route.PosViewVO;
import com.oasis.wolfburg.model.route.POS;

@Repository
public class PosDAOImpl extends BaseDAO<POS> implements PosDAO {

    private static final String CHECK_DUPLICATION = ".checkDuplication";

    private static final String GET_VIEW = ".getView";

    private static final String GET_POS_BY_ACCOUNT = ".getPOSByAccount";

    @Override
    public POS checkDuplication(String name, String code, Long id) {
        Map<String,Object> searchMap = new HashMap<String, Object>();
        searchMap.put("name", name);
        searchMap.put("code", code);
        searchMap.put("id", id);
        return (POS)getSession().selectOne(getStatementNamespace() + CHECK_DUPLICATION, searchMap);
    }

    @Override
    public List<POS> getPaginatedList(PosSO so) {
        return super.getPaginatedList(so);
    }

    @Override
    public int getPaginatedListCount(PosSO so) {
        return super.getPaginatedListCount(so);
    }

    @Override
    public PosViewVO findView(Long id) {
        return (PosViewVO) getSession().selectOne(getStatementNamespace() + GET_VIEW, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<POS> getPOSByAccount(Long accountId) {
        return getSession().selectList(getStatementNamespace() + GET_POS_BY_ACCOUNT, accountId);
    }

}
