package com.oasis.tmsv5.facade.nzone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.service.nzone.NaturalZoneService;
import com.oasis.tmsv5.common.so.zone.NaturalZoneSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.common.vo.zone.CheckedNaturalZoneTreeVO;
import com.oasis.tmsv5.common.vo.zone.NaturalZoneVO;

@RemotingDestination
@Service
public class NaturalZoneServiceFacade {
	
//    @Autowired
	private NaturalZoneService nzoneService;
	
	public PageList<NaturalZoneVO> getPageList(ClientContext clientContext,NaturalZoneSO so){
		return nzoneService.getPageList(clientContext, so);
	}
	
	public TreeNode getNZoneTree(ClientContext clientContext,NaturalZoneSO so){
	    return nzoneService.getNZoneTreeNode(clientContext,so);
	}
	
	public CheckedNaturalZoneTreeVO getCheckedNaturalZoneByOrg(ClientContext clientContext,Long id){
	   return nzoneService.getCheckedNaturalZoneByOrg(id);
	}
	
	public List<NaturalZoneVO> getNZoneByParent(ClientContext clientContext,Long parent){
	    return nzoneService.getNZoneByParent(clientContext, parent);
	};
}
