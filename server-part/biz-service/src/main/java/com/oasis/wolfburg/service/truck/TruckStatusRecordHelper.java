package com.oasis.wolfburg.service.truck;

import java.util.Date;

import com.oasis.tmsv5.security.ClientContextHolder;
import com.oasis.tmsv5.service.helper.ResourceDispHelper;
import com.oasis.wolfburg.model.truck.Truck;
import com.oasis.wolfburg.model.truck.TruckStatusRecord;

public class TruckStatusRecordHelper {

	public static final String RESOURCE_TYPE_UPDATED = "RESOURCE_TYPE_UPDATED";

	public static final String RUNNING_STATUS_UPDATED = "RUNNING_STATUS_UPDATED";
    
	public static final String TRUCK_STATUS_UPDATED = "TRUCK_STATUS_UPDATED";

	public static final String TRUCK_CREATED = "TRUCK_CREATED";
	
	public static final String TRUCK_UPDATED = "TRUCK_UPDATED";
	
	public static final String CHANGE_TRUCK = "CHANGE_TRUCK";
    
    public static TruckStatusRecord logStatusRecored(Truck truck,String status,String desc) {

        TruckStatusRecord truckStatusRecord = new TruckStatusRecord();
        truckStatusRecord.setExecuteDate(new Date());
        truckStatusRecord.setLicensePlate(truck.getLicensePlate());
        truckStatusRecord.setRunningStatus(truck.getRunningStatus());
        truckStatusRecord.setResourceType(truck.getResourceType());
        truckStatusRecord.setTruckStatus(truck.getStatus());
        truckStatusRecord.setUpdatePerson(ClientContextHolder.getContext().getLoginName());
        if (desc == null || desc.isEmpty()) {
        	truckStatusRecord.setReason(ResourceDispHelper.getInstance().getValue(status));
        } else {
        	truckStatusRecord.setReason(desc);
        }
        return truckStatusRecord;
    }   
}
