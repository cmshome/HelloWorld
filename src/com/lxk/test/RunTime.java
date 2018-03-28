package com.lxk.test;

/**
 * java测试代码段执行时间
 *
 * @author lxk on 2018/3/28
 */
public class RunTime {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        //这里放需要测试执行时间的代码段。
        System.out.println("执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
    }
}
