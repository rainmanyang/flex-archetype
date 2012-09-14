package com.oasis.wolfburg.common.service.track;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.track.ExpTrackSO;
import com.oasis.wolfburg.common.vo.track.ExpTrackVO;

public interface ExpTrackService {
	PageList<ExpTrackVO> getPageList(ClientContext clientContext,ExpTrackSO so);
	
	ExpTrackVO load(ClientContext clientContext,Long id);
	
	void createExpTrack(ClientContext clientContext,ExpTrackVO vo);
	
	List<ExpTrackVO> getRsJobInfoByLicensePlate(ClientContext clientContext,String licensePlate);
	
	List<ExpTrackVO> getCurExps(ClientContext clientContext);
	
	ExpTrackVO process(ClientContext clientContext,ExpTrackVO vo);
	
	List<ExpTrackVO> findRsJobListBySO(ClientContext clientContext,ExpTrackSO so);
}
