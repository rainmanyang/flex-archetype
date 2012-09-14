package com.oasis.wolfburg.service.truckRSSchedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.wolfburg.common.so.truckRSSchedule.ClientBarcodeRecordSO;
import com.oasis.wolfburg.common.vo.truckRSSchedule.ClientBarcodeRecordVO;
import com.oasis.wolfburg.dao.truckRSSchedule.ClientBarcodeRecordDAO;
import com.oasis.wolfburg.model.truckRSSchedule.ClientBarcodeRecord;

@Component
public class ClientBarcodeRecordComponent extends BaseComponent {

    @Autowired
    private ClientBarcodeRecordDAO clientBarcodeRecordDAO;

    public PageList<ClientBarcodeRecordVO> getPageList(ClientBarcodeRecordSO so){
		int count = clientBarcodeRecordDAO.getPaginatedListCount(so);
		List<ClientBarcodeRecord> cbrList = clientBarcodeRecordDAO.getPaginatedList(so);
		List<ClientBarcodeRecordVO> list = getDozer().convertList(cbrList, ClientBarcodeRecordVO.class);
		PageList<ClientBarcodeRecordVO> pageList = new PageList<ClientBarcodeRecordVO>(so);
		pageList.setFullListSize(count);
		pageList.setList(list);
		return pageList;
	}
}
