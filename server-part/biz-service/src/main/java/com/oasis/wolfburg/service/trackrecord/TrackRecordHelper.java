package com.oasis.wolfburg.service.trackrecord;

import java.util.Date;

import com.oasis.tmsv5.common.base.Constants;
import com.oasis.tmsv5.service.helper.EnumDispHelper;
import com.oasis.tmsv5.service.helper.ResourceDispHelper;
import com.oasis.tmsv5.util.tools.DateGen;
import com.oasis.wolfburg.common.enums.type.BarcodeScanType;
import com.oasis.wolfburg.common.enums.type.EventPhase;
import com.oasis.wolfburg.model.route.POS;
import com.oasis.wolfburg.model.trackRecord.TrackRecord;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJob;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJobTimeRecord;

public class TrackRecordHelper {

    private static final String KEY_SCAN = "SCAN";

    private static final String KEY_MANUL = "MANUL";
    
    private static final String CHANGE_TRUCK = "CHANGE_TRUCK";
    
    private static final String ASSIGN_TRUCK = "ASSIGN_TRUCK";
    
    private static final String TERMINATE = "TERMINATE";
    
    private static final String PUBLISH = "PUBLISH";

    public static TrackRecord logScannedBarcode(POS pos, TruckRSJobTimeRecord trtRecord) {
        TrackRecord tr = new TrackRecord();
        tr.setTruckRsJobId(trtRecord.getTrsJobId());
        String scaner = null;
        if (trtRecord.getScanType()==EventPhase.INBOUND.value()) {
            tr.setEventPhase(EventPhase.INBOUND);            
        }
        if (trtRecord.getScanType()==EventPhase.OUTBOUND.value()) {
            tr.setEventPhase(EventPhase.OUTBOUND);           
        }
        tr.setEventTime(trtRecord.getScanedTime());
        scaner = trtRecord.getScanner();
        StringBuilder description = new StringBuilder();
        description.append(pos.getName());
        description.append(Constants.BLNANK);
        description.append(DateGen.getStringDateByFormat(tr.getEventTime(), "HH:mm"));
        description.append(Constants.BLNANK);
        description.append(scaner);
        description.append(Constants.BLNANK);
        if(BarcodeScanType.SCAN.value()==trtRecord.getInputType()){
            description.append(EnumDispHelper.getInstance().getValue(KEY_SCAN));
        }
        if(BarcodeScanType.MANUAL.value()==trtRecord.getInputType()){
            description.append(EnumDispHelper.getInstance().getValue(KEY_MANUL));
        }
        tr.setDescription(description.toString());
        return tr;
    }   
    
    public static TrackRecord logTrackRecord(TruckRSJob rsJob, EventPhase event) {
    	TrackRecord tr = new TrackRecord();
    	tr.setEventTime(new Date());
    	tr.setTruckRsJobId(rsJob.getId());
    	switch(event) {
	    	case CHANGEVECHICLE:{
	    		tr.setEventPhase(EventPhase.CHANGEVECHICLE);
			    tr.setDescription(ResourceDispHelper.getInstance().getValue(CHANGE_TRUCK) + rsJob.getLicensePlate());
			    break;
	    	}
	    	case ASSIGNVECHICLE:{
	    		tr.setEventPhase(EventPhase.ASSIGNVECHICLE);
				tr.setDescription(ResourceDispHelper.getInstance().getValue(ASSIGN_TRUCK) + rsJob.getLicensePlate());
				break;
	    	}
	    	case TERMINATE:{
	    		tr.setEventPhase(EventPhase.TERMINATE);
				tr.setDescription(rsJob.getCode() + ResourceDispHelper.getInstance().getValue(TERMINATE));
				break;
	    	}
	    	case PUBLISH:{
	    		tr.setEventPhase(EventPhase.PUBLISH);
		        tr.setDescription(rsJob.getCode() + ResourceDispHelper.getInstance().getValue(PUBLISH));
		        break;
	    	}
    	}
        return tr;
    }   

}
