package com.oasis.tmsv5.dao.role;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.common.so.security.RolePremissionSO;
import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.model.security.Role;

@Repository
public class RoleDAOImpl extends BaseDAO<Role> implements RoleDAO {
	
	private static final String GET_ALL_ROLE=".getAllRole";
	
	private static final String GET_ASOC_ROLE_BY_ACCOUNT = ".getAsocRoleByAccount";
	
	private static final String CHECK_DUPLICATION = ".checkDuplication";
    
    public List<Role> getPaginatedList(RolePremissionSO so){
		return super.getPaginatedList(so);
	}
	
	public int getPaginatedListCount(RolePremissionSO so){
		return super.getPaginatedListCount(so);
	}

    @SuppressWarnings("unchecked")
    public List<Role> getAllRole() {
       return getSession().selectList(getStatementNamespace()+GET_ALL_ROLE);
    }
	
    @SuppressWarnings("unchecked")
    public List<Role> getAscoRoleByAccount(Long id) {
        return getSession().selectList(getStatementNamespace()+GET_ASOC_ROLE_BY_ACCOUNT,id);
    }

    @SuppressWarnings("unchecked")
    public List<Role> checkDuplication(RolePremissionSO so) {
        return getSession().selectList(getStatementNamespace()+CHECK_DUPLICATION,so);
    }
    
    
}
