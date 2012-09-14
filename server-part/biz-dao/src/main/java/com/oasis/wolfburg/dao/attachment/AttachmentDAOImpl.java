package com.oasis.wolfburg.dao.attachment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.enums.status.AttachmentAssocTable;
import com.oasis.wolfburg.model.attachment.Attachment;

@Repository
public class AttachmentDAOImpl extends BaseDAO<Attachment> implements AttachmentDAO{
	private static final String DELETE_FKID = ".deleteByfkId";
	
	public void deleteByfkId(Long fkId,AttachmentAssocTable attachmentAssocTable){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fkId", fkId);
		map.put("fkTable", attachmentAssocTable);
		super.getSession().delete(getStatementNamespace()+DELETE_FKID,map);
	}
}
