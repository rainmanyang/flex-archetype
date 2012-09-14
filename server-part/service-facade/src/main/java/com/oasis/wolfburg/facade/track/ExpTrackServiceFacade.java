package com.oasis.wolfburg.facade.track;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.track.ExpTrackService;
import com.oasis.wolfburg.common.so.track.ExpTrackSO;
import com.oasis.wolfburg.common.vo.track.ExpTrackVO;

@RemotingDestination
@Service
public class ExpTrackServiceFacade {
//	@Autowired
	private ExpTrackService expTrackService;
	
	public PageList<ExpTrackVO> getPageList(ClientContext clientContext,ExpTrackSO so){
		return expTrackService.getPageList(clientContext,so);
	}
	
	public ExpTrackVO find(ClientContext clientContext,Long id){
		return expTrackService.load(clientContext,id);
	}
	
	public void create(ClientContext clientContext,ExpTrackVO vo){
		expTrackService.createExpTrack(clientContext,vo);
	}
	
	public List<ExpTrackVO> getRsJobInfoByLicensePlate(
			ClientContext clientContext, String licensePlate) {
		return expTrackService.getRsJobInfoByLicensePlate(clientContext, licensePlate);
	}
	
	public List<ExpTrackVO> getCurExps(ClientContext clientContext){
	    return expTrackService.getCurExps(clientContext);
	}
	
	public ExpTrackVO process(ClientContext clientContext,ExpTrackVO vo){
	    return expTrackService.process(clientContext,vo);
	}
	
	public List<ExpTrackVO> findRsJobListBySO(
			ClientContext clientContext, ExpTrackSO so) {
		return expTrackService.findRsJobListBySO(clientContext, so);
	}
}
