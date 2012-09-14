package com.oasis.tmsv5.facade.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.service.customer.CustomerService;
import com.oasis.tmsv5.common.so.customer.CustomerSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.customer.CustomerVO;

@RemotingDestination
@Service
public class CustomerServiceFacade {
//	@Autowired
	private CustomerService customerService;
	
	public PageList<CustomerVO> getPageList(ClientContext clientContext,CustomerSO so){
		return customerService.getPageList(clientContext, so);
	}
}
