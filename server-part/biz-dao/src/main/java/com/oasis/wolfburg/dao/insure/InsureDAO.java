package com.oasis.wolfburg.dao.insure;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.insure.InsureSO;
import com.oasis.wolfburg.model.insure.Insure;

public interface InsureDAO extends DAO<Insure> {
	
    List<Insure> getPaginatedList(InsureSO insureSO);
    
    int getPaginatedListCount(InsureSO insureSO);
    
    List<Insure> checkDuplication(InsureSO insureSO);

    void deleteByfkId(Long fkId);
}
