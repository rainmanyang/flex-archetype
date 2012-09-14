package com.oasis.tmsv5.dao.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.oasis.tmsv5.common.so.security.AccountSO;
import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.model.security.Account;
import com.oasis.tmsv5.util.exception.QueryException;
import com.oasis.tmsv5.util.helper.DomainHelper;

@Component
public class AccountDAOImpl extends BaseDAO<Account> implements AccountDAO {

    private static final String GET_ACCOUNT_BY_LOGINNAME_AND_DOMIANCODE = ".getAccountByLoginNameAndDomainCode";
    
    private static final String CHECK_DUPLICATION = ".checkDuplication";
    /**
     * 根据用户名和域查找帐号信息 
     * @param loginName
     * @param domainId
     * @return
     */
    public Account getAccountByUserName(String loginName){
        try {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("loginname", loginName.toUpperCase());
            Account ret = (Account) getSession().selectOne(getStatementNamespace()+GET_ACCOUNT_BY_LOGINNAME_AND_DOMIANCODE, map);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        }
    }
    
    public List<Account> getPaginatedList(AccountSO so){
		return super.getPaginatedList(so);
	}
	
	public int getPaginatedListCount(AccountSO so){
		return super.getPaginatedListCount(so);
	}

    @SuppressWarnings("unchecked")
    public List<Account> checkDuplication(AccountSO so) {
        return getSession().selectList(getStatementNamespace()+CHECK_DUPLICATION, so);
    }
	
	
}
