package com.oasis.tmsv5.common.service.account;

import java.util.List;
import java.util.Map;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.so.security.AccountSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.security.AccountVO;
import com.oasis.tmsv5.common.vo.security.AuthenticationVO;
import com.oasis.tmsv5.common.vo.security.CheckedOrgVO;
import com.oasis.tmsv5.common.vo.security.CheckedRoleVO;

public interface AccountService {

    ClientContext login(AuthenticationVO vo);

    boolean exists(ClientContext clientContext,String userName, String domainCode);

    AccountVO createAccount(ClientContext clientContext,AccountVO accountVO);

    void deleteAccount(ClientContext clientContext,Long accId);
    
    boolean logout();

    PageList<AccountVO> getPageList(ClientContext clientContext,AccountSO so);
    
    AccountVO update(ClientContext clientContext,AccountVO acvo);
    
    void remove(ClientContext clientContext,List<Long> ids);
    
    CheckedRoleVO getCheckedRole(ClientContext clientContext,Long id);
    
    CheckedOrgVO getCheckedOrg(ClientContext clientContext,Long id);
    
    void changePassword(ClientContext clientContext,AccountVO vo);
    
    Map<String, List<String>> getPremissionByAccount(ClientContext clientContext,Long acId);
}
