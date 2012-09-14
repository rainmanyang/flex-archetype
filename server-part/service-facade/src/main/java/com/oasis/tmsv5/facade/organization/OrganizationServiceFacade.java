package com.oasis.tmsv5.facade.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.service.organization.OrganizationService;
import com.oasis.tmsv5.common.so.security.OrganizationSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.common.vo.orgnization.OrganizationVO;

@RemotingDestination
@Service
public class OrganizationServiceFacade {
//	@Autowired
	private OrganizationService organizationService;
	
	public PageList<OrganizationVO> getPageList(ClientContext clientContext,OrganizationSO so){
		return organizationService.getPageList(clientContext, so);
	}
	
	public OrganizationVO update(ClientContext clientContext,OrganizationVO orgvo){
	    return organizationService.update(clientContext, orgvo);
	}
	
	public OrganizationVO view(ClientContext clientContext,Long id){
		return organizationService.view(clientContext, id);
	}
	
	public TreeNode getOrgTree(ClientContext clientContext,String condition){
	    return organizationService.getOrgTree(clientContext,condition);
	}
	
	public void remove(ClientContext clientContext,Long id){
	    organizationService.remove(clientContext, id);
	}
	
	public void create(ClientContext clientContext,OrganizationVO vo){
	    /*ArrayList<CustomerVO> customs = new ArrayList<CustomerVO>();
	    for(CustomerVO elm:vo.getCustomers()){
	        customs.add((CustomerVO)elm);
	    }
	    vo.setCustomers(customs);*/
	    organizationService.createOrganization(clientContext, vo);
	}
	
	public OrganizationVO find(ClientContext clientContext,Long id){
	   return organizationService.find(clientContext, id);
	}
}
