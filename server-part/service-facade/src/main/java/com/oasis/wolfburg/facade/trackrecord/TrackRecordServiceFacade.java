package com.oasis.wolfburg.facade.trackrecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.wolfburg.common.service.trackrecord.TrackRecordService;
import com.oasis.wolfburg.common.vo.trackRecord.TrackRecordViewVO;

@RemotingDestination
@Service
public class TrackRecordServiceFacade {

//    @Autowired
    private TrackRecordService trackRecordService;

    public List<TrackRecordViewVO> selectListByFKId(ClientContext clientContext, Long id) {
        return trackRecordService.selectListByFKId(clientContext, id);
    }

}
