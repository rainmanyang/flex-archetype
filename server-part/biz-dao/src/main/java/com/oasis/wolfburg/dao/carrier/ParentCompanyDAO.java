package com.oasis.wolfburg.dao.carrier;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.carrier.ParentCompanySO;
import com.oasis.wolfburg.model.carrier.ParentCompany;

public interface ParentCompanyDAO extends DAO<ParentCompany> {
	
    List<ParentCompany> getPaginatedList(ParentCompanySO parentCompanySO);
    
    int getPaginatedListCount(ParentCompanySO parentCompanySO);
    
    List<ParentCompany> checkDuplication(ParentCompanySO parentCompanySO);

}
