package com.lxk.util;

/**
 * @author lxk on 2017/9/27
 */
public class PrintUtil {
    public static void divideLine() {
        System.out.println("--------------分界符--------------");
    }

    /**
     * @param a long a=System.currentTimeMillis();
     */
    public static void printRunTime(long a) {
        System.out.println("执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
    }
}
