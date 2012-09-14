package com.oasis.test.Organization;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.so.security.OrganizationSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.common.vo.address.AddressVO;
import com.oasis.tmsv5.common.vo.customer.CustomerVO;
import com.oasis.tmsv5.common.vo.orgnization.OrganizationVO;
import com.oasis.tmsv5.common.vo.zone.NaturalZoneVO;
import com.oasis.tmsv5.service.organization.OrganizationComponent;

public class OrganizationServiceTest extends SpringBaseTest {
	@Autowired
	private OrganizationComponent service;
	
	@Test
	public void createOrganization(){
		OrganizationVO org = this.getOrgVO();
		org.setId(null);
		service.createOrganization(org);
	}
	
	@Test
	public void getPageList(){
		OrganizationSO so = new OrganizationSO();
		so.setName("杭州");
		PageList<OrganizationVO> page = service.getPageList(so);
		System.out.println(page.getFullListSize());
	}
	
	@Test
	public void getOrgTree(){
	    TreeNode node = service.getOrgTree("百世");
	    System.out.println(node.toString());
	}
	
	@Test
	public void update(){
		OrganizationVO org = this.getOrgVO();
		org.setName(org.getName()+super.CODE);
		org.setCode(org.getCode()+super.CODE);
		service.update(org);
	}
	
	@Test
	public void view(){
		OrganizationVO vo = service.view(60000L);
		
		System.out.println(vo.getName());
	}
	
	//@Test
	public void testGetOrgTree(){
	    String condition = "百世";
	    TreeNode treeNode = service.getOrgTree(condition);
	    Assert.notNull(treeNode);
	}
	
	private OrganizationVO getOrgVO(){
		OrganizationVO org = new OrganizationVO();
		org.setId(100077L);
		org.setName(org.getName()+super.CODE);
		org.setNamePath("百世物流|京津冀|河北分公司");
		org.setLockVersion(5);
		org.setTreePath("60000|100075|100077");
		org.setCode(org.getCode()+super.CODE);
		
		AddressVO address = new AddressVO();
		address.setId(117889L);
		
		List<NaturalZoneVO> list1 = new ArrayList<NaturalZoneVO>();
		Long[] ids1 = new Long[]{28786L,28792L,32124L,32143L};
		for(Long id : ids1){
			NaturalZoneVO vo = new NaturalZoneVO();
			vo.setId(id);
			list1.add(vo);
		}
		
		List<CustomerVO> list2 = new ArrayList<CustomerVO>();
		Long[] ids2 = new Long[]{60178L,60189L,60139L};
		for(Long id:ids2){
			CustomerVO vo = new CustomerVO();
			vo.setId(id);
			list2.add(vo);
		}
		
		org.setParentId(100075L);
		return org;
	}
}
