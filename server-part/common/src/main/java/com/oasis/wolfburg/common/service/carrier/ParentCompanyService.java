package com.oasis.wolfburg.common.service.carrier;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.carrier.ParentCompanySO;
import com.oasis.wolfburg.common.vo.carrier.ParentCompanyVO;

public interface ParentCompanyService {

	ParentCompanyVO findParentCompany(ClientContext clientContext, Long parentCompanyId);

	ParentCompanyVO viewParentCompany(ClientContext clientContext, Long parentCompanyId);

	Long createParentCompany(ClientContext clientContext, ParentCompanyVO parentCompanyVO);

	int deleteParentCompany(ClientContext clientContext, Long id);

	void updateParentCompany(ClientContext clientContext, ParentCompanyVO parentCompanyVO);

	void removeByIds(ClientContext clientContext, List<Long> parentCompanyIds);

	PageList<ParentCompanyVO> getPageList(ClientContext clientContext, ParentCompanySO parentCompanySO);

}
