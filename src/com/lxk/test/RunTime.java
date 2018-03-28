package com.lxk.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * java测试代码段执行时间
 *
 * @author lxk on 2018/3/28
 */
public class RunTime {
    public static void main(String[] args) {
        //年月日时分秒毫秒，上下午标志
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS a");
        String s = LocalDateTime.now().format(format);
        long a = System.currentTimeMillis();
        //这里放需要测试执行时间的代码段。
        System.out.println(s + "执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
    }
}
