package com.oasis.wolfburg.facade.price;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.price.PriceService;
import com.oasis.wolfburg.common.so.price.PriceSO;
import com.oasis.wolfburg.common.vo.price.PriceVO;

@RemotingDestination
@Service
public class PriceServiceFacade {
//	@Autowired
	private PriceService priceService;
	
	public PageList<PriceVO> getPageList(ClientContext clientContext,PriceSO so){
		return priceService.getPageList(clientContext,so);
	}
	
	public PriceVO find(ClientContext clientContext,Long id){
		return priceService.load(clientContext,id);
	}
	
	public void create(ClientContext clientContext,PriceVO vo){
		priceService.createPrice(clientContext,vo);
	}
	
	public void editPrice(ClientContext clientContext,PriceVO vo){
		priceService.editPrice(clientContext,vo);
	}
	
	public void updateStatus(ClientContext clientContext,List<Long> ids){
		priceService.updateStatus(clientContext, ids);
	}
	
	public void delay(ClientContext clientContext, List<Long> ids,int days){
		priceService.delay(clientContext, ids, days);
	}
}
