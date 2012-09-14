package com.oasis.tmsv5.dao.customer;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.common.so.customer.CustomerSO;
import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.model.customer.Customer;

@Repository
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {
	private static final String ST_BY_ORG = ".getCustomersByOrgId";

	public List<Customer> getPaginatedList(CustomerSO so) {
		return super.getPaginatedList(so);
	}

	public int getPaginatedListCount(CustomerSO so) {
		return super.getPaginatedListCount(so);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersByOrgId(Long orgId) {
		return super.getSession().selectList(getStatementNamespace()+ST_BY_ORG, orgId);
	}

}
