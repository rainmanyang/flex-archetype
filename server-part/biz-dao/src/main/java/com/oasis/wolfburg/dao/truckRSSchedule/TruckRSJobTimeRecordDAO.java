package com.oasis.wolfburg.dao.truckRSSchedule;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobTimeRecordSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobTimeRecordVO;
import com.oasis.wolfburg.model.truckRSSchedule.ClientBarcodeRecord;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJobTimeRecord;

public interface TruckRSJobTimeRecordDAO extends DAO<TruckRSJobTimeRecord> {

    TruckRSJobTimeRecord getTruckRSJobTimeRecordByJob(Long trsJobId, Long posId);

    TruckRSJobTimeRecord getTruckRSJobTimeRecordByBarcode(ClientBarcodeRecord processingCBR);

    TruckRSJobTimeRecord getTruckRSJobTimeRecordByPinCode(ClientBarcodeRecord processingCBR);

    void deleteByFKIds(List<Long> fkIds);

    List<TruckRSJobTimeRecordVO> getTruckRSJobTimeRecordList4Report(TruckRSJobTimeRecordSO so);

    List<TruckRSJobTimeRecordVO> getPaginatedList(TruckRSJobTimeRecordSO so);

    int getPaginatedListCount(TruckRSJobTimeRecordSO so);

    List<TruckRSJobTimeRecord> getOfficeLineScanJobs();

    TruckRSJobTimeRecord getFirstStopTruckRSJobTimeRecordByJob(Long jobId);
}
