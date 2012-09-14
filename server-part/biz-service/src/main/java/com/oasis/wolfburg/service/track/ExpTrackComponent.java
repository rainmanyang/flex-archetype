package com.oasis.wolfburg.service.track;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.security.ClientContextHolder;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ResourceDispHelper;
import com.oasis.wolfburg.common.enums.status.ExpDealStatus;
import com.oasis.wolfburg.common.enums.type.EventPhase;
import com.oasis.wolfburg.common.so.track.ExpTrackSO;
import com.oasis.wolfburg.common.vo.track.ExpTrackVO;
import com.oasis.wolfburg.dao.track.ExpTrackDAO;
import com.oasis.wolfburg.dao.trackRecord.TrackRecordDAO;
import com.oasis.wolfburg.model.track.ExpTrack;
import com.oasis.wolfburg.model.trackRecord.TrackRecord;
import com.oasis.wolfburg.service.qzSchedule.handler.RsJobNotificationHandler;

@Service
public class ExpTrackComponent extends BaseComponent {
	@Autowired
	private ExpTrackDAO expTrackDAO;
	
	@Autowired
	private TrackRecordDAO trackRecordDAO;
	
	@Autowired
	private RsJobNotificationHandler handler;
	
	public PageList<ExpTrackVO> getPageList(ExpTrackSO so){
		int count = expTrackDAO.getPaginatedListCount(so);
		List<ExpTrack> ExpTrackList = expTrackDAO.getPaginatedList(so);
		List<ExpTrackVO> list = getDozer().convertList(ExpTrackList, ExpTrackVO.class);
		PageList<ExpTrackVO> pageList = new PageList<ExpTrackVO>(so);
		pageList.setFullListSize(count);
		pageList.setList(list);
		return pageList;
	}
	
	public ExpTrackVO load(Long id){
		ExpTrack expTrack = expTrackDAO.find(id);
		return super.getDozer().convert(expTrack, ExpTrackVO.class);
	}
	
	public void createExpTrack(ExpTrackVO vo){
		ExpTrack expTrack = super.getDozer().convert(vo, ExpTrack.class);
		expTrack.setStatus(ExpDealStatus.UNPROCESSED);
		expTrackDAO.insert(expTrack);
		/**
		 * reviewer:this block should be moved to TrackRecordHelper
		 */
		TrackRecord tr = new TrackRecord();
		tr.setTruckRsJobId(expTrack.getRsJobId());
		tr.setEventTime(new Date());
		tr.setDescription(ResourceDispHelper.getInstance().getValue("TRUCK") +expTrack.getLicensePlate()+ResourceDispHelper.getInstance().getValue("EXCEPTION"));
		tr.setEventPhase(EventPhase.ENROUTE);
		trackRecordDAO.insert(tr);
		
		handler.handleExpTrack(expTrack);
	}
	
	public List<ExpTrackVO> getCurExps(){
	    return super.getDozer().convertList(expTrackDAO.getCurExps(),  ExpTrackVO.class);
	}
	
	public List<ExpTrackVO> getRsJobInfoByLicensePlate(String licensePlate){
		List<ExpTrack> list = expTrackDAO.getRsJobInfoByLicensePlate(licensePlate);
		return super.getDozer().convertList(list, ExpTrackVO.class);
	}
	
	public ExpTrackVO process(ExpTrackVO vo) {
	    vo.setExpDealer(ClientContextHolder.getContext().getLoginName());
	    vo.setExpDealTime(new Date());
	    vo.setStatus(ExpDealStatus.PROCESSED);
	    ExpTrack expTrack = super.getDozer().convert(vo, ExpTrack.class);
	    expTrack = expTrackDAO.update(expTrack);
		return super.getDozer().convert(expTrack, ExpTrackVO.class);
	}
	
	public List<ExpTrackVO> findRsJobListBySO(ExpTrackSO so){
		List<ExpTrack> list = expTrackDAO.findRsJobListBySO(so);
		return super.getDozer().convertList(list, ExpTrackVO.class);
	}
}
