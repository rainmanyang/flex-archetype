package com.oasis.wolfburg.common.service.trackrecord;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.wolfburg.common.vo.trackRecord.TrackRecordViewVO;


public interface TrackRecordService {

    List<TrackRecordViewVO> selectListByFKId(ClientContext clientContext,Long id);
}
