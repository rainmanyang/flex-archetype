package com.oasis.tmsv5.dao.base;

import java.util.List;

import com.oasis.tmsv5.common.so.base.DownloadInfoSO;
import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.model.base.DownloadInfo;

public interface DownloadInfoDAO extends DAO<DownloadInfo> {

	public List<DownloadInfo> getPaginatedList(DownloadInfoSO so);

	public int getPaginatedListCount(DownloadInfoSO so) ;
}
