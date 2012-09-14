package com.oasis.wolfburg.service.route;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.base.Constants;
import com.oasis.wolfburg.common.vo.route.StopVO;
import com.oasis.wolfburg.dao.route.StopDAO;

@Service
public class StopHelper {
    @Autowired
    private StopDAO stopDAO;

    public List<StopVO> getStopsByStr(String stopPlanTime, Date date) {
        Calendar cal = Calendar.getInstance();
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<StopVO> stops = new ArrayList<StopVO>();
        String[] arrs = stopPlanTime.split(Constants.SEMICOLON);
        for (String str : arrs) {
            String[] strs = str.split(Constants.UNDERLINE);
            StopVO stop = new StopVO();
            Long id = Long.valueOf(strs[0]);
            stop.setId(id);
            stop.setSeqNum(Integer.valueOf(strs[1]));

            String arrival = StringUtils.EMPTY;
            String leave = StringUtils.EMPTY;

            String str2 = strs[2];
            if (!str2.equals(Constants.X)) {
                cal.setTime(date);
                cal.add(Calendar.DAY_OF_YEAR, Integer.valueOf(str2));
                arrival += df1.format(cal.getTime()) + Constants.BLNANK + strs[3];
            }

            String str4 = strs[4];
            if (!str4.equals(Constants.X)) {
                cal.setTime(date);
                cal.add(Calendar.DAY_OF_YEAR, Integer.valueOf(str4));
                leave += df1.format(cal.getTime()) + Constants.BLNANK + strs[5];
            }

            try {
                if (!StringUtils.isEmpty(arrival)) {
                    stop.setPlanInboundTime(df.parse(arrival));
                }
                if (!StringUtils.isEmpty(leave)) {
                    stop.setPlanOutboundTime(df.parse(leave));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            stop.setPosId(Long.valueOf(strs[6]));

            String posName = stopDAO.find(id).getPosName();
            stop.setPosName(posName);
            stops.add(stop);
        }
        /**
         * order by asc
         */
        Collections.sort(stops, new StopVO());
        
        return stops;
    }
}
