package com.oasis.tmsv5.common.service.base;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.so.base.DownloadInfoSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.base.DownloadInfoVO;

public interface DownloadInfoService {
	
	public PageList<DownloadInfoVO> getPageList(ClientContext clientContext,DownloadInfoSO so);
}
