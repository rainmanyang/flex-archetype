package com.oasis.wolfburg.service.trackrecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.wolfburg.common.vo.trackRecord.TrackRecordViewVO;
import com.oasis.wolfburg.dao.trackRecord.TrackRecordDAO;

@Service
public class TrackRecordComponent extends BaseComponent {

    @Autowired
    private TrackRecordDAO trackRecordDAO;

    public List<TrackRecordViewVO> selectListByFKId(Long id) {
        return trackRecordDAO.selectListByFKId(id);
    }

}