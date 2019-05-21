package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author pangkun
 * @date 2019/2/23 下午3:44
 */
public class Time {
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
