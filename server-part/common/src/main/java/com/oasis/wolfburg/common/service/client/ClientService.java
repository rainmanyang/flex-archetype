package com.oasis.wolfburg.common.service.client;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.vo.security.AuthenticationVO;
import com.oasis.wolfburg.common.vo.client.ScanBarcode;
import com.oasis.wolfburg.common.vo.client.TruckLocation;
import com.oasis.wolfburg.common.vo.client.WSMessage;

public interface ClientService {

    @WebMethod(operationName = "login")
    public abstract WSMessage login(@WebParam(name = "Authentication") AuthenticationVO clientContext);

    @WebMethod(operationName = "getPOS")
    public abstract WSMessage getPOS(@WebParam(name = "ClientContext") ClientContext clientContext);

    @WebMethod(operationName = "updateTruckLocation")
    public abstract WSMessage updateTruckLocation(@WebParam(name = "ClientContext") ClientContext clientContext,
            @WebParam(name = "TruckLocationList") List<TruckLocation> truckLocationList);

    @WebMethod(operationName = "printWorkOrder")
    public abstract WSMessage printTSTaskOrder(@WebParam(name = "ClientContext") ClientContext clientContext,
            @WebParam(name = "CardCode") String cardCode);

    @WebMethod(operationName = "timeRecordScan")
    public abstract WSMessage timeRecordScan(@WebParam(name = "ClientContext") ClientContext clientContext,
            @WebParam(name = "BarcodeObj") List<ScanBarcode> barcodeList);

    @WebMethod(operationName = "getWolfburgServerTime")
    public abstract WSMessage getServerTime(@WebParam(name = "ClientContext") ClientContext clientContext);

    @WebMethod(operationName = "printTSTaskOrderDone")
    public abstract WSMessage printTSTaskOrderDone(@WebParam(name = "ClientContext") ClientContext clientContext, Long jobId);
    
    @WebMethod(operationName = "getPOSRSJobs")
    public abstract WSMessage getPOSRSJobs(@WebParam(name = "ClientContext") ClientContext clientContext, Long posId);
}
