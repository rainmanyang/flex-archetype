package com.oasis.test.route;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.route.PosSO;
import com.oasis.wolfburg.common.vo.route.PosVO;
import com.oasis.wolfburg.common.vo.route.PosViewVO;
import com.oasis.wolfburg.service.route.PosComponent;

public class PosServiceTest extends SpringBaseTest {
	@Autowired
	private PosComponent service;
	
	//@Test
	public void create(){
		PosVO pos = getVO();
		pos.setId(null);
		service.createPos(pos);
	}
	
	//@Test
	public void update() {
	    PosViewVO vo = getViewVO();
	    service.update(vo);
	}
	
	@Test
	public void getPageList(){
	    PosSO so = new PosSO();
	    so.setName("站点");
	    PageList<PosViewVO> page= service.getPageList(so);
	    Assert.notNull(page.getPages());
	}
	
	@Test
	public void findView(){
	    @SuppressWarnings("unused")
        PosViewVO vo = service.findView(62600L);
	}
	
	private PosVO getVO(){
	    PosVO vo = new PosVO();
	    vo.setId(1L);
	    vo.setAddress("天目山路");
	    vo.setPrivince("浙江");
	    vo.setCity("杭州");
	    vo.setDistrict("上城区");
	    vo.setName("站点1");
	    vo.setCode("pos1");
	    return vo;
	}
	
	private PosViewVO getViewVO(){
        PosViewVO vo = new PosViewVO();
        vo.setId(63200L);
        vo.setAddress("天目山路");
        vo.setPrivince("浙江");
        vo.setCity("杭州");
        vo.setDistrict("上城区");
        vo.setName("站点1");
        vo.setCode("pos1");
        return vo;
    }
	
//	
}
