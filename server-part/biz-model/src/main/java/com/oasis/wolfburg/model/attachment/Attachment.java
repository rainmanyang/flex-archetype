package com.oasis.wolfburg.model.attachment;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.wolfburg.common.enums.status.AttachmentAssocTable;

@Table(name = "wl_attachment")
@SequenceGenerator(name = "wl_attachment_seq")

public class Attachment extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String url;
	
	@Column(name="cert_type")
	private String type;
	
	private AttachmentAssocTable fkTable;
	
	private Long fkId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AttachmentAssocTable getFkTable() {
		return fkTable;
	}

	public void setFkTable(AttachmentAssocTable fkTable) {
		this.fkTable = fkTable;
	}

	public Long getFkId() {
		return fkId;
	}

	public void setFkId(Long fkId) {
		this.fkId = fkId;
	}
}
