package com.oasis.wolfburg.dao.carrier;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.carrier.ParentCompanySO;
import com.oasis.wolfburg.model.carrier.ParentCompany;
@Repository
public class ParentCompanyDAOImpl extends BaseDAO<ParentCompany> implements ParentCompanyDAO {

	private static final String CHECK_DUPLICATION = ".checkDuplication";

	@SuppressWarnings("unchecked")
	@Override
	public List<ParentCompany> checkDuplication(ParentCompanySO parentCompanySO) {
		return getSession().selectList(getStatementNamespace() + CHECK_DUPLICATION, parentCompanySO);
	}

	@Override
	public List<ParentCompany> getPaginatedList(ParentCompanySO parentCompanySO) {
		return super.getPaginatedList(parentCompanySO);
	}

	@Override
	public int getPaginatedListCount(ParentCompanySO parentCompanySO) {
		return super.getPaginatedListCount(parentCompanySO);
	}

}
