package com.lxk.formatTest;

import com.lxk.util.TimesUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期格式化测试
 * <p>
 * @author lxk on 2016/11/4
 */
public class DateFormat {
    public static void main(String[] args) {

        Long currentFrom = TimesUtils.getTimeForDay();
        long nowDate = Calendar.getInstance().getTimeInMillis();
        //result.put("date", nowDate);//服务器时间 1478793600
        long minute = (nowDate / 1000 - currentFrom) / 60;

        Date s = new Date();
        //System.out.println(minute);

        String date = "2016-12-07T16:00:00.000Z";
        date = date.replace("Z", " UTC");//注意在 UTC 字符串前面还有个空格。不然异常。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        try {
            Date d = sdf.parse(date);
            System.out.println("Z日期: " + d);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //dateTest();

        //Calendar aw = Calendar.getInstance();//获得时间的另一种方式，测试效果一样
        //System.out.println(aw.getTime().getTime());
        //BigDecimal bd = new BigDecimal(11.11922);
        //1478656368669
        //1478793600000
        //1478793600000
        //Double totalBytes = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //System.out.println(totalBytes);
    }

    private static void dateTest() {
        Date ss = new Date();
        System.out.println("一般日期输出：" + ss);
        System.out.println("时间戳：" + ss.getTime());
        //Date aw = Calendar.getInstance().getTime();//获得时间的另一种方式，测试效果一样
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(ss.getTime());//这个就是把时间戳经过处理得到期望格式的时间
        System.out.println("格式化结果0：" + time);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        time = format1.format(ss.getTime());
        System.out.println("格式化结果1：" + time);
    }

}
