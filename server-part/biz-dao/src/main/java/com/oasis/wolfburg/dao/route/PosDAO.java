package com.oasis.wolfburg.dao.route;

import java.util.List;
import java.util.Map;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.route.PosSO;
import com.oasis.wolfburg.common.vo.route.PosViewVO;
import com.oasis.wolfburg.model.route.POS;

public interface PosDAO extends DAO<POS> {
    List<POS> getPaginatedList(PosSO so);
    
    int getPaginatedListCount(PosSO so);
    
    POS checkDuplication(String name,String code,Long id);
    
    PosViewVO findView(Long id);

    List<POS> getPOSByAccount(Long accountId);
}
