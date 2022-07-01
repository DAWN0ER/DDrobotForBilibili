package com.dawn.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    private final static long YEAR = 1000 * 60 * 60 * 24 * 365L;
    private final static long MONTH = 1000 * 60 * 60 * 24 * 30L;
    private final static long DAY = 1000 * 60 * 60 * 24L;
    private final static long HOUR = 1000 * 60 * 60L;
    private final static long MINUTE = 1000 * 60L;
    private final static long SECOND = 1000L;

    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String dateToStr(Date date){
        return format.format(date);
    }

    public Date strToDate(String str) throws ParseException {
        return format.parse(str);
    }

    public String natureTime(Date date){
        if(date==null) return "好久";
        Date now = new Date();
        long between = now.getTime() - date.getTime();
        if (between > YEAR){
            return ((between - YEAR) / YEAR + 1) + "年";
        }
        if (between > MONTH){
            return ((between - MONTH) / MONTH + 1) + "月";
        }
        if (between > DAY){
            return ((between - DAY) / DAY + 1) + "天";
        }
        if (between > HOUR){
            return ((between - HOUR) / HOUR + 1) + "小时";
        }
        if (between > MINUTE){
            return ((between - MINUTE) / MINUTE + 1) + "分钟";
        }else{
            return ((between-SECOND)/SECOND + 1) + "秒";
        }
    }



}
