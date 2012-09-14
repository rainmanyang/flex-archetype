package com.oasis.tmsv5.dao.account;

import java.util.List;

import com.oasis.tmsv5.common.so.security.AccountSO;
import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.model.security.Account;

public interface AccountDAO extends DAO<Account> {
    
    Account getAccountByUserName(String loginName);

    List<Account> getPaginatedList(AccountSO so);
    
    int getPaginatedListCount(AccountSO so);
    
    List<Account> checkDuplication(AccountSO so);
}
