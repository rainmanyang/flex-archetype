package com.oasis.wolfburg.dao.truckRSSchedule;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.truckRSSchedule.ClientBarcodeRecordSO;
import com.oasis.wolfburg.model.truckRSSchedule.ClientBarcodeRecord;

@Repository
public class ClientBarcodeRecordDAOImpl extends BaseDAO<ClientBarcodeRecord> implements ClientBarcodeRecordDAO {

    private static final String SQL_GET_PROCESSINGCLIENT_BARCODERECORD = ".getProcessingClientBarcodeRecord";

    @SuppressWarnings("unchecked")
    @Override
    public List<ClientBarcodeRecord> getProcessingClientBarcodeRecord() {

        List<ClientBarcodeRecord> ret = super.getSession().selectList(
                super.getStatementNamespace() + SQL_GET_PROCESSINGCLIENT_BARCODERECORD);
        return ret;
    }
    
    public List<ClientBarcodeRecord> getPaginatedList(ClientBarcodeRecordSO so) {
		return super.getPaginatedList(so);
	}

	public int getPaginatedListCount(ClientBarcodeRecordSO so) {
		return super.getPaginatedListCount(so);
	}

}
