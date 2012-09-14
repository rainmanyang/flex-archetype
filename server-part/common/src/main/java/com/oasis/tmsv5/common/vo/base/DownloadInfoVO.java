package com.oasis.tmsv5.common.vo.base;

import java.util.Date;

import com.oasis.tmsv5.common.enums.type.FileType;
import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.tmsv5.util.helper.FileStorageHelper;

public class DownloadInfoVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	    
	    /**
     * 文件实际存放路径（包含文件名称）
     */
    private String path;
    
    /**
     * 文件生成时间
     */
    private Date time;
    
    
    /**
     * 操作人
     */
    private String operator;
    
    /**
     * 文件所属类别：费用、运营时效 等
     */
    private FileType fileType;
    
    private final String prefix = FileStorageHelper.getInstance().getValue(FileStorageHelper.FILE_DOWNLOAD_URL);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if(path.startsWith(prefix)){
			this.path = path;
		}else{
			this.path = prefix + path;
		}
		
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}


	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	
    
}
