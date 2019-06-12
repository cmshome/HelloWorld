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
        testIntelliJIdeaSVNBack();
        //年月日时分秒毫秒，上下午标志
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS a");
        String s = LocalDateTime.now().format(format);
        long a = System.currentTimeMillis();
        //这里放需要测试执行时间的代码段。
        System.out.println(s + "   执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
    }

    /**
     * 测试使用IntelliJ IDEA 将某个文件回退到之前提交的某个版本
     */
    private static void testIntelliJIdeaSVNBack() {

    }
}
