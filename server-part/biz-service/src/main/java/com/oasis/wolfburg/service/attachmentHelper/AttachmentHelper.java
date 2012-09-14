package com.oasis.wolfburg.service.attachmentHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.wolfburg.common.enums.status.AttachmentAssocTable;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;
import com.oasis.wolfburg.dao.attachment.AttachmentDAO;
import com.oasis.wolfburg.model.attachment.Attachment;

@Service
public class AttachmentHelper extends BaseComponent{
	@Autowired
	private AttachmentDAO AttachmentDAO;
	
	/**
	 * @desp 插入图片记录
	 */
	public void insert(List<AttachmentVO> list,Long fkId,AttachmentAssocTable attachmentAssocTable){
		List<Attachment> AttachmentList = super.getDozer().convertList(list, Attachment.class);
		for(Attachment Attachment:AttachmentList){
			Attachment.setFkId(fkId);
			Attachment.setFkTable(attachmentAssocTable);
		}
		AttachmentDAO.batchInsert(AttachmentList);
	}
	
	/**
	 * @desp 图片记录,先删后插入
	 */
	public void edit(List<AttachmentVO> list,Long fkId,AttachmentAssocTable attachmentAssocTable){
		AttachmentDAO.deleteByfkId(fkId,attachmentAssocTable);
		List<Attachment> AttachmentList = super.getDozer().convertList(list, Attachment.class);
		for(Attachment Attachment:AttachmentList){
			Attachment.setFkId(fkId);
			Attachment.setFkTable(attachmentAssocTable);
		}
		AttachmentDAO.batchInsert(AttachmentList);
	}
	
	public List<AttachmentVO> getList(Long fkId,AttachmentAssocTable attachmentAssocTable){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fkId", fkId);
		map.put("fkTable", attachmentAssocTable);
		List<Attachment> list = AttachmentDAO.getQueryList(map);
		return super.getDozer().convertList(list, AttachmentVO.class);
	}
}
