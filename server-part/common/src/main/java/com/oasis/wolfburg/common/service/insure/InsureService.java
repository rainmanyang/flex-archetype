package com.oasis.wolfburg.common.service.insure;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.insure.InsureSO;
import com.oasis.wolfburg.common.vo.insure.InsureVO;

public interface InsureService {

	InsureVO findInsure(ClientContext clientContext, Long insureId);

	InsureVO viewInsure(ClientContext clientContext, Long insureId);

	Long createInsure(ClientContext clientContext, InsureVO insureVO);

	int deleteInsure(ClientContext clientContext, Long id);

	void updateInsure(ClientContext clientContext, InsureVO insureVO);

	void removeByIds(ClientContext clientContext, List<Long> insureIds);

	PageList<InsureVO> getPageList(ClientContext clientContext, InsureSO insureSO);

}
