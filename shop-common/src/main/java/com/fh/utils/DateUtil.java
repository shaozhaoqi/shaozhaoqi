package com.fh.utils;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil  implements Serializable {

    public static final String Y_M_D = "yyyy-MM-dd";
    public static final String FULL_YEAC = "yyyy-MM-dd HH:mm:ss";

    public static String date2str(Date date, String pattern) {
        if (date==null){
            return "";
        }
        SimpleDateFormat sim = new SimpleDateFormat(pattern);
        String result = sim.format(date);
        return result;
    }

    public static Date str2date(String str,String pattern){
        if (StringUtils.isEmpty(str)){
            return null;
        }
        SimpleDateFormat sim = new SimpleDateFormat(pattern);
        Date result=null;
        try {
           result = sim.parse(str);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
