package com.lxk.java8.date;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * LocalDateTime test
 *
 * @author LiXuekai on 2019/9/10
 */
public class LocalDateTimeTest {


    /**
     * 将秒数格式化成日期字符串输出
     */
    @Test
    public void turnSecondsToData() {
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId zoneId = ZoneOffset.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(System.currentTimeMillis() / 1000), zoneId);
        System.out.println(localDateTime.getDayOfMonth());
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(11);
        System.out.println(localDateTime1.format(sf));
        System.out.println(localDateTime1.atZone(zoneId).toEpochSecond());

    }

    /**
     * 由秒数转成Java8时间类操作对象
     */
    @Test
    public void secondToJava8Date() {
        long second = System.currentTimeMillis() / 1000;
        System.out.println(second);
        ZoneId zoneId = ZoneOffset.systemDefault();
        //之所以这么初始化，是因为根据传入的时间进行操作
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(second), zoneId);
        LocalDateTime dateTime = localDateTime.plusDays(-1);
        long second1 = dateTime.atZone(zoneId).toEpochSecond();
        System.out.println(second1);
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(localDateTime.format(sf));
        System.out.println(dateTime.format(sf));

    }

    /**
     * jdk 1.8 中的 LocalDateTime 的使用
     */
    @Test
    public void localDateTimeTest() {
        System.out.println("-----------test java 8 LocalDateTime-----------");
        //当前时间，以秒为单位。
        long epochSecond = System.currentTimeMillis() / 1000L;
        //默认使用系统时区
        ZoneId zoneId = ZoneOffset.systemDefault();
        //之所以这么初始化，是因为根据传入的时间进行操作
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond), zoneId);
        //LocalDateTime.now();//也可以这么获得当前时间
        System.out.println("localDateTime 初始化值：" + localDateTime);
        System.out.println("getYear：" + localDateTime.getYear());
        //方法返回值类型特殊，是枚举类型：Month类型
        System.out.println("getMonth：" + localDateTime.getMonth());
        System.out.println("getDayOfMonth：" + localDateTime.getDayOfMonth());
        System.out.println("getHour：" + localDateTime.getHour());
        System.out.println("getMinute：" + localDateTime.getMinute());
        System.out.println("getSecond：" + localDateTime.getSecond());
        System.out.println("getNano：" + localDateTime.getNano());
        System.out.println("getDayOfWeek：" + localDateTime.getDayOfWeek());

        /*
         * 获得传入时间的某一天的凌晨零分零秒的秒数
         */
        long dayStart = localDateTime.withHour(0).withMinute(0).withSecond(0).atZone(zoneId).toEpochSecond();
        System.out.println("dayStart 时间戳，秒数：" + dayStart);
        /*
         * 获得传入时间的周一的凌晨零分零秒的秒数
         */
        localDateTime = LocalDateTime.of(2017, 12, 2, 0, 0, 0);
        System.out.println("localDateTime 设置当前值：" + localDateTime);
        System.out.println("getDayOfWeek：" + localDateTime.getDayOfWeek());
        System.out.println("getDayOfWeek 的 ordinal 值：" + localDateTime.getDayOfWeek().ordinal());
        System.out.println("getDayOfWeek 的 value 就是周几的值：" + localDateTime.getDayOfWeek().getValue());
        LocalDateTime weekStart = localDateTime.minusDays(localDateTime.getDayOfWeek().ordinal()).withHour(0).withMinute(0).withSecond(0);
        System.out.println("weekStart：" + weekStart);
        /*
         * 获得传入时间的月份的第一天的凌晨零分零秒的秒数
         */
        long monthStart = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).atZone(zoneId).toEpochSecond();
        System.out.println("monthStart 时间戳，秒数：" + monthStart);

        /*
         * 传入时间的年的第一天
         */
        LocalDateTime firstDayOfYear = localDateTime.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("firstDayOfYear：" + firstDayOfYear);

        /*
         * 当前时间，往后推一周的时间。plus   加
         */
        LocalDateTime plusWeeks = localDateTime.plusWeeks(1);
        System.out.println("plus one week：" + plusWeeks);
        /*
         * 当前时间，向前推一周的时间。minus  减
         */
        LocalDateTime minusWeeks = localDateTime.minusWeeks(1);
        System.out.println("minus one week：" + minusWeeks);

        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String startTime = "2016-11-13 23:59";
        localDateTime = LocalDateTime.parse(startTime, sf);
        System.out.println(localDateTime);
        //格式化一下
        System.out.println(localDateTime.format(sf));
    }
}
