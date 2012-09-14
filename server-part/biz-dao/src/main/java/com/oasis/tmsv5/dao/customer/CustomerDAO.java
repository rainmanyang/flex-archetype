package com.oasis.tmsv5.dao.customer;

import java.util.List;

import com.oasis.tmsv5.common.so.customer.CustomerSO;
import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.model.customer.Customer;

public interface CustomerDAO extends DAO<Customer> {
	List<Customer> getPaginatedList(CustomerSO so);
	
	int getPaginatedListCount(CustomerSO so);
	
	List<Customer> getCustomersByOrgId(Long orgId);
}
