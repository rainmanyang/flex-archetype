package com.oasis.wolfburg.dao.bank;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.bank.BankSO;
import com.oasis.wolfburg.model.bank.Bank;

public interface BankDAO extends DAO<Bank> {
	
    List<Bank> getPaginatedList(BankSO bankSO);
    
    int getPaginatedListCount(BankSO bankSO);
    
    List<Bank> checkDuplication(BankSO bankSO);

}
