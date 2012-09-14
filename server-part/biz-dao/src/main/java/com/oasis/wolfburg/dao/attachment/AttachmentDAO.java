package com.oasis.wolfburg.dao.attachment;

import com.oasis.tmsv5.dao.DAO;
import com.oasis.wolfburg.common.enums.status.AttachmentAssocTable;
import com.oasis.wolfburg.model.attachment.Attachment;

public interface AttachmentDAO extends DAO<Attachment> {
	void deleteByfkId(Long fkId,AttachmentAssocTable attachmentAssocTable);
}
