package com.lxk.commonTest;

/**
 * 常用方法测试
 *
 * @author lxk on 2017/7/14
 */
public class MathTest {
    public static void main(String[] args) {
        //testPow();
        //testAbs();
        //testSqrt();
        //testCeilFloor();
        testSpecial();
    }

    private static void testSpecial() {
        int a = 7;
        // >>：带符号右移。正数右移高位补0，负数右移高位补1。比如：4 >> 1，结果是2；-4 >> 1，结果是-2。-2 >> 1，结果是-1。
        // >>>：无符号右移。无论是正数还是负数，高位通通补0。
        //对于正数而言，>>和>>>没区别。
        //对于负数而言，-2 >>> 1，结果是2147483647（Integer.MAX_VALUE），-1 >>> 1，结果是2147483647（Integer.MAX_VALUE）。
        System.out.println(Integer.toBinaryString(a));
        a = a << 1;
        System.out.println("a << 1：" + a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println("a >>> 1：" + (a >>> 1));
    }

    /**
     * 四舍五入，向上向下取整。
     */
    private static void testCeilFloor() {
        //13.0
        System.out.println(Math.ceil(12.4));
        //12.0
        System.out.println(Math.floor(12.4));
        //12
        System.out.println(Math.round(12.4));
        //13
        System.out.println(Math.round(12.5));
    }

    /**
     * 开方，注意，返回是double。
     */
    private static void testSqrt() {
        //4.0
        System.out.println(Math.sqrt(16));
    }

    /**
     * 绝对值
     */
    private static void testAbs() {
        //int, long, float, double
        //1
        System.out.println(Math.abs(-1));
    }

    /**
     * 平方，注意，返回是double。
     */
    private static void testPow() {
        //结果是：1000.0
        System.out.println(Math.pow(10, 3));
    }


}
