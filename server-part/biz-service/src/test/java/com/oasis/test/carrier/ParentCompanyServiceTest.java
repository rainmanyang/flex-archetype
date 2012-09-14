package com.oasis.test.carrier;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.carrier.ParentCompanySO;
import com.oasis.wolfburg.common.vo.carrier.ParentCompanyVO;
import com.oasis.wolfburg.service.carrier.ParentCompanyComponent;

public class ParentCompanyServiceTest extends SpringBaseTest {
	
	@Autowired
	private ParentCompanyComponent service;
	
	@Test
	public void create(){
		ParentCompanyVO parentCompany = getVO();
		parentCompany.setId(null);
		service.createParentCompany(parentCompany);
	}
	
    @Test
	public void update() throws Exception {
		ParentCompanySO so = new ParentCompanySO();
	    //so.setCompanyName("CompanyName");
		PageList<ParentCompanyVO> page = service.getPageList(so);
		if (page.getFullListSize() > 0) {
			ParentCompanyVO vo = service.findParentCompany(page.getList().get(0).getId());
			vo.setCompanyName(vo.getCompanyName()+super.CODE);
			service.updateParentCompany(vo);
		} else {
			throw new Exception("getPageList() error!");
		}
	}
	
	@Test
	public void getPageList(){
		ParentCompanySO so = new ParentCompanySO();
	    so.setCompanyName("CompanyName");
	    PageList<ParentCompanyVO> page= service.getPageList(so);
	    Assert.notNull(page.getPages());
	}
	
	@Test
	public void deleteParentCompany()  throws Exception {
		ParentCompanySO so = new ParentCompanySO();
		//so.setCompanyName("CompanyName");
		PageList<ParentCompanyVO> page = service.getPageList(so);
		if (page.getFullListSize() > 0) {
			Long id = page.getList().get(0).getId();
			service.deleteParentCompany(id);
		} else {
			throw new Exception("getPageList() error!");
		}
	}
	
	@Test
	public void removeByIds() throws Exception  {
		ParentCompanySO so = new ParentCompanySO();
		//so.setCompanyName("CompanyName");
		PageList<ParentCompanyVO> page = service.getPageList(so);
		if (page.getFullListSize() > 0) {
			List<Long> parentCompanyIds = new ArrayList<Long> ();
			for(int k=0;k<3&&k<page.getList().size();k++){
				parentCompanyIds.add(page.getList().get(k).getId());
			}
			service.removeByIds(parentCompanyIds);
		} else {
			throw new Exception("getPageList() error!");
		}
		
	}
	
	private ParentCompanyVO getVO(){
		ParentCompanyVO vo = new ParentCompanyVO();
	    vo.setId(1L);
		vo.setCompanyName("CompanyName");
	    return vo;
	}
	

}
