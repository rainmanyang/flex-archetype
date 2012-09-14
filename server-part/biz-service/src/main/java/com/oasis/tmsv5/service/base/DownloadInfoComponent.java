package com.oasis.tmsv5.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.so.base.DownloadInfoSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.base.DownloadInfoVO;
import com.oasis.tmsv5.dao.base.DownloadInfoDAO;
import com.oasis.tmsv5.model.base.DownloadInfo;
import com.oasis.tmsv5.service.BaseComponent;

@Service
public class DownloadInfoComponent extends BaseComponent {
	
	@Autowired
	private DownloadInfoDAO downloadInfoDAO;
	
	public PageList<DownloadInfoVO> getPageList(DownloadInfoSO so){
		int count = downloadInfoDAO.getPaginatedListCount(so);
		List<DownloadInfo> downloadInfoList = downloadInfoDAO.getPaginatedList(so);
		List<DownloadInfoVO> list = getDozer().convertList(downloadInfoList, DownloadInfoVO.class);
		PageList<DownloadInfoVO> pageList = new PageList<DownloadInfoVO>(so);
		pageList.setFullListSize(count);
		pageList.setList(list);
		return pageList;
	}
	
	public void inser(DownloadInfoVO downloadInfoVO){
		DownloadInfo downloadInfo = dozer.convert(downloadInfoVO, DownloadInfo.class);
		downloadInfoDAO.insert(downloadInfo);
	}
	
}