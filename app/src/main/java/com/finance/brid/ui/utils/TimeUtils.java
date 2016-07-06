package com.finance.brid.ui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2016/5/5.
 */
public class TimeUtils {

    public static String getSysTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    public static long getLongSysTime(){
        Date date = new Date(System.currentTimeMillis());
        return date.getTime();
    }
}
