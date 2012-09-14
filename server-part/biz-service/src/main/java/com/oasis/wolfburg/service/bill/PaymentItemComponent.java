package com.oasis.wolfburg.service.bill;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.oasis.excelImport.converter.DateExportConverter;
import com.best.oasis.excelImport.converter.ExportConvertUtils;
import com.best.oasis.excelImport.core.ExportHelper;
import com.oasis.tmsv5.common.enums.type.FileType;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.util.web.DateUtils;
import com.oasis.tmsv5.common.util.web.FileManageUtil;
import com.oasis.tmsv5.dao.base.DownloadInfoDAO;
import com.oasis.tmsv5.dao.base.PredefinedCodeDAO;
import com.oasis.tmsv5.model.base.DownloadInfo;
import com.oasis.tmsv5.model.base.PredefinedCode;
import com.oasis.tmsv5.security.ClientContextHolder;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.EnumDispHelper;
import com.oasis.tmsv5.util.exception.ExportException;
import com.oasis.tmsv5.util.helper.FileSource;
import com.oasis.tmsv5.util.helper.FileStorageHelper;
import com.oasis.wolfburg.common.so.bill.PaymentItemSO;
import com.oasis.wolfburg.common.vo.bill.PaymentItemReportVO;
import com.oasis.wolfburg.common.vo.bill.PaymentItemVO;
import com.oasis.wolfburg.dao.bill.PaymentItemDAO;
import com.oasis.wolfburg.model.bill.PaymentItem;

@Service
public class PaymentItemComponent extends BaseComponent {
	@Autowired
	private PaymentItemDAO paymentItemDAO;
	
	@Autowired
	private PredefinedCodeDAO predefinedCodeDAO;
	
	@Autowired
	private DownloadInfoDAO downloadInfoDAO;
	
	public PageList<PaymentItemVO> getPageList(PaymentItemSO so){
		int count = paymentItemDAO.getPaginatedListCount(so);
		List<PaymentItem> paymentItemList = paymentItemDAO.getPaginatedList(so);
		List<PaymentItemVO> list = getDozer().convertList(paymentItemList, PaymentItemVO.class);
		PageList<PaymentItemVO> pageList = new PageList<PaymentItemVO>(so);
		pageList.setFullListSize(count);
		for(PaymentItemVO pi : list){
			if(StringUtils.isNotBlank(pi.getItemType())){
	        	PredefinedCode predefinedCode = predefinedCodeDAO.getCachePredefinedCodeByCode(pi.getItemType());
	        	if(predefinedCode != null){
	        		pi.setItemTypeCN(predefinedCode.getVal());
	        	}
	        }
		}
		pageList.setList(list);
		return pageList;
	}
	
	public PageList<PaymentItemVO> getPageList4Report(PaymentItemSO so){
		int count = paymentItemDAO.getPaginatedListCount4Report(so);
		List<PaymentItem> paymentItemList = paymentItemDAO.getPaginatedList4Report(so);
		List<PaymentItemVO> list = getDozer().convertList(paymentItemList, PaymentItemVO.class);
		PageList<PaymentItemVO> pageList = new PageList<PaymentItemVO>(so);
		pageList.setFullListSize(count);
		for(PaymentItemVO pi : list){
			if(StringUtils.isNotBlank(pi.getItemType())){
	        	PredefinedCode predefinedCode = predefinedCodeDAO.getCachePredefinedCodeByCode(pi.getItemType());
	        	if(predefinedCode != null){
	        		pi.setItemTypeCN(predefinedCode.getVal());
	        	}
	        }
		}
		pageList.setList(list);
		return pageList;
	}
	/**
	 * 关帐
	 * @param so
	 * @return
	 * @throws Exception
	 */
	public String exportToExcel(PaymentItemSO so) throws Exception{
		List<PaymentItemReportVO> paymentItemList = paymentItemDAO.getPaymentItemList4Report(so);
		Map<String,List<?>> dataMap = new HashMap<String,List<?>>();
		dataMap.put("FeeReport", paymentItemList);
		try{
			String strUrl = exportToExcel(dataMap,so.getRequestUrl());
			//存储下载信息
			saveDownlaodInfo(strUrl,so.getBillDateBegin());
			//更新标识
			paymentItemDAO.updateFlag("1",so.getBillDateBegin(),so.getBillDateEnd());
			return strUrl;
		}catch(Exception e){
			throw new ExportException("EXPORT_ERROR");
		}
		
	}
	/**
	 * 导出
	 * @param so
	 * @return
	 * @throws Exception
	 */
	public String export(PaymentItemSO so) throws Exception{
		EnumDispHelper dispHelper = EnumDispHelper.getInstance();
		List<PaymentItem> paymentItemList = paymentItemDAO.getPaymentItemList4Excel(so);
		List<PaymentItemVO> list = getDozer().convertList(paymentItemList, PaymentItemVO.class);
		Map<String,List<?>> dataMap = new HashMap<String,List<?>>();
		
		for(PaymentItemVO pi : list){
			if(StringUtils.isNotBlank(pi.getItemType())){
	        	PredefinedCode predefinedCode = predefinedCodeDAO.getCachePredefinedCodeByCode(pi.getItemType());
	        	if(predefinedCode != null){
	        		pi.setItemTypeCN(predefinedCode.getVal());
	        	}
	        }
			pi.setStrStatus(dispHelper.getValue(pi.getFlag()));
		}
		dataMap.put("PaymentItem", list);
		try{
			String strUrl = export(dataMap,so.getRequestUrl());
			return strUrl;
		}catch(Exception e){
			throw new ExportException("EXPORT_ERROR");
		}
		
	}
	
	private void saveDownlaodInfo(String strUrl,Date time){
		String contextPath = FileStorageHelper.getDownloadContextPath(FileSource.REPORT);
		int nt = strUrl.indexOf(contextPath) + contextPath.length();
		String downloadURL = strUrl.substring(nt);
		String strDay = DateUtils.formatDate(time);
		DownloadInfo downloadInfo = fillDownloadInfo(downloadURL,strDay);
		downloadInfoDAO.insert(downloadInfo);
		
	}
	
	private DownloadInfo fillDownloadInfo(String downloadURL,String strDay){
		DownloadInfo downloadInfo = new DownloadInfo();
		downloadInfo.setPath(downloadURL);
		downloadInfo.setTime(new Date());
		downloadInfo.setFileType(FileType.FEE);
		downloadInfo.setOperator(ClientContextHolder.getContext().getLoginName());
		return downloadInfo;
	}
	
	@SuppressWarnings("unchecked")
	private String export(Map dataMap,String requestUrl) throws Exception {
        String storeName = FileStorageHelper.getFileName(FileStorageHelper.EXCEL_FILE);
		File file = FileStorageHelper.createReportFile(storeName);
        FileManageUtil.makeDirectory(file.getParent());
        String excelFilePath = file.getAbsolutePath();

        File exportFile = new File(excelFilePath);
        if(exportFile.exists()){
        	exportFile.delete();
        }
        ExportHelper helper = new ExportHelper();
        ExportConvertUtils exportConvert = new ExportConvertUtils();
        exportConvert.register(new DateExportConverter(), Date.class);
       // exportConvert.register(new PaymentItemStatusExportConverter(), AreaEnum.class);
        helper.setExportConvert(exportConvert);
        helper.exportXlsFile(dataMap, FileStorageHelper.PAYMENT_TEMPLATE, excelFilePath);
        String res = FileStorageHelper.getDownloadURL(FileSource.REPORT, storeName);
        
        return requestUrl + res;
    }
	
	@SuppressWarnings("unchecked")
	private String exportToExcel(Map dataMap,String requestUrl) throws Exception {
        String storeName = FileStorageHelper.getFileName(FileStorageHelper.EXCEL_FILE);
		File file = FileStorageHelper.createReportFile(storeName);
        FileManageUtil.makeDirectory(file.getParent());
        String excelFilePath = file.getAbsolutePath();

        File exportFile = new File(excelFilePath);
        if(exportFile.exists()){
        	exportFile.delete();
        }
        ExportHelper helper = new ExportHelper();
        ExportConvertUtils exportConvert = new ExportConvertUtils();
        exportConvert.register(new DateExportConverter(), Date.class);
        helper.setExportConvert(exportConvert);

        @SuppressWarnings("unused")
        String path = helper.exportXlsFile(dataMap, FileStorageHelper.FEE_TEMPLATE, excelFilePath);
        String res = FileStorageHelper.getDownloadURL(FileSource.REPORT, storeName);
        
        return requestUrl + res;
    }
	
	public Long createPaymentItem(PaymentItemVO paymentItemVO) {
        PaymentItem paymentItem = super.getDozer().convert(paymentItemVO, PaymentItem.class);
        Long id = paymentItemDAO.insert(paymentItem);
        return id;
    }

    public int deletePaymentItem(Long id) {
        return paymentItemDAO.delete(id);
    }

    public void update(PaymentItemVO paymentItem) {
    	if(paymentItem.getTrsJobCode() == null){
    		paymentItem.setTrsJobCode(StringUtils.EMPTY);
    	}
        paymentItemDAO.update(super.getDozer().convert(paymentItem, PaymentItem.class));
    }

    public void removeByIds(List<Long> ids) {
        paymentItemDAO.deleteByIds(ids);
    }


    public PaymentItemVO find(Long id) {
        PaymentItem po = paymentItemDAO.find(id);
        PaymentItemVO paymentItemVO = super.getDozer().convert(po, PaymentItemVO.class);
        if(StringUtils.isNotBlank(paymentItemVO.getItemType())){
        	PredefinedCode predefinedCode = predefinedCodeDAO.getCachePredefinedCodeByCode(paymentItemVO.getItemType());
        	paymentItemVO.setItemTypeCN(predefinedCode.getVal());
        }
        return paymentItemVO;
    }
	
	
	
}