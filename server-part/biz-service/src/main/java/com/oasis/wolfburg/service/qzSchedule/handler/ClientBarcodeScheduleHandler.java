package com.oasis.wolfburg.service.qzSchedule.handler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.wolfburg.common.enums.status.ClientException;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.type.BarcodeScanType;
import com.oasis.wolfburg.common.enums.type.EventPhase;
import com.oasis.wolfburg.common.enums.type.PaymentItemType;
import com.oasis.wolfburg.common.enums.type.RSJobType;
import com.oasis.wolfburg.dao.bill.PaymentItemDAO;
import com.oasis.wolfburg.dao.price.PriceDAO;
import com.oasis.wolfburg.dao.route.PosDAO;
import com.oasis.wolfburg.dao.route.StopDAO;
import com.oasis.wolfburg.dao.trackRecord.TrackRecordDAO;
import com.oasis.wolfburg.dao.truck.TruckDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.ClientBarcodeRecordDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobTimeRecordDAO;
import com.oasis.wolfburg.model.bill.PaymentItem;
import com.oasis.wolfburg.model.price.Price;
import com.oasis.wolfburg.model.route.POS;
import com.oasis.wolfburg.model.route.Stop;
import com.oasis.wolfburg.model.trackRecord.TrackRecord;
import com.oasis.wolfburg.model.truck.Truck;
import com.oasis.wolfburg.model.truckRSSchedule.ClientBarcodeRecord;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJob;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJobTimeRecord;
import com.oasis.wolfburg.service.trackrecord.TrackRecordHelper;

@Component
public class ClientBarcodeScheduleHandler extends BaseComponent {
    @Autowired
    private TruckRSJobDAO truckRSJobDAO;

    @Autowired
    private TruckRSJobTimeRecordDAO truckRSJobTimeRecordDAO;

    @Autowired
    private ClientBarcodeRecordDAO clientBarcodeRecordDAO;

    @Autowired
    private StopDAO stopDAO;

    @Autowired
    private TrackRecordDAO TrackRecordDAO;

    @Autowired
    private TruckDAO truckDAO;

    @Autowired
    private PriceDAO priceDAO;

    @Autowired
    private PaymentItemDAO paymentItemDAO;

    @Autowired
    private PosDAO posDAO;

    private static final Log logger = LogFactory.getLog(ClientBarcodeScheduleHandler.class);

    public synchronized void handle() {
        /**
         * To get processing ClientBarcodeRecord
         */
        List<ClientBarcodeRecord> processingCBRs = clientBarcodeRecordDAO.getProcessingClientBarcodeRecord();
        List<ClientBarcodeRecord> processedCBRs = new ArrayList<ClientBarcodeRecord>();

        for (ClientBarcodeRecord processingCBR : processingCBRs) {
            TruckRSJobTimeRecord timeRecord = truckRSJobTimeRecordDAO.getTruckRSJobTimeRecordByBarcode(processingCBR);
            ClientBarcodeRecord processedCBR = null;
            if (timeRecord != null) {
                /**
                 * 扫描
                 */
                processedCBR = processScannedBarcode(processingCBR, timeRecord, BarcodeScanType.SCAN);
                processedCBRs.add(processedCBR);

            } else {
                timeRecord = truckRSJobTimeRecordDAO.getTruckRSJobTimeRecordByPinCode(processingCBR);
                if (timeRecord != null) {
                    /**
                     * 手动输入
                     */
                    processedCBR = processScannedBarcode(processingCBR, timeRecord, BarcodeScanType.MANUAL);
                    processedCBRs.add(processedCBR);
                }
            }
            if (processedCBR == null) {
                processingCBR.setPrecessedResult(ClientException.JOB_NOT_FOUND);
                processedCBRs.add(processingCBR);
            }

        }

        /**
         * update ClientBarcodeRecord to be processed.
         */
        for (ClientBarcodeRecord clientBarcodeRecord : processedCBRs) {
            clientBarcodeRecord.setProcessed(Boolean.TRUE);
            clientBarcodeRecord.setProcessedTime(Calendar.getInstance().getTime());
            clientBarcodeRecordDAO.update(clientBarcodeRecord);
        }

    }

    private ClientBarcodeRecord processScannedBarcode(ClientBarcodeRecord barcode, TruckRSJobTimeRecord trtRecord,
            BarcodeScanType inputType) {
        Date scanTime = getScanTime(barcode);
        if (trtRecord.getScanedTime() != null) {
            barcode.setPrecessedResult(ClientException.REPEAT_SCAN);
            return barcode;
        }
        TruckRSJob trsJob = truckRSJobDAO.find(trtRecord.getTrsJobId());
        List<Stop> stops = stopDAO.getStopsByRoute(trsJob.getRouteId());
        /**
         * 第一站进站数据被丢弃
         */
        if (trtRecord.getStopId().equals(stops.get(0).getId()) && trtRecord.getScanType() == EventPhase.INBOUND.value()) {
            barcode.setPrecessedResult(ClientException.FIRST_STOP_INBOUND);
            return barcode;
        }
        /**
         * 最后一站出站数据被丢弃
         */
        if (trtRecord.getStopId().equals(stops.get(stops.size() - 1).getId())
                && trtRecord.getScanType() == EventPhase.OUTBOUND.value()) {
            barcode.setPrecessedResult(ClientException.LAST_STOP_OUTBOUND);
            return barcode;
        }

        trtRecord.setScanedTime(scanTime);
        trtRecord.setScanner(barcode.getScanner());
        trtRecord.setScanType(barcode.getScanType());
        trtRecord.setInputType(inputType.value());

        trtRecord = truckRSJobTimeRecordDAO.update(trtRecord);
        /**
         * 记录logging 信息
         */
        POS pos = posDAO.find(barcode.getPosId());
        TrackRecord tr = TrackRecordHelper.logScannedBarcode(pos, trtRecord);
        TrackRecordDAO.insert(tr);

        /**
         * 更新TruckRSJob 状态
         */
        updateTruckRSJobStatus(stops, trsJob, trtRecord);

        return barcode;

    }

    private void updateTruckRSJobStatus(List<Stop> stops, TruckRSJob trsJob, TruckRSJobTimeRecord trtRecord) {
        
        /**
         * 终点站进站
         */
        if (trtRecord.getStopId().equals(stops.get(stops.size() - 1).getId())
                && trtRecord.getScanType() == EventPhase.INBOUND.value()) {
            if (RSJobStatus.ARRIEVED != trsJob.getStatus()) {
                /**
                 * 1. 更新任务单状态至 ARRIEVED
                 */
                trsJob.setStatus(RSJobStatus.ARRIEVED);
                trsJob = truckRSJobDAO.update(trsJob);
                /**
                 * 2. 更新车辆运行状态至 FREE
                 */
                Truck truck = truckDAO.find(trsJob.getTruckId());
                if (TruckRunningStatus.FREE != truck.getRunningStatus()) {
                    truck.setRunningStatus(TruckRunningStatus.FREE);
                    truckDAO.update(truck);
                }
                /**
                 * 3. 插入应付费用到 PaymentItem
                 */
                insertPaymentItem(trsJob, truck);
                return;
            }
        }
        
        /**
         * 只要有合法扫描数据进来，表示在途
         */
        if (RSJobStatus.PLANED == trsJob.getStatus() || RSJobStatus.DISPATCHED == trsJob.getStatus()) {
            trsJob.setStatus(RSJobStatus.ENROUTE);
            truckRSJobDAO.update(trsJob);

            Truck truck = truckDAO.find(trsJob.getTruckId());
            if (TruckRunningStatus.ENROUTE != truck.getRunningStatus()) {
                truck.setRunningStatus(TruckRunningStatus.ENROUTE);
                truckDAO.update(truck);
            }

            return;
        }

      

    }

    private void insertPaymentItem(TruckRSJob trsJob, Truck truck) {
        Price price = priceDAO.getPrice4TrsJob(trsJob.getRouteId(), truck.getTruckType(), truck.getTruckLevel());
        if (price == null) {
            logger.error("Can't find one price for JOB=" + trsJob.getId());
            return;
        }
        PaymentItem pi = new PaymentItem();
        pi.setTrsJobCode(trsJob.getCode());
        pi.setTruckId(trsJob.getTruckId());
        pi.setBillDate(new Date());
        pi.setLicensePlate(trsJob.getLicensePlate());

        if (trsJob.getRsJobType() == RSJobType.REGULAR) {
            pi.setAmount(price.getPrice());
            pi.setItemType(PaymentItemType.CONTRACK_PRICE.getPrdCode());
        }
        if (trsJob.getRsJobType() == RSJobType.EMERGENCY) {
            pi.setAmount(price.getOvertimePrice());
            pi.setItemType(PaymentItemType.OVERTIME_PRICE.getPrdCode());
        }

        pi.setPriceCode(String.valueOf(price.getId()));

        paymentItemDAO.insert(pi);

    }

    private Date getScanTime(ClientBarcodeRecord barcode) {
        Date scanTime = barcode.getScanTime();
        if (!barcode.isOnline()) {
            Long mTime = barcode.getScanTime().getTime()
                    + (barcode.getServerTime().getTime() - barcode.getOfflineUploadTime().getTime());
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(mTime);
            scanTime = cal.getTime();
        }
        return scanTime;
    }
}