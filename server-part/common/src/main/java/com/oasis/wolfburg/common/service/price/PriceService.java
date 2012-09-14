package com.oasis.wolfburg.common.service.price;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.price.PriceSO;
import com.oasis.wolfburg.common.vo.price.PriceVO;

public interface PriceService {
	PageList<PriceVO> getPageList(ClientContext clientContext,PriceSO so);
	
	PriceVO load(ClientContext clientContext,Long id);
	
	void createPrice(ClientContext clientContext,PriceVO vo);
	
	void editPrice(ClientContext clientContext,PriceVO vo);
	
	void updateStatus(ClientContext clientContext,List<Long> ids);
	
	void delay(ClientContext clientContext, List<Long> ids,int days);
}
