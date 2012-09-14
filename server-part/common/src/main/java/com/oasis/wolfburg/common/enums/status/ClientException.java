package com.oasis.wolfburg.common.enums.status;

import com.oasis.tmsv5.util.exception.GLException;

public class ClientException extends GLException {

    private static final long serialVersionUID = 3278755567867691567L;

    public static final String REPEAT_SCAN = "repeat_scan";
    
    public static final String JOB_NOT_FOUND = "job_not_found";
    
    public static final String FIRST_STOP_INBOUND = "first_stop_inboud";
    
    public static final String LAST_STOP_OUTBOUND = "last_stop_inboud";

}
