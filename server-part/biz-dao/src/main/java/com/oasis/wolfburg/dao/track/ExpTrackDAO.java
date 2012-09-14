package com.oasis.wolfburg.dao.track;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.track.ExpTrackSO;
import com.oasis.wolfburg.model.track.ExpTrack;

public interface ExpTrackDAO extends DAO<ExpTrack>{
	List<ExpTrack> getPaginatedList(ExpTrackSO so);
	
	int getPaginatedListCount(ExpTrackSO so);
	
	List<ExpTrack> getCurExps();
	
	List<ExpTrack> getRsJobInfoByLicensePlate(String licensePlate);
	
	List<ExpTrack> findRsJobListBySO(ExpTrackSO so);
}
