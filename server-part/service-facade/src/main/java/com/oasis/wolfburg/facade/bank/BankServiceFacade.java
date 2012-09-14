package com.oasis.wolfburg.facade.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.bank.BankService;
import com.oasis.wolfburg.common.so.bank.BankSO;
import com.oasis.wolfburg.common.vo.bank.BankVO;

@RemotingDestination
@Service
public class BankServiceFacade {

//	@Autowired
	private BankService bankService;

	public Long createBank(ClientContext clientContext, BankVO bankVO) {
		return bankService.createBank(clientContext, bankVO);
	}

	public int deleteBank(ClientContext clientContext, Long id) {
		return bankService.deleteBank(clientContext, id);
	}

	public BankVO findBank(ClientContext clientContext, Long bankId) {
		return bankService.findBank(clientContext, bankId);
	}

	public PageList<BankVO> getPageList(ClientContext clientContext, BankSO bankSO) {
		return bankService.getPageList(clientContext, bankSO);
	}

	public void removeByIds(ClientContext clientContext, List<Long> bankIds) {
		bankService.removeByIds(clientContext, bankIds);
	}

	public void updateBank(ClientContext clientContext, BankVO bankVO) {
		bankService.updateBank(clientContext, bankVO);
	}

	public BankVO viewBank(ClientContext clientContext, Long bankId) {
		return bankService.viewBank(clientContext, bankId);
	}

}
