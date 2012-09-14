package com.oasis.tmsv5.facade.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.so.security.AccountSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.security.AccountVO;
import com.oasis.tmsv5.common.vo.security.AuthenticationVO;
import com.oasis.tmsv5.common.vo.security.CheckedOrgVO;
import com.oasis.tmsv5.common.vo.security.CheckedRoleVO;
import com.oasis.tmsv5.service.account.AccountComponent;

import flex.messaging.FlexContext;

@RemotingDestination
@Service
public class AccountServiceFacade {

    @Autowired
    private AccountComponent accountService;
    
    public AccountVO createAccount(ClientContext clientContext, AccountVO accountVO) {
        return accountService.createAccount( accountVO);
    }

    public void deleteAccount(ClientContext clientContext, Long accId) {
        accountService.deleteAccount( accId);
    }

    public boolean exists(ClientContext clientContext, String userName, String domainCode) {
        return accountService.exists( userName, domainCode);
    }

	public ClientContext login(AuthenticationVO vo) {
		String ip = getRemoteIp();
		vo.setIp(ip);
		ClientContext context = accountService.login(vo);
		context.setIp(ip);
		return context;
	}
	
	private String getRemoteIp(){
		HttpServletRequest request = FlexContext.getHttpRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

    public boolean userLogout() {
        return accountService.logOut();
    }
    
    public PageList<AccountVO> getPageList(ClientContext clientContext,AccountSO so)  {
        return accountService.getPageList(so);
    }
    
    public void remove(ClientContext clientContext,List<?> ids) {
        
        List<Long> ids_t = new ArrayList<Long>();
        for(Object id:ids) {
            if (id!= null){
                Long id_l = (Long)id;
                ids_t.add(id_l);
            }
            continue;
        }
        accountService.remove(ids_t);
    }
    
    public CheckedRoleVO getCheckedRole(ClientContext clientContext,Long id){
        return accountService.getCheckedRole(id);
    }
    
    public CheckedOrgVO getCheckedOrg(ClientContext clientContext,Long id){
        return accountService.getCheckedOrg(id);
    }
    
    public AccountVO update(ClientContext clientContext,AccountVO vo){
        return  accountService.update(vo);
    }
    
    public void changePassword(ClientContext clientContext,AccountVO vo) {
        accountService.changePassword( vo);
    }
    
    public Map<String, List<String>> getPremissionByAccount(ClientContext clientContext, Long acId) {
        return accountService.getPremissionByAccount( acId);
    }
    
    public void resetPass(ClientContext clientContext,List<Long> ids) {
    	accountService.resetPassword( ids);
    }
    
}