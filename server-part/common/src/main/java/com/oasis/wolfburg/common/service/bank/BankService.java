package com.oasis.wolfburg.common.service.bank;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.bank.BankSO;
import com.oasis.wolfburg.common.vo.bank.BankVO;

public interface BankService {

	BankVO findBank(ClientContext clientContext, Long bankId);

	BankVO viewBank(ClientContext clientContext, Long bankId);

	Long createBank(ClientContext clientContext, BankVO bankVO);

	int deleteBank(ClientContext clientContext, Long id);

	void updateBank(ClientContext clientContext, BankVO bankVO);

	void removeByIds(ClientContext clientContext, List<Long> bankIds);

	PageList<BankVO> getPageList(ClientContext clientContext, BankSO bankSO);

}
