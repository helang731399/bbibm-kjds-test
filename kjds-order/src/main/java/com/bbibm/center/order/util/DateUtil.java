package com.bbibm.center.order.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    /**
     *
     * @param time  获取Json数据
     * @return   返回LocalDate
     */
    public static LocalDateTime LongToDate(String time){
        if(time==null ||time.equals(""))
        {
            return null;
        }
        Long dateLong=Long.parseLong(time);
        Instant instant = Instant.ofEpochMilli(dateLong);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }


    public static String ExchangeString(String status){
        switch (status)
        {
            case "Unpaid":return "1";
            case "Not delivered":return "2";
            case "Shipped":return "3";
            case "Completed":return "4";
            case "Cancelled":return "5";
            default:return "0";
        }
    }
}
