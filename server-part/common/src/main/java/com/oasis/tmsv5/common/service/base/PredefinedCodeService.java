package com.oasis.tmsv5.common.service.base;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.base.PredefinedCodeVO;
import com.oasis.wolfburg.common.so.predefinedCode.PredefinedCodeSO;

public interface PredefinedCodeService {
	
	public List<PredefinedCodeVO> getPredefinedCodesByType(ClientContext clientContext);
	
	
	public PredefinedCodeVO getPredefinedCodesByCode(String code);
	
	List<PredefinedCodeVO> queryPredefinedCodes(ClientContext clientContext,PredefinedCodeSO so);
	
	void create(ClientContext clientContext,PredefinedCodeVO vo);
}
