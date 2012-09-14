package com.oasis.wolfburg.service.truckRSSchedule;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.best.oasis.excelImport.converter.DateExportConverter;
import com.best.oasis.excelImport.converter.ExportConvertUtils;
import com.best.oasis.excelImport.core.ExportHelper;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.util.web.FileManageUtil;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.util.exception.ExportException;
import com.oasis.tmsv5.util.helper.FileSource;
import com.oasis.tmsv5.util.helper.FileStorageHelper;
import com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobTimeRecordSO;
import com.oasis.wolfburg.common.vo.client.ScanBarcode;
import com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobTimeRecordVO;
import com.oasis.wolfburg.dao.truckRSSchedule.ClientBarcodeRecordDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobTimeRecordDAO;
import com.oasis.wolfburg.model.truckRSSchedule.ClientBarcodeRecord;

@Component
public class TruckRSJobTimeRecordComponent extends BaseComponent {
    @Autowired
    private TruckRSJobTimeRecordDAO truckRSJobTimeRecordDAO;

    @Autowired
    private ClientBarcodeRecordDAO clientBarcodeRecordDAO;

    public boolean timeRecordScan(List<ScanBarcode> barcodeList) {
        /**
         *process barCode
         */
        batchTimeRecordScan(barcodeList);
        return true;
    }

    private boolean batchTimeRecordScan(List<ScanBarcode> barcodeList) {
        List<ClientBarcodeRecord> list = super.dozer.convertList(barcodeList, ClientBarcodeRecord.class);
        for (ClientBarcodeRecord cbr : list) {
            cbr.setServerTime(new Date());
        }
        clientBarcodeRecordDAO.batchInsert(list);
        return true;

    }

    /**
     * 分页查询
     * 
     * @param so
     * @return
     */
    public PageList<TruckRSJobTimeRecordVO> getPageList(TruckRSJobTimeRecordSO so) {
        List<TruckRSJobTimeRecordVO> truckRSJobTimeRecordList = truckRSJobTimeRecordDAO.getPaginatedList(so);
        int cnt = truckRSJobTimeRecordDAO.getPaginatedListCount(so);
        PageList<TruckRSJobTimeRecordVO> page = new PageList<TruckRSJobTimeRecordVO>();
        page.setList(truckRSJobTimeRecordList);
        page.setFullListSize(cnt);

		return page;
	}
	
	@SuppressWarnings("unchecked")
	private String exportToExcel(Map dataMap,String requestUrl) throws Exception {
		/**
		 * reviewer:‘xls’ ‘Template_OperationTimeRecord_Export.xml’ 可以放入资源文件 
		 */
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

        helper.exportXlsFile(dataMap, FileStorageHelper.OPTIMERECORD_TEMPLATE, excelFilePath);
        String res = FileStorageHelper.getDownloadURL(FileSource.REPORT, storeName);
        return requestUrl + res;
    }

	
	public String exportToExcel(TruckRSJobTimeRecordSO so) throws Exception{
		List<TruckRSJobTimeRecordVO> truckRSJobTimeRecordList = truckRSJobTimeRecordDAO.getTruckRSJobTimeRecordList4Report(so);
		Map<String,List<?>> dataMap = new HashMap<String,List<?>>();
		dataMap.put("TruckRSJobTimeRecord", truckRSJobTimeRecordList);
		try{
			return exportToExcel(dataMap,so.getRequestUrl());
		}catch(Exception e){
			throw new ExportException("EXPORT_ERROR");
		}
		
	}
}
