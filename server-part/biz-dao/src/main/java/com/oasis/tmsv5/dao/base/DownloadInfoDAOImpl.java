package com.oasis.tmsv5.dao.base;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.common.so.base.DownloadInfoSO;
import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.model.base.DownloadInfo;

@Repository
public class DownloadInfoDAOImpl extends BaseDAO<DownloadInfo> implements DownloadInfoDAO {


    private static final Log logger = LogFactory.getLog(DownloadInfoDAOImpl.class);

    public List<DownloadInfo> getPaginatedList(DownloadInfoSO so) {
		return super.getPaginatedList(so);
	}

	public int getPaginatedListCount(DownloadInfoSO so) {
		return super.getPaginatedListCount(so);
	}

}
