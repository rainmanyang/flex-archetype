package com.oasis.wolfburg.service.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.wolfburg.common.so.bank.BankSO;
import com.oasis.wolfburg.common.vo.bank.BankVO;
import com.oasis.wolfburg.dao.bank.BankDAO;
import com.oasis.wolfburg.model.bank.Bank;
@Service
@Deprecated
public class BankComponent extends BaseComponent {
	
	@Autowired
	private BankDAO bankDAO;
	
	public BankVO findBank(Long bankId){
		Bank bank = bankDAO.find(bankId);
		BankVO bankVO = super.getDozer().convert(bank, BankVO.class);
		return bankVO;
	}
	
	public BankVO viewBank(Long bankId){
		Bank bank = bankDAO.find(bankId);
		BankVO bankVO = super.getDozer().convert(bank, BankVO.class);
		return bankVO;
	}
	
	public int deleteBank(Long id) {
		return bankDAO.delete(id);
	}

	public PageList<BankVO> getPageList(BankSO bankSO) {
		List<Bank> bankeList = bankDAO.getPaginatedList(bankSO);
		List<BankVO> list = super.getDozer().convertList(bankeList,BankVO.class);
		int cnt = bankDAO.getPaginatedListCount(bankSO);
		PageList<BankVO> page = new PageList<BankVO>();
		page.setList(list);
		page.setFullListSize(cnt);
		return page;
	}
	
}
