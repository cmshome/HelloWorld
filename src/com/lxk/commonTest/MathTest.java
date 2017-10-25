package com.lxk.commonTest;

/**
 * 常用方法测试
 * <p>
 * @author lxk on 2017/7/14
 */
public class MathTest {
    public static void main(String[] args) {
        testPow();//平方
        testAbs();//绝对值
        testSqrt();//开方
        testCeilFloor();//四舍五入，全舍，全入，
    }

    /**
     * 四舍五入，向上向下取整。
     */
    private static void testCeilFloor() {
        System.out.println(Math.ceil(12.4));//13.0
        System.out.println(Math.floor(12.4));//12.0
        System.out.println(Math.round(12.4));//12
        System.out.println(Math.round(12.5));//13
    }

    /**
     * 开方，注意，返回是double。
     */
    private static void testSqrt() {
        System.out.println(Math.sqrt(16));//4.0
    }

    /**
     * 绝对值
     */
    private static void testAbs() {
        //int, long, float, double
        System.out.println(Math.abs(-1));//1
    }

    /**
     * 平方，注意，返回是double。
     */
    private static void testPow() {
        System.out.println(Math.pow(10, 3));//结果是：1000.0
    }


}
