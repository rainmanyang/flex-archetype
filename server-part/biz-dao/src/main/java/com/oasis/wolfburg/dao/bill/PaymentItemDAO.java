package com.oasis.wolfburg.dao.bill;

import java.util.Date;
import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.bill.PaymentItemSO;
import com.oasis.wolfburg.common.vo.bill.PaymentItemReportVO;
import com.oasis.wolfburg.model.bill.PaymentItem;

public interface PaymentItemDAO extends DAO<PaymentItem> {

	public List<PaymentItem> getPaginatedList(PaymentItemSO so) ;

	public int getPaginatedListCount(PaymentItemSO so) ;
	
	public List<PaymentItem> getPaginatedList4Report(PaymentItemSO so);

	public int getPaginatedListCount4Report(PaymentItemSO so);
	
	public List<PaymentItemReportVO> getPaymentItemList4Report(PaymentItemSO so);
	
	public void updateFlag(String flag,Date billDateBegin,Date billDateEnd);
	
	public List<PaymentItem> getPaymentItemList4Excel(PaymentItemSO so);
}
