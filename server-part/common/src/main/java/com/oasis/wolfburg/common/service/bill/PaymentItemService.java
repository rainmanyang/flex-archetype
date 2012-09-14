package com.oasis.wolfburg.common.service.bill;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.bill.PaymentItemSO;
import com.oasis.wolfburg.common.vo.bill.PaymentItemVO;

public interface PaymentItemService {

    void create(ClientContext clientContext,PaymentItemVO paymentItemVO);

    void delete(ClientContext clientContext,Long Id);
    
    PageList<PaymentItemVO> getPageList(ClientContext clientContext,PaymentItemSO so);
    
    PageList<PaymentItemVO> getPageList4Report(ClientContext clientContext,PaymentItemSO so);
    
    
    void update(ClientContext clientContext,PaymentItemVO paymentItemVO);
    
    void remove(ClientContext clientContext,List<Long> ids);
    
    PaymentItemVO find(ClientContext clientContext,Long id);
    
     String exportToExcel(ClientContext clientContext, PaymentItemSO so) throws Exception ;
     
     public String export(ClientContext clientContext, PaymentItemSO so) throws Exception;

    
}
