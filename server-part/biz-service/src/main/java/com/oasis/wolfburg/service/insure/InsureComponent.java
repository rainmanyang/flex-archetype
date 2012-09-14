package com.oasis.wolfburg.service.insure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.wolfburg.common.so.insure.InsureSO;
import com.oasis.wolfburg.common.vo.insure.InsureVO;
import com.oasis.wolfburg.dao.insure.InsureDAO;
import com.oasis.wolfburg.model.insure.Insure;
@Service
@Deprecated
public class InsureComponent extends BaseComponent {
	
	@Autowired
	private InsureDAO insureDAO;
	
	public InsureVO findInsure(Long insureId){
		Insure insure = insureDAO.find(insureId);
		InsureVO insureVO = super.getDozer().convert(insure, InsureVO.class);
		return insureVO;
	}
	
	public InsureVO viewInsure(Long insureId){
		Insure insure = insureDAO.find(insureId);
		InsureVO insureVO = super.getDozer().convert(insure, InsureVO.class);
		return insureVO;
	}
	
	public void updateInsure(InsureVO insureVO) {
		insureDAO.update(super.getDozer().convert(insureVO, Insure.class));
	}

	public PageList<InsureVO> getPageList(InsureSO insureSO) {
		List<Insure> insureList = insureDAO.getPaginatedList(insureSO);
		List<InsureVO> list = super.getDozer().convertList(insureList,InsureVO.class);
		int cnt = insureDAO.getPaginatedListCount(insureSO);
		PageList<InsureVO> page = new PageList<InsureVO>();
		page.setList(list);
		page.setFullListSize(cnt);
		return page;
	}
	
}
