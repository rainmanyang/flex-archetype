package com.oasis.wolfburg.service.truck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.wolfburg.common.so.truck.TruckStatusRecordSO;
import com.oasis.wolfburg.common.vo.truck.TruckStatusRecordVO;
import com.oasis.wolfburg.dao.truck.TruckStatusRecordDAO;
import com.oasis.wolfburg.model.truck.TruckStatusRecord;
@Service
public class TruckStatusRecordComponent extends BaseComponent {

	@Autowired
	private TruckStatusRecordDAO truckStatusRecordDAO;
	
	public TruckStatusRecordVO findTruckStatusRecord(Long truckStatusRecordId){
		TruckStatusRecord truckStatusRecord = truckStatusRecordDAO.find(truckStatusRecordId);
		TruckStatusRecordVO truckStatusRecordIdVO = super.getDozer().convert(truckStatusRecord, TruckStatusRecordVO.class);
		return truckStatusRecordIdVO;
	}
	
	public TruckStatusRecordVO viewTruckStatusRecord(Long truckStatusRecordId){
		TruckStatusRecord truckStatusRecord = truckStatusRecordDAO.find(truckStatusRecordId);
		TruckStatusRecordVO truckStatusRecordIdVO = super.getDozer().convert(truckStatusRecord, TruckStatusRecordVO.class);
		return truckStatusRecordIdVO;
	}
	
	public Long createTruckStatusRecord(TruckStatusRecordVO  truckStatusRecordVO) {
		TruckStatusRecord truckStatusRecord = super.getDozer().convert(truckStatusRecordVO,  TruckStatusRecord.class);
		Long id = truckStatusRecordDAO.insert(truckStatusRecord);
		return id;
	}
	
	public void updateTruckStatusRecord(TruckStatusRecordVO truckStatusRecordVO) {
		TruckStatusRecord truckStatusRecord = super.getDozer().convert(truckStatusRecordVO, TruckStatusRecord.class);
		truckStatusRecordDAO.update(truckStatusRecord);
	}
	
	public PageList<TruckStatusRecordVO> getPageList(TruckStatusRecordSO truckStatusRecordSO) {
		List<TruckStatusRecord> statusList = truckStatusRecordDAO.getPaginatedList(truckStatusRecordSO);
		List<TruckStatusRecordVO> list = super.getDozer().convertList(statusList,TruckStatusRecordVO.class);
		int cnt = truckStatusRecordDAO.getPaginatedListCount(truckStatusRecordSO);
		PageList<TruckStatusRecordVO> page = new PageList<TruckStatusRecordVO>();
		page.setList(list);
		page.setFullListSize(cnt);
		return page;
	}
	
}
