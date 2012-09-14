package com.oasis.wolfburg.common.vo.attachment;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.tmsv5.util.helper.FileStorageHelper;
import com.oasis.wolfburg.common.enums.status.AttachmentAssocTable;

public class AttachmentVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String url;//对应PO
	
	private String fileUrl;//对应flex
	
	private String type;
	
	private AttachmentAssocTable fkTable;
	
	private Long fkId;
	
	private String fileType;
	
	private byte[] fileBytes;
	
	private final String prefix = FileStorageHelper.getInstance().getValue(FileStorageHelper.FILE_DOWNLOAD_URL);

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
		
		if(fileUrl.startsWith(prefix)){
			this.url = fileUrl.substring(prefix.length());
		}
	}
	
	public void setUrl(String url) {
		this.url = url;
		
		this.fileUrl = prefix + this.url;
		int dex = url.lastIndexOf(".");
		this.fileType = url.substring(dex+1).toUpperCase();
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	public String getUrl() {
		return url;
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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
