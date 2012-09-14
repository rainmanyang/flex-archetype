package com.oasis.wolfburg.dao.track;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.track.ExpTrackSO;
import com.oasis.wolfburg.model.track.ExpTrack;

@Repository
public class ExpTrackDAOImpl extends BaseDAO<ExpTrack> implements ExpTrackDAO{
	private static final String RSJOB_INFO = ".getRsJobInfo";
	private static final String FIND_RSJOB_INFO = ".findRsJobInfo";
	
	private static final String GET_CUR_DATE = ".getCurDate";
	
	public List<ExpTrack> getPaginatedList(ExpTrackSO so) {
		return super.getPaginatedList(so);
	}

	public int getPaginatedListCount(ExpTrackSO so) {
		return super.getPaginatedListCount(so);
	}

    @SuppressWarnings("unchecked")
    @Override
    public List<ExpTrack> getCurExps() {
       return super.getSession().selectList(super.getStatementNamespace()+GET_CUR_DATE);
    }
	
	
	@SuppressWarnings("unchecked")
	public List<ExpTrack> getRsJobInfoByLicensePlate(String licensePlate){
		return super.getSession().selectList(super.getStatementNamespace()+RSJOB_INFO, licensePlate);
	}
	
	@SuppressWarnings("unchecked")
	public List<ExpTrack> findRsJobListBySO(ExpTrackSO so){
		return super.getSession().selectList(super.getStatementNamespace()+FIND_RSJOB_INFO, so);
	}
}
