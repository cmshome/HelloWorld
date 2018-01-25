package com.lxk.commonTest;

import com.lxk.util.DoubleUtil;
import com.lxk.util.PrintUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * float和double只能用来做科学计算或者是工程计算.
 * 在商业计算中我们要用 java.math.BigDecimal
 * <p>
 * @author lxk on 2017/9/27
 */
public class DoubleTest {
    public static void main(String[] args) {
        //testDouble();
        //PrintUtil.divideLine();
        //testDoubleExact();
        testBigDecimal();
    }


    /**
     * BigDecimal的测试，要精确。
     * 还要使得科学计数法的数字，做完全的展示。
     */
    private static void testBigDecimal() {
        Double d = 1.6D;
        //不准确的初始化
        BigDecimal bigDecimal = new BigDecimal(d);
        System.out.println(bigDecimal);

        //使得结果精确的初始化姿势
        bigDecimal = new BigDecimal(d.toString());
        System.out.println(bigDecimal);

        bigDecimal = new BigDecimal("6.214822313132341212666E+18");
        System.out.println(bigDecimal.toPlainString());
    }

    /**
     * double的一些计算奇葩现象，试验一把，就印象深刻啦。
     */
    private static void testDouble() {
        Double d = 0.81d;
        System.out.println(d);
        PrintUtil.divideLine();
        System.out.println("0.05 + 0.01 = " + (0.05 + 0.01));//0.060000000000000005
        System.out.println("1.0 - 0.42 = " + (1.0 - 0.42));//0.5800000000000001
        System.out.println("4.015 * 100 = " + (4.015 * 100));//401.49999999999994
        System.out.println("123.3 / 100 = " + (123.3 / 100));//1.2329999999999999
        System.out.println(new DecimalFormat("0.00").format(4.025d));//4.03 四舍五入
    }

    /**
     * 精确计算
     */
    private static void testDoubleExact() {
        System.out.println("0.05 + 0.01 = " + DoubleUtil.add(0.05, 0.01));
        System.out.println("1.0 - 0.42 = " + DoubleUtil.sub(1.0, 0.42));
        System.out.println("4.015 * 100 = " + DoubleUtil.mul(4.015, 100d));
        System.out.println("123.3 / 100 = " + DoubleUtil.divide(123.3, 100d));//保留两位
        System.out.println("123.3 / 100 = " + DoubleUtil.divide(123.3, 100d, 3));//保留三位
        System.out.println(DoubleUtil.round(4.025d, 2));
    }
}
