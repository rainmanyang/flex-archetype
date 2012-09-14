package com.oasis.wolfburg.facade.bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.bill.PaymentItemService;
import com.oasis.wolfburg.common.so.bill.PaymentItemSO;
import com.oasis.wolfburg.common.vo.bill.PaymentItemVO;

@RemotingDestination
@Service
public class PaymentItemServiceFacade {

//    @Autowired
    private PaymentItemService paymentItemService;
    
    public String exportToExcel(ClientContext clientContext, PaymentItemSO so) throws Exception{
		return paymentItemService.exportToExcel(clientContext, so);
	}
    public String export(ClientContext clientContext, PaymentItemSO so) throws Exception{
		return paymentItemService.export(clientContext, so);
	}
    
    public void create(ClientContext clientContext, PaymentItemVO paymentItemvo) {
        paymentItemService.create(clientContext, paymentItemvo);
    }

    public void delete(ClientContext clientContext, Long id) {
        paymentItemService.delete(clientContext, id);
    }

    public PageList<PaymentItemVO> getPageList(ClientContext clientContext, PaymentItemSO so) {
        return paymentItemService.getPageList(clientContext, so);
    }
    
    public PageList<PaymentItemVO> getPageList4Report(ClientContext clientContext, PaymentItemSO so) {
        return paymentItemService.getPageList4Report(clientContext, so);
    }

    public void update(ClientContext clientContext, PaymentItemVO paymentItemVO) {
        paymentItemService.update(clientContext, paymentItemVO);
    }

    public void remove(ClientContext clientContext, List<Long> ids) {
        paymentItemService.remove(clientContext, ids);
    }
    
    public PaymentItemVO find(ClientContext clientContext, Long id){
        return paymentItemService.find(clientContext, id);
    }
    
    public PaymentItemVO findView(ClientContext clientContext,Long id){
        return paymentItemService.find(clientContext, id);
    }
    
   
}
