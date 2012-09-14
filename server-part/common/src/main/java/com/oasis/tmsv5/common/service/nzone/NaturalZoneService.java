package com.oasis.tmsv5.common.service.nzone;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.so.zone.NaturalZoneSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.common.vo.zone.CheckedNaturalZoneTreeVO;
import com.oasis.tmsv5.common.vo.zone.NaturalZoneVO;

public interface NaturalZoneService {
	PageList<NaturalZoneVO> getPageList(ClientContext clientContext,NaturalZoneSO so);
	
	TreeNode getNZoneTreeNode(ClientContext clientContext,NaturalZoneSO so);
	
	CheckedNaturalZoneTreeVO getCheckedNaturalZoneByOrg(Long id);
	
	List<NaturalZoneVO> getNZoneByParent(ClientContext clientContext, Long parent);
}
