package com.oasis.wolfburg.facade.carrier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.carrier.ParentCompanyService;
import com.oasis.wolfburg.common.so.carrier.ParentCompanySO;
import com.oasis.wolfburg.common.vo.carrier.ParentCompanyVO;

@RemotingDestination
@Service
public class ParentCompanyServiceFacade {

//	@Autowired
	private ParentCompanyService parentCompanyService;

	public Long createParentCompany(ClientContext clientContext, ParentCompanyVO parentCompanyVO) {
		return parentCompanyService.createParentCompany(clientContext, parentCompanyVO);
	}

	public int deleteParentCompany(ClientContext clientContext, Long id) {
		return parentCompanyService.deleteParentCompany(clientContext, id);
	}

	public ParentCompanyVO findParentCompany(ClientContext clientContext, Long parentCompanyId) {
		return parentCompanyService.findParentCompany(clientContext, parentCompanyId);
	}

	public PageList<ParentCompanyVO> getPageList(ClientContext clientContext, ParentCompanySO parentCompanySO) {
		return parentCompanyService.getPageList(clientContext, parentCompanySO);
	}

	public void removeByIds(ClientContext clientContext, List<Long> parentCompanyIds) {
		parentCompanyService.removeByIds(clientContext, parentCompanyIds);
	}

	public void updateParentCompany(ClientContext clientContext, ParentCompanyVO parentCompanyVO) {
		parentCompanyService.updateParentCompany(clientContext, parentCompanyVO);
	}

	public ParentCompanyVO viewParentCompany(ClientContext clientContext, Long parentCompanyId) {
		return parentCompanyService.viewParentCompany(clientContext, parentCompanyId);
	}

}
