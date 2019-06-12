package com.lxk.java8;

import com.lxk.util.TimesUtils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 测试 Java 1.8 日期 API 的使用
 *
 * @author lxk on 2017/12/26
 */
public class DateJava8Test {
    public static void main(String[] args) {
        //java8DateTest();
        //dateTimeFormatterTest();
        //easyTest();
        getBetweenDay();
        //getYMD();
        //secondToJava8Date();

        //turnSecondsToData();
    }

    /**
     * 将秒数格式化成日期字符串输出
     */
    private static void turnSecondsToData() {
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId zoneId = ZoneOffset.systemDefault();
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochSecond(System.currentTimeMillis() / 1000), zoneId).format(sf));
    }

    /**
     * 由秒数转成Java8时间类操作对象
     */
    private static void secondToJava8Date() {
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
     * Date 和 LocalDate 互相转换。
     */
    private static void getYMD() {
        //Date -> LocalDate
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");
        System.out.println(simpleDateFormat.format(date));
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println(localDate);


        //LocalDate ->Date
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date ls = Date.from(zdt.toInstant());
        System.out.println("LocalDate = " + localDate);
        System.out.println("Date = " + simpleDateFormat.format(ls));

        //out format date out
        System.out.println("--------");
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(sf));
    }

    /**
     * 计算两个时间点之间的天数
     */
    private static void getBetweenDay() {
        //阴历，腊月27早上出生🐣，28，29，30。距离过年三天
        LocalDate start = LocalDate.of(2018, 2, 12);
        LocalDate now = LocalDate.now();
        System.out.println("儿子今天是 " + TimesUtils.getBetweenDay(start, now) + " 天啦。");
    }

    /**
     * 日期格式化测试
     yyyy：年
     MM：月
     dd：日
     hh：1~12小时制(1-12)
     HH：24小时制(0-23)
     mm：分
     ss：秒
     S：毫秒
     E：星期几
     D：一年中的第几天
     F：一月中的第几个星期(会把这个月总共过的天数除以7)
     w：一年中的第几个星期
     W：一月中的第几星期(会根据实际情况来算)
     a：上下午标识
     k：和HH差不多，表示一天24小时制(1-24)。
     K：和hh差不多，表示一天12小时制(0-11)。
     z：表示时区
     */
    private static void dateTimeFormatterTest() {
        /*
         * 解析日期
         */
        String dateStr = "2016年10月25日";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        System.out.println(date);

        /*
         * 日期转换为字符串
         */
        LocalDateTime now = LocalDateTime.now();
        System.out.println("未格式化时：" + now);
        //HH 和 hh 的差别：前者是24小时制，后者是12小时制。
        String formatString = "yyyy年MM月dd日 HH:mm:ss:SSS" +
                " 上下午标志 a" +
                " E" +
                " 一年中的第D天" +
                " 一月中的第F个星期" +
                " 一年中的第w个星期" +
                " 一月中的第W个星期";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(formatString);
        System.out.println(now.format(format));
        format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        System.out.println(now.format(format));
        format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        System.out.println(now.format(format));
    }

    private static void easyTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        //把当前时间修改为11月，其他部分不变。
        System.out.println(localDateTime.withMonth(11));
        //最后都变成秒啦，所以，纳秒部分归零与否，已经不影响啦。
        long second = localDateTime.withHour(0).withMinute(0).withSecond(0).atZone(ZoneId.systemDefault()).toEpochSecond();
        System.out.println(second);
        second = localDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0).atZone(ZoneId.systemDefault()).toEpochSecond();
        System.out.println(second);
        //ZoneOffset继承ZoneId，调用的都是一个底层方法。
        // 打印结果：Asia/Shanghai
        System.out.println(ZoneOffset.systemDefault());
        System.out.println(ZoneId.systemDefault());
    }

    /**
     * 在新的Java 8中，日期和时间被明确划分为LocalDate和LocalTime，
     * LocalDate无法包含时间；
     * LocalTime无法包含日期；
     * LocalDateTime才能同时包含日期和时间。
     */
    private static void java8DateTest() {
        localDateTest();
        localTimeTest();
        localDateTimeTest();
    }

    /**
     * jdk 1.8 中的 localDate 的使用
     */
    private static void localDateTest() {
        System.out.println("-----------test java 8 LocalDate-----------");
        LocalDate today = LocalDate.now();
        System.out.println("当前日期：" + today);
        System.out.println("当前日期的年：" + today.getYear());
        //返回的是枚举类型：Month，Java 8  新增的枚举类型
        System.out.println("当前日期的月--枚举类型：" + today.getMonth());
        //这个返回int才是我们常用的月的数字形式。
        //记得以前你学Java的时候，一月的数字是0吗？这不用你自己手动+1啦，自动就是月份对应的数字，1-12.
        System.out.println("当前日期的月--数字类型：" + today.getMonthValue());
        System.out.println("当前日期的日：" + today.getDayOfMonth());
        //返回的是枚举类型：DayOfWeek，Java 8 新增的枚举类型
        System.out.println("当前日期是周几：" + today.getDayOfWeek());
        System.out.println("当前日期是一年之中的第几天：" + today.getDayOfYear());
        //Chronology：翻译为年代学;年表。此处的返回值是 ISO
        System.out.println("年表：" + today.getChronology());

        LocalDate christmas = LocalDate.of(2017, 12, 25);
        System.out.println("christmas：" + christmas);
        //严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        LocalDate endOfDec = LocalDate.parse("2017-12-28");
        System.out.println("endOfDec：" + endOfDec);
        /*
         * 无效日期无法通过：DateTimeParseException: Invalid date
         */
        //LocalDate.parse("2017-02-29");

        System.out.println("当前日期：" + today);
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("当前日期所在的月的第一天：" + firstDayOfMonth);
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("当前日期所在的月的最后一天：" + lastDayOfThisMonth);
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        System.out.println("当前日期所在的月的第二天：" + secondDayOfThisMonth);

        //对日期进行加减 plus minus
        System.out.println("当前日期plus一天：" + today.plusDays(1));
        System.out.println("当前日期minus一天：" + today.minusDays(1));
    }

    /**
     * jdk 1.8 中的 LocalTime 的使用
     */
    private static void localTimeTest() {
        System.out.println("-----------test java 8 LocalTime-----------");
        LocalTime now = LocalTime.now();
        System.out.println("当前时间" + now);
        System.out.println("当前时间：小时--" + now.getHour());
        System.out.println("当前时间：分钟--" + now.getMinute());
        System.out.println("当前时间：秒--" + now.getSecond());
        //纳秒，不是毫秒，是十亿分之一秒。
        System.out.println("当前时间：纳秒--" + now.getNano());
        //清除毫秒数，也就是说，你可以肆意设置时间的任意一个位置的值，使用withXXX()就可以啦。
        System.out.println("当前时间：清空纳秒--" + now.withNano(0));
        System.out.println("当前时间：挨个清零--" + now.withHour(0).withMinute(0).withSecond(0).withNano(0));
    }

    /**
     * jdk 1.8 中的 LocalDateTime 的使用
     */
    private static void localDateTimeTest() {
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
