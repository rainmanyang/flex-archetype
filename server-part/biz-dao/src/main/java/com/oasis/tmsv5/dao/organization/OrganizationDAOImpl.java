package com.oasis.tmsv5.dao.organization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.common.so.security.OrganizationSO;
import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.model.organization.Organization;
import com.oasis.tmsv5.util.helper.DomainHelper;

@Repository
public class OrganizationDAOImpl extends BaseDAO<Organization> implements OrganizationDAO {

    private static final String GET_ROOT_ORG = ".getRootOrg";

    private static final String GET_ALL_ORG = ".getAllOrg";

    private static final String GET_ASOC_ORG_BY_ACCOUNT = ".getAsocOrgByAccount";

    private static final String CHECK_DUPLICATION = ".checkDuplication";
   

    public List<Organization> getPaginatedList(OrganizationSO so) {
        return super.getPaginatedList(so);
    }

    public int getPaginatedListCount(OrganizationSO so) {
        return super.getPaginatedListCount(so);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getAllOrganizations(String condition) {
        Map<Object, Object> paramMap = new HashMap<Object, Object>();
        paramMap.put("condition", condition);
        return getSession().selectList(getStatementNamespace() + GET_ALL_ORG, paramMap);
    }

    public Organization getRootOrganization() {
        Map<Object, Object> paramMap = new HashMap<Object, Object>();
        return (Organization) getSession().selectOne(getStatementNamespace() + GET_ROOT_ORG, paramMap);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getAsocOrgByAccount(Long id) {
        return getSession().selectList(getStatementNamespace() + GET_ASOC_ORG_BY_ACCOUNT, id);
    }

    public Organization checkDuplication(Map<String,Object> so) {
        return (Organization)getSession().selectOne(getStatementNamespace() + CHECK_DUPLICATION, so);
    }

}
