package com.oasis.wolfburg.dao.truckRSSchedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.dao.SqlSessionHolder;
import com.oasis.tmsv5.util.exception.QueryException;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobTimeRecordSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobTimeRecordVO;
import com.oasis.wolfburg.model.truckRSSchedule.ClientBarcodeRecord;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJobTimeRecord;

@Repository
public class TruckRSJobTimeRecordDAOImpl extends BaseDAO<TruckRSJobTimeRecord> implements TruckRSJobTimeRecordDAO {

    private static final String DELETE_FKIDS = ".deleteByFKIds";

    private static final String GET_OFFICELINE_SCAN_JOBS = ".getOfficeLineScanJobs";
    
    private static final Log logger = LogFactory.getLog(TruckRSJobTimeRecordDAOImpl.class);
    
    private static final String ST_SELECT_LIST_REPORT = ".selectPageList"; 

    @Override
    public TruckRSJobTimeRecord getTruckRSJobTimeRecordByJob(Long trsJobId, Long posId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("TRS_JOB_ID", trsJobId);
        map.put("POS_ID", posId);
        TruckRSJobTimeRecord ret = super.getModelByPara(map);
        return ret;
    }

    @Override
    public TruckRSJobTimeRecord getTruckRSJobTimeRecordByBarcode(ClientBarcodeRecord processingCBR) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SCAN_CODE", processingCBR.getBarcode());
        map.put("POS_ID", processingCBR.getPosId());
        map.put("SCAN_TYPE", processingCBR.getScanType());
        TruckRSJobTimeRecord ret = super.getModelByPara(map);
        return ret;
    }

    @Override
    public TruckRSJobTimeRecord getTruckRSJobTimeRecordByPinCode(ClientBarcodeRecord processingCBR) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PIN_CODE", processingCBR.getBarcode());
        map.put("POS_ID", processingCBR.getPosId());
        map.put("SCAN_TYPE", processingCBR.getScanType());
        TruckRSJobTimeRecord ret = super.getModelByPara(map);
        return ret;
    }

    public void deleteByFKIds(List<Long> fkIds) {
        super.getSession().delete(super.getStatementNamespace() + DELETE_FKIDS, fkIds);
    }

    public List<TruckRSJobTimeRecordVO> getPaginatedList(TruckRSJobTimeRecordSO so) {
        return super.getPaginatedList(so);
    }
    
    @SuppressWarnings("unchecked")
	public List<TruckRSJobTimeRecordVO> getTruckRSJobTimeRecordList4Report(TruckRSJobTimeRecordSO so){
    	Long startTime = System.currentTimeMillis();
        try {
            List<TruckRSJobTimeRecordVO> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT_LIST_REPORT, so);
            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("Record loading took " + (System.currentTimeMillis() - startTime));
        }
    }

    public int getPaginatedListCount(TruckRSJobTimeRecordSO so) {
        return super.getPaginatedListCount(so);
    }

    @SuppressWarnings("unchecked")
    public List<TruckRSJobTimeRecord> getOfficeLineScanJobs() {
        List<TruckRSJobTimeRecord> ret = super.getSession().selectList(super.getStatementNamespace() + GET_OFFICELINE_SCAN_JOBS);
        return ret;
    }

    @Override
    public TruckRSJobTimeRecord getFirstStopTruckRSJobTimeRecordByJob(Long jobId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("TRS_JOB_ID", jobId);
        map.put("STOP_SEQ", 1);
        TruckRSJobTimeRecord ret = super.getModelByPara(map);
        return ret;
    }
}
