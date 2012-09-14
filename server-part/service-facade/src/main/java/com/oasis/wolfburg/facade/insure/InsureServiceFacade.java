package com.oasis.wolfburg.facade.insure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.insure.InsureService;
import com.oasis.wolfburg.common.so.insure.InsureSO;
import com.oasis.wolfburg.common.vo.insure.InsureVO;

@RemotingDestination
@Service
public class InsureServiceFacade {

//	@Autowired
	private InsureService insureService;

	public Long createInsure(ClientContext clientContext, InsureVO insureVO) {
		return insureService.createInsure(clientContext, insureVO);
	}

	public int deleteInsure(ClientContext clientContext, Long id) {
		return insureService.deleteInsure(clientContext, id);
	}

	public InsureVO findInsure(ClientContext clientContext, Long insureId) {
		return insureService.findInsure(clientContext, insureId);
	}

	public PageList<InsureVO> getPageList(ClientContext clientContext, InsureSO insureSO) {
		return insureService.getPageList(clientContext, insureSO);
	}

	public void removeByIds(ClientContext clientContext, List<Long> insureIds) {
		insureService.removeByIds(clientContext, insureIds);
	}

	public void updateInsure(ClientContext clientContext, InsureVO insureVO) {
		insureService.updateInsure(clientContext, insureVO);
	}

	public InsureVO viewInsure(ClientContext clientContext, Long insureId) {
		return insureService.viewInsure(clientContext, insureId);
	}

}
