package com.lxk.commonTest;

import com.lxk.util.PrintUtil;

/**
 * float和double只能用来做科学计算或者是工程计算.
 * 在商业计算中我们要用 java.math.BigDecimal
 *
 * Created by lxk on 2017/9/27
 */
public class DoubleTest {
    public static void main(String[] args) {
        testDouble();
    }

    private static void testDouble() {
        Double d = 0.81d;
        System.out.println(d);
        PrintUtil.divideLine();
        System.out.println(0.05 + 0.01);//0.060000000000000005
        System.out.println(1.0 - 0.42);//0.5800000000000001
        System.out.println(4.015 * 100);//401.49999999999994
        System.out.println(123.3 / 100);//1.2329999999999999
    }
}
