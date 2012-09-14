package com.oasis.tmsv5.facade.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.service.base.DownloadInfoService;
import com.oasis.tmsv5.common.so.base.DownloadInfoSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.base.DownloadInfoVO;

@RemotingDestination
@Service
public class DownloadInfoServiceFacade {
//	@Autowired
	private DownloadInfoService downloadInfoService;
	
	public PageList<DownloadInfoVO> getPageList(ClientContext clientContext,DownloadInfoSO so){
		return downloadInfoService.getPageList(clientContext, so);
	}
}
