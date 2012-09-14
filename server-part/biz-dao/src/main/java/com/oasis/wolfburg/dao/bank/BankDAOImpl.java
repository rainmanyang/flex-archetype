package com.oasis.wolfburg.dao.bank;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.bank.BankSO;
import com.oasis.wolfburg.model.bank.Bank;
@Repository
public class BankDAOImpl extends BaseDAO<Bank> implements BankDAO {

	private static final String CHECK_DUPLICATION = ".checkDuplication";

	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> checkDuplication(BankSO bankSO) {
		return getSession().selectList(getStatementNamespace() + CHECK_DUPLICATION, bankSO);
	}

	@Override
	public List<Bank> getPaginatedList(BankSO bankSO) {
		return super.getPaginatedList(bankSO);
	}

	@Override
	public int getPaginatedListCount(BankSO bankSO) {
		return super.getPaginatedListCount(bankSO);
	}

}
