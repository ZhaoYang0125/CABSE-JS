package com.cabse.cet.utils;

import java.util.Calendar;

/**
 * @ClassName: CurrentDate
 * @PackageName:com.cabse.cet.utils
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/27 22:15
 * @Version 1.0.0
 */
public class CurrentDate {
    public static String getTestDate(){
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        String month = String.valueOf(date.get(Calendar.MONTH));
        if (Integer.parseInt(month) <= 6){
            month = "06";
        }else{
            month = "12";
        }
        return year+month;
    }
}
