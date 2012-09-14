package com.oasis.test.ExpTrack;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.track.ExpTrackSO;
import com.oasis.wolfburg.common.vo.track.ExpTrackVO;
import com.oasis.wolfburg.service.track.ExpTrackComponent;

public class ExpTrackServiceTest extends SpringBaseTest {
	@Autowired
	private ExpTrackComponent expTrackComponent;

	@Test
	public void getCurrExpList() {
		expTrackComponent.getCurExps();
	}

	// public void process(){
	// expTrackComponent.process(vo);
	// }

	@Test
	public void getPageList() {
		ExpTrackSO so = new ExpTrackSO();
		so.setLicensePlate("license");
		PageList<ExpTrackVO> page = expTrackComponent.getPageList(so);
		System.out.println(page.getFullListSize());
	}

	@Test
	public void load() {
		Long id = 60000L;
		ExpTrackVO vo = expTrackComponent.load(id);
		System.out.println(vo.getRouteName());
	}

	@Test
	public void getRsJobInfoByLicensePlate() {
		String licensePlate = "licensePlate5";
		List<ExpTrackVO> list = expTrackComponent
				.getRsJobInfoByLicensePlate(licensePlate);
		for (ExpTrackVO vo : list) {
			System.out.println(vo.getRssJobCode() + ":" + vo.getRsJobId() + ":"
					+ vo.getRsScheduleName() + ":" + vo.getRsScheduleId() + ":"
					+ vo.getRouteName());
		}
	}
	
	@Test
	public void process(){
		Long id = 60000L;
		ExpTrackVO vo = expTrackComponent.load(id);
		vo.setExpDealContent("异常处理");
		vo = expTrackComponent.process(vo);
		System.out.println(vo.getExpDealer()+":"+vo.getExpDealTime()+":"+vo.getStatus());
	}
	
	@Test
	public void findRsJobListBySO(){
		ExpTrackSO so = new ExpTrackSO();
		so.setLicensePlate("车121905");
		List<ExpTrackVO> list = expTrackComponent.findRsJobListBySO(so);
		System.out.println("findRsJobListBySO:size="+list.size());
	}
}
