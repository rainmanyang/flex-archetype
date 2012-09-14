package com.oasis.wolfburg.dao.trackRecord;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.vo.trackRecord.TrackRecordViewVO;
import com.oasis.wolfburg.model.trackRecord.TrackRecord;

@Repository
public class TrackRecordDAOImpl extends BaseDAO<TrackRecord> implements
		TrackRecordDAO {

    private static final String SELECTLISTBYFKID = ".selectListByFKId";
    
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TrackRecordViewVO> selectListByFKId(Long id) {
        return getSession().selectList(getStatementNamespace() + SELECTLISTBYFKID, id);
    }
	
}
