package com.oasis.wolfburg.dao.trackRecord;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.vo.trackRecord.TrackRecordViewVO;
import com.oasis.wolfburg.model.trackRecord.TrackRecord;

public interface TrackRecordDAO extends DAO<TrackRecord> {
	List<TrackRecordViewVO> selectListByFKId(Long id);
}
