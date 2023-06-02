package com.cabse.cet.utils;

import java.util.Calendar;
import java.util.UUID;

/**
 * @ClassName: IDGeneration
 * @PackageName:com.cabse.cet.utils
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/2 16:52
 * @Version 1.0.0
 */
public class IDGeneration {
    public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }
    public static Integer getGeneratedID(){
        String orderSeq = Math.abs(UUID.randomUUID().toString().hashCode()) + "";
        while (orderSeq.length() < 6) {
            orderSeq = orderSeq + (int) (Math.random() * 10);
        }
        String id = getSysYear() + orderSeq.substring(0, 6);
        return Integer.parseInt(id);
    }

}
