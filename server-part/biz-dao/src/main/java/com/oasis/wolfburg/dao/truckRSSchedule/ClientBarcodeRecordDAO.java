package com.oasis.wolfburg.dao.truckRSSchedule;

import java.util.List;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.so.truckRSSchedule.ClientBarcodeRecordSO;
import com.oasis.wolfburg.model.truckRSSchedule.ClientBarcodeRecord;

public interface ClientBarcodeRecordDAO extends DAO<ClientBarcodeRecord> {    

    public List<ClientBarcodeRecord> getProcessingClientBarcodeRecord();
    
    public List<ClientBarcodeRecord> getPaginatedList(ClientBarcodeRecordSO so) ;

	public int getPaginatedListCount(ClientBarcodeRecordSO so) ;
	

}
