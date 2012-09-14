package com.oasis.tmsv5.service.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.enums.type.AssociateTable;
import com.oasis.tmsv5.common.error.ErrorCode;
import com.oasis.tmsv5.common.so.security.AccountSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.common.vo.orgnization.OrganizationVO;
import com.oasis.tmsv5.common.vo.security.AccountVO;
import com.oasis.tmsv5.common.vo.security.AuthenticationVO;
import com.oasis.tmsv5.common.vo.security.CheckedOrgVO;
import com.oasis.tmsv5.common.vo.security.CheckedRoleVO;
import com.oasis.tmsv5.common.vo.security.RoleVO;
import com.oasis.tmsv5.dao.CacheWrapper;
import com.oasis.tmsv5.dao.account.AccountDAO;
import com.oasis.tmsv5.dao.asso.AssociateDAO;
import com.oasis.tmsv5.dao.menuItem.MenuItemDAO;
import com.oasis.tmsv5.dao.organization.OrganizationDAO;
import com.oasis.tmsv5.dao.role.RoleDAO;
import com.oasis.tmsv5.model.menuItem.MenuItem;
import com.oasis.tmsv5.model.security.Account;
import com.oasis.tmsv5.model.security.Role;
import com.oasis.tmsv5.security.ClientContextHolder;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.tmsv5.service.organization.OrganizationComponent;
import com.oasis.tmsv5.util.exception.LoginException;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.tmsv5.util.tools.EncodeUtil;


@Service
public class AccountComponent extends BaseComponent {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private AssociateDAO associateDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private OrganizationDAO organizationDAO;

    @Autowired
    private MenuItemDAO menuItemDAO;

    @Autowired
    private OrganizationComponent orgComp;
    
//    @Autowired
//    private OperationLogHelper opLogHelper;
    
    @Autowired
    @Qualifier("localCacheWrapperImpl")
    private CacheWrapper cacheImpl;
    
    private static final String INIT_PASS = "111111";
    
    public AccountVO createAccount(AccountVO accVO) {

        validatIfCanCreate(accVO);
        buildAccount(accVO);
        Long id = accountDAO.insert(getDozer().convert(accVO, Account.class));

        List<Long> orgList = new ArrayList<Long>();
        for (OrganizationVO org : accVO.getOrgs()) {
            orgList.add(org.getId());
        }
        associateDAO.batchInsert(AssociateTable.ACCOUNT_ORGANIZATION, id, orgList);

        List<Long> roleList = new ArrayList<Long>();
        for (RoleVO role : accVO.getRoles()) {
            roleList.add(role.getId());
        }
        associateDAO.batchInsert(AssociateTable.ACCOUNT_ROLE, id, roleList);

        Account acc = accountDAO.find(id);
        return getDozer().convert(acc, AccountVO.class);
    }

    private void validatIfCanCreate(AccountVO accVO) {
        Map<String, String> errors = new HashMap<String, String>();
        AccountSO so = new AccountSO();
        so.setLoginName(accVO.getLoginName().toUpperCase());
        List<Account> accoutList = accountDAO.checkDuplication(so);
        if (accoutList.size() > 0) {
            errors.put("loginName", ErrorDispHelper.getInstance().getValue("ACCOUNT_ERROR"));
            throw new ValidationException(errors);
        }
    }

    /**
     * ����md����
     * 
     * @param accVO
     */
    public void buildAccount(AccountVO accVO) {
        accVO.setPassword(EncodeUtil.MD5Encode(accVO.getPassword()));
        accVO.setLoginName(accVO.getLoginName().toUpperCase());
    }

    public void deleteAccount(Long accId) {
        Account po = accountDAO.find(accId);
        po.setDisabled(true);
        accountDAO.update(po);

    }

    /**
     * reviewer:�˷���ֱ�ӷ���ֵ,�Ƿ�������?
     */
    public boolean exists(String userName, String domainCode) {
        return false;
    }

    public ClientContext login(AuthenticationVO vo) {
        Account account = accountDAO.getAccountByUserName(vo.getUsername().toUpperCase());
        ClientContext clientContext = new ClientContext();
        if (authentication(vo, account)) {
            /**
             * generate token after login.
             */
            String loginToken = buildToken(account);
            account.setLoginToken(loginToken);
            accountDAO.update(account);
            clientContext.setAccountId(account.getId());
            clientContext.setLoginName(account.getLoginName());
            clientContext.setLoginToken(account.getLoginToken());
            clientContext.setNameCn(account.getNameCn());
            
            clientContext.setNetAuthority(getNetAuthority(account));
            ClientContextHolder.setContext(clientContext);
//            opLogHelper.log(EventPhase.LOGIN, vo);
            return clientContext;
        }
        return null;
    }
    
    
    public ClientContext clientLogin(AuthenticationVO vo) {
        Account account = accountDAO.getAccountByUserName(vo.getUsername().toUpperCase());
        ClientContext clientContext = new ClientContext();
        if (authentication(vo, account)) {
            /**
             * generate token after login.
             */
            String loginToken = buildToken(account);
            account.setLoginToken(loginToken);
            accountDAO.update(account);
            clientContext.setAccountId(account.getId());
            clientContext.setLoginName(account.getLoginName());
            clientContext.setLoginToken(account.getLoginToken());
            clientContext.setNameCn(account.getNameCn());
            //TODO useless
            clientContext.setNetAuthority(getNetAuthority(account));
//            opLogHelper.log(EventPhase.CLIENT_LOGIN, vo);
            return clientContext;
        }
        return null;
    }
    /**
     * ����û��������ڵĽ�ɫ������Ӧ���������Ȩ��
     */
    private String getNetAuthority(Account account){
        StringBuffer netAuthority = new StringBuffer();
        
        String roleNetAuthority = getRoleNetAuthority(account);
        String accountNetAuthority = account.getNetAuthority();
        
        if(accountNetAuthority.substring(0,1).equals("1") && roleNetAuthority.substring(0,1).equals("1")){
            netAuthority.append("1");
        } else if(accountNetAuthority.substring(0,1).equals("0") || roleNetAuthority.substring(0,1).equals("0")){
            netAuthority.append("0");
        }
        
        if(accountNetAuthority.substring(1,2).equals("1") && roleNetAuthority.substring(1,2).equals("1")){
            netAuthority.append("1");
        } else if(accountNetAuthority.substring(1,2).equals("0") || roleNetAuthority.substring(1,2).equals("0")){
            netAuthority.append("0");
        }
        
        if(accountNetAuthority.substring(2,3).equals("1") && roleNetAuthority.substring(2,3).equals("1")){
            netAuthority.append("1");
        } else if(accountNetAuthority.substring(2,3).equals("0") || roleNetAuthority.substring(2,3).equals("0")){
            netAuthority.append("0");
        }
        
        return netAuthority.toString();
    }
    
    /**
     * ����û���ɫ������Ӧ���������Ȩ��
     * @return
     */
    private String getRoleNetAuthority(Account account){
        List<Role> roleList = roleDAO.getAscoRoleByAccount(account.getId());
        StringBuffer roleNetAuthority = new StringBuffer();
        
        StringBuffer roleInNet = new StringBuffer();
        StringBuffer roleVPNNet = new StringBuffer();
        StringBuffer roleOutNet = new StringBuffer();
       
        if(roleList != null && roleList.size() > 0){
            for (Role role : roleList){
                roleInNet.append(role.getNetAuthority().substring(0, 1));
                roleVPNNet.append(role.getNetAuthority().substring(1, 2));
                roleOutNet.append(role.getNetAuthority().substring(2, 3));
            }
        }
        if(roleInNet.toString().contains("1")){
            roleNetAuthority.append("1");
        } else {
            roleNetAuthority.append("0");
        }
        if(roleVPNNet.toString().contains("1")){
            roleNetAuthority.append("1");
        } else {
            roleNetAuthority.append("0");
        }
        if(roleOutNet.toString().contains("1")){
            roleNetAuthority.append("1");
        } else {
            roleNetAuthority.append("0");
        }
        return roleNetAuthority.toString();
    }
    
    public Map<String, List<String>> getPremissionByAccount(Long acId) {
        Map<String, List<String>> pre = null;
        List<MenuItem> preMenus = menuItemDAO.getAllPreMenuItemByAccount(acId);
        if (preMenus.size() > 0) {
            pre = new HashMap<String, List<String>>();
            for (MenuItem elm : preMenus) {
                String preStr = elm.getAction();
                if (preStr != null) {
                    String[] preStr_arr = preStr.trim().split("\\|");
                    String moduleName = preStr_arr[0];
                    String preName = preStr_arr[1];
                    if (pre.get(moduleName) == null) {
                        List<String> preList = new ArrayList<String>();
                        preList.add(preName);
                        pre.put(moduleName, preList);
                    } else {
                        pre.get(moduleName).add(preName);
                    }
                }
            }
        }
        return pre;
    }

    private String buildToken(Account account) {
        return account.getId().toString();
    }

//    public SecurityContext getSecurityContextByLoginToken(String loginToken) {
//        if(loginToken == null) {
//        	 throw new LoginException(ErrorCode.NO_TOKEN);
//        }
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("login_Token", loginToken);
//        Account model = accountDAO.getModelByPara(map);
//        if (model == null) {
//            return null;
//        }
//        SecurityContext securityContext = ClientContextHolder.createEmptyContext();
//        securityContext.setAccount(model);
//        return securityContext;
//
//    }

    public boolean logOut() {
    	AuthenticationVO vo = new AuthenticationVO();
    	vo.setIp(ClientContextHolder.getContext().getIp());
    	vo.setUsername(ClientContextHolder.getContext().getLoginName());
        ClientContextHolder.setContext(null);
        return true;
    }

    /**
     * ��֤��¼��Ϣ�Ƿ���ȷ
     * 
     * @param vo
     * @param account
     * @return
     */

    private boolean authentication(AuthenticationVO vo, Account account) {
        if (account == null) {
            throw new LoginException(ErrorCode.USER_NOT_EXIST);
        }
        String password = EncodeUtil.MD5Encode(vo.getPassword());
        if (!password.equals(account.getPassword())) {
//        	opLogHelper.log(EventPhase.ERROR_PASSWORD, vo);
            throw new LoginException(ErrorCode.BAD_CREDENTIALS);
        }
        return true;
    }

    public PageList<AccountVO> getPageList(AccountSO so) {
        if(so.getLoginName() != null){
        	so.setLoginName(so.getLoginName().toUpperCase());
        }
    	int count = accountDAO.getPaginatedListCount(so);
        List<Account> accountList = accountDAO.getPaginatedList(so);
        List<AccountVO> list = getDozer().convertList(accountList, AccountVO.class);
        PageList<AccountVO> pageList = new PageList<AccountVO>(so);
        pageList.setFullListSize(count);
        pageList.setList(list);
        return pageList;
    }

    public AccountVO update(AccountVO acvo) {
        validatIfCanUpdate(acvo);
        Long id = acvo.getId();
        List<Long> roleIds = new ArrayList<Long>();
        for (RoleVO rolevo : acvo.getRoles()) {
            roleIds.add(rolevo.getId());
        }
        associateDAO.deleteByAssoc(AssociateTable.ACCOUNT_ROLE, id);
        associateDAO.batchInsert(AssociateTable.ACCOUNT_ROLE, id, roleIds);

        List<Long> orgIds = new ArrayList<Long>();
        for (OrganizationVO org : acvo.getOrgs()) {
            orgIds.add(org.getId());
        }
        associateDAO.deleteByAssoc(AssociateTable.ACCOUNT_ORGANIZATION, id);
        associateDAO.batchInsert(AssociateTable.ACCOUNT_ORGANIZATION, id, orgIds);

        Account account = getDozer().convert(acvo, Account.class);
        account.setLoginName(account.getLoginName().toUpperCase());
        //��ղ˵�����
        cacheImpl.remove(TreeNode.class+acvo.getId().toString());
        return getDozer().convert(accountDAO.update(account), AccountVO.class);
    }

    private void validatIfCanUpdate(AccountVO accVO) {
        Map<String, String> errors = new HashMap<String, String>();
        AccountSO so = new AccountSO();
        so.setLoginName(accVO.getLoginName().toUpperCase());
        List<Account> accoutList = accountDAO.checkDuplication(so);
        if (accoutList.size() > 0) {
            Account vo = accoutList.get(0);
            if (!vo.getId().equals(accVO.getId())) {
                errors.put("loginName", ErrorDispHelper.getInstance().getValue("ACCOUNT_ERROR"));
                throw new ValidationException(errors);
            }
        }
    }

    /**
     * ����ɾ��
     * 
     * @param ids
     */
    public void remove(List<Long> ids) {
        if (ids.size() > 0) {
            for (Long id : ids) {
                deleteAccount(id);
            }
        }
    }

    /**
     * 
     * @param id
     * @return
     */
    public CheckedRoleVO getCheckedRole(Long id) {
        CheckedRoleVO retVo = new CheckedRoleVO();
        List<RoleVO> allRoles = getDozer().convertList(roleDAO.getAllRole(), RoleVO.class);
        retVo.setAllRoles(allRoles);
        if (id != 0) {
            List<RoleVO> checkedRoles = getDozer().convertList(roleDAO.getAscoRoleByAccount(id), RoleVO.class);
            retVo.setCheckedRoles(checkedRoles);
        }
        return retVo;
    }

    public CheckedOrgVO getCheckedOrg(Long id) {
        CheckedOrgVO retVo = new CheckedOrgVO();
        retVo.setOrgTree(orgComp.getOrgTree(""));
        if (id != 0) {
            List<OrganizationVO> checkedOrgs = getDozer()
                    .convertList(organizationDAO.getAsocOrgByAccount(id), OrganizationVO.class);
            retVo.setCheckedOrg(checkedOrgs);
        }
        return retVo;
    }

    public void changePassword(AccountVO vo) {
        Account ac = accountDAO.getAccountByUserName(ClientContextHolder.getContext().getLoginName());
        ac.setPassword(EncodeUtil.MD5Encode(vo.getPassword()));
        accountDAO.update(ac);
    }
    public List<AccountVO> getListByIds(List<Long> ids) {
    	List<Account> accountList = accountDAO.getListByIds(ids);
        List<AccountVO> list = getDozer().convertList(accountList, AccountVO.class);
        return list;
    }
    
    public void resetPassword(List<Long> ids) {
    	String intialPass = EncodeUtil.MD5Encode(INIT_PASS);
    	for(Long id:ids) {
    		Account ac = accountDAO.find(id);
    		ac.setPassword(intialPass);
    		accountDAO.update(ac);
    	}
    }
    
}
