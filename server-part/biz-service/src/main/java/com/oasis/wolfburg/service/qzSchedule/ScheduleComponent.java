package com.oasis.wolfburg.service.qzSchedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oasis.tmsv5.common.enums.type.JobCommand;
import com.oasis.wolfburg.common.service.qzSchedule.ScheduleService;
import com.oasis.wolfburg.service.qzSchedule.handler.ClientBarcodeScheduleHandler;
import com.oasis.wolfburg.service.qzSchedule.handler.GeneratorShiftScheduleHandler;
import com.oasis.wolfburg.service.qzSchedule.handler.RsJobNotificationHandler;

@Component
public class ScheduleComponent implements ScheduleService {
    @Autowired
    private GeneratorShiftScheduleHandler generatorShiftScheduleHandler;

    @Autowired
    private ClientBarcodeScheduleHandler clientBarcodeScheduleHandler;

    @Autowired
    private RsJobNotificationHandler rsJobNotificationHandler;

    private static final Log logger = LogFactory.getLog(ScheduleComponent.class);

    @Override
    public void processCommand(JobCommand command) {
        logger.info(command);
        
        switch (command) {
        case GENERATOR_SHIFT_SCHEDULE:
            generatorShiftScheduleHandler.handler();
            break;
        case CLIENT_BARCODE_SCHEDULE:
            clientBarcodeScheduleHandler.handle();
            break;
        case RSJOB_NOTIFY:
            rsJobNotificationHandler.handle();
            break;
        }
    }
}
