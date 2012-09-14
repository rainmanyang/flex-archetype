package com.oasis.tmsv5.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.so.customer.CustomerSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.customer.CustomerVO;
import com.oasis.tmsv5.dao.customer.CustomerDAO;
import com.oasis.tmsv5.model.customer.Customer;
import com.oasis.tmsv5.service.BaseComponent;

@Service
public class CustomerComponent extends BaseComponent {
	@Autowired
	private CustomerDAO customerDAO;
	
	public PageList<CustomerVO> getPageList(CustomerSO so){
		int count = customerDAO.getPaginatedListCount(so);
		List<Customer> cusList = customerDAO.getPaginatedList(so);
		List<CustomerVO> list = getDozer().convertList(cusList, CustomerVO.class);
		PageList<CustomerVO> pageList = new PageList<CustomerVO>(so);
		pageList.setFullListSize(count);
		pageList.setList(list);
		return pageList;
	}
}
