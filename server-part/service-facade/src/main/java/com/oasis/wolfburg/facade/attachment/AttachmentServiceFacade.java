package com.oasis.wolfburg.facade.attachment;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.util.helper.FileSource;
import com.oasis.tmsv5.util.helper.FileStorageHelper;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;

@RemotingDestination
@Service
public class AttachmentServiceFacade {
	Log log = LogFactory.getLog(AttachmentServiceFacade.class);
	
	public String doUpload(ClientContext clientContext,AttachmentVO vo){
		String res = "";
		ByteArrayInputStream in = new ByteArrayInputStream(vo.getFileBytes());
		
		String storeName = FileStorageHelper.getFileName(vo.getFileType());
		File file = FileStorageHelper.createFile(storeName);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = in.read(bytes))!=-1){
				out.write(bytes,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		res = FileStorageHelper.getDownloadURL(FileSource.ATTACHMENT, storeName);
		log.info(res);
		return res;
	}
}
