package com.oasis.tmsv5.common.service.customer;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.so.customer.CustomerSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.customer.CustomerVO;

public interface CustomerService {
	PageList<CustomerVO> getPageList(ClientContext clientContext,CustomerSO so);
}
