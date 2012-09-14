package com.oasis.tmsv5.dao.organization;

import java.util.List;
import java.util.Map;

import com.oasis.tmsv5.common.so.security.OrganizationSO;
import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.model.organization.Organization;

public interface OrganizationDAO extends DAO<Organization> {
	List<Organization> getPaginatedList(OrganizationSO so);

	int getPaginatedListCount(OrganizationSO so);

	Organization getRootOrganization();

	List<Organization> getAllOrganizations(String condition);

	List<Organization> getAsocOrgByAccount(Long id);
	
	Organization checkDuplication(Map<String,Object> so);
}
