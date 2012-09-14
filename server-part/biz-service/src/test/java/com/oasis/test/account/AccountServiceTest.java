package com.oasis.test.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.enums.type.AssociateTable;
import com.oasis.tmsv5.common.so.security.AccountSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.orgnization.OrganizationVO;
import com.oasis.tmsv5.common.vo.security.AccountVO;
import com.oasis.tmsv5.common.vo.security.AuthenticationVO;
import com.oasis.tmsv5.common.vo.security.CheckedOrgVO;
import com.oasis.tmsv5.common.vo.security.CheckedRoleVO;
import com.oasis.tmsv5.common.vo.security.RoleVO;
import com.oasis.tmsv5.dao.account.AccountDAO;
import com.oasis.tmsv5.dao.asso.AssociateDAO;
import com.oasis.tmsv5.model.security.Account;
import com.oasis.tmsv5.security.SecurityContext;
import com.oasis.tmsv5.service.account.AccountComponent;
import com.oasis.tmsv5.util.helper.DozerHelper;

public class AccountServiceTest extends SpringBaseTest {
	@Autowired
	private AccountComponent accountComponent;
	
	@Autowired
	private AssociateDAO associateDAO;
	
	@Autowired
    private AccountDAO accountDAO;
	
	@Autowired
	protected DozerHelper dozer;
	
	@Test
	public void find(){
		Long id = 195L;
		Account accout = accountDAO.find(id);
		System.out.println(accout.getLockVersion());
	}
	
	@Test
	public void getCheckedRoleAndOrg(){
		Long id = 134L;
		CheckedOrgVO co = accountComponent.getCheckedOrg(id);
		System.out.println(co.getCheckedOrg());
		CheckedRoleVO cr = accountComponent.getCheckedRole(id);
		System.out.println(cr.getCheckedRoles());
	}
	
	@Test
	public void createAccount(){
		AccountVO vo = this.getAccountVO();
		vo.setId(null);
		vo.setLoginName(vo.getLoginName()+"杭州");
		vo.setPasswordExpiredDate(new Date());
		vo.setExpiredDate(new Date());
		accountComponent.createAccount(vo);
	}
	
	@Test
	public void getPageList(){
		AccountSO so = this.getSo();
		PageList<AccountVO> page = accountComponent.getPageList(so);
		System.out.println(page.getFullListSize());
	}
	
	@Test
	public void update(){
		AccountVO vo = this.getAccountVO();
		accountComponent.update(vo);
		
		Account ac = accountDAO.find(vo.getId());
		System.out.println(ac);
		
		List<?> list = associateDAO.selectListByAssoc(AssociateTable.ACCOUNT_ROLE, vo.getId());
		System.out.println(list.size());
	}
	
	@Test
	public void remove(){
		List<Long> list = new ArrayList<Long>();
		AccountSO so = new AccountSO();
		PageList<AccountVO> page = accountComponent.getPageList(so);
		for(int k=0;k<3&&k<page.getList().size();k++){
			list.add(page.getList().get(k).getId());
		}
		accountComponent.remove(list);
	}
	
	@Test
	public void testLogin(){
	    AuthenticationVO vo = new AuthenticationVO();
	    vo.setUsername("bl01094");
	    vo.setPassword("12345678");
	    vo.setDomian("60000");
	    accountComponent.login(vo);
	}
	
	@Test
	public void deleteAccount(){
		AccountVO vo = this.getAccountVO();
		accountComponent.deleteAccount(vo.getId());
	}
	
	private AccountSO getSo(){
		AccountSO so = new AccountSO();
		so.setLoginName("bl0002");
		so.setDisabled(false);
		return so;
	}
	
	private AccountVO getAccountVO(){
		AccountSO so = new AccountSO();
		PageList<AccountVO> page = accountComponent.getPageList(so);
		Long id = page.getList().get(0).getId();
		Account account = accountDAO.find(id);
		AccountVO vo = dozer.convert(account, AccountVO.class);
		vo.setRoles(new HashSet<RoleVO>());
		vo.setOrgs(new HashSet<OrganizationVO>());
		return vo;
		
		/*AccountVO vo = new AccountVO();
		vo.setId(new Long("115"));
		vo.setLockVersion(0);
		vo.setLoginName("BL014015");
		vo.setDomainId(60000L);
		vo.setPassword("test");
		
		Set<RoleVO> roles = new HashSet<RoleVO>();
		for(int i=4;i<7;i++){
			RoleVO rolevo = new RoleVO();
			rolevo.setId(new Long(i));
			roles.add(rolevo);
		}
		vo.setRoles(roles);
		
		Set<OrganizationVO> orgs = new HashSet<OrganizationVO>();
		for(int i=1;i<4;i++){
			OrganizationVO org = new OrganizationVO();
			org.setId(new Long(i));
			orgs.add(org);
		}
		vo.setOrgs(orgs);
		return vo;*/
	}
	
}
