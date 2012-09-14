package com.oasis.tmsv5.facade.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.base.PredefinedCodeVO;
import com.oasis.tmsv5.common.service.base.PredefinedCodeService;
import com.oasis.wolfburg.common.so.predefinedCode.PredefinedCodeSO;

@RemotingDestination
@Service
public class PredefinedCodeServiceFacade {
//	@Autowired
	private PredefinedCodeService predefinedCodeService;
	
	public List<PredefinedCodeVO> getPredefinedCodesByType(ClientContext clientContext){
		return predefinedCodeService.getPredefinedCodesByType(clientContext);
	}
	
	public PredefinedCodeVO getPredefinedCodesByCode(String code){
		return predefinedCodeService.getPredefinedCodesByCode(code);
	}
	
	public List<PredefinedCodeVO> queryPredefinedCodes(ClientContext clientContext,PredefinedCodeSO so){
		return predefinedCodeService.queryPredefinedCodes(clientContext,so);
	}
	
	public void create(ClientContext clientContext,PredefinedCodeVO vo){
		predefinedCodeService.create(clientContext,vo);
	}
}
