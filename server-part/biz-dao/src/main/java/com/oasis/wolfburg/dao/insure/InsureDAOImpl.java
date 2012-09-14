package com.oasis.wolfburg.dao.insure;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.insure.InsureSO;
import com.oasis.wolfburg.model.insure.Insure;
@Repository
public class InsureDAOImpl extends BaseDAO<Insure> implements InsureDAO {

	private static final String CHECK_DUPLICATION = ".checkDuplication";

	private static final String DELETE_FKID = ".deleteByfkId";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Insure> checkDuplication(InsureSO insureSO) {
		return getSession().selectList(getStatementNamespace() + CHECK_DUPLICATION, insureSO);
	}

	@Override
	public List<Insure> getPaginatedList(InsureSO insureSO) {
		return super.getPaginatedList(insureSO);
	}

	@Override
	public int getPaginatedListCount(InsureSO insureSO) {
		return super.getPaginatedListCount(insureSO);
	}

	public void deleteByfkId(Long fkId){
		super.getSession().delete(getStatementNamespace()+DELETE_FKID, fkId);
	}
}
