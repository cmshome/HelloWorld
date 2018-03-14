package com.lxk.commonTest;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 测试 Integer 常量池问题。
 *
 * @author lxk on 2017/2/23
 */
public class IntegerTest {
    public static void main(String[] args) {
        //testIntegerCache();
        //testIntAndIntegerCache();
        //valueIsNumber("ewq");
        testRandom();
    }

    /**
     * 考虑最后的那个邀请码的情况
     * 快来领支付宝红包！人人可领，天天可领！复制此消息，打开最新版支付宝就能领取！
     * 04QOHe67OA
     */
    private static void testRandom() {
        //一位上的数的情况：字母大小写，外加十个数字。
        System.out.println(26 * 2 + 10);
        BigDecimal all = new BigDecimal(Math.pow(62, 10) + "");
        String big = all.toPlainString();
        System.out.println(big);
        System.out.println(big.length());
        System.out.println(UUID.randomUUID());
    }


    /**
     * 测试 Integer 常量池问题，
     */
    private static void testIntegerCache() {
        Integer MaxCacheA = 127;
        Integer MaxCacheB = 127;
        Integer minCacheA = -128;
        Integer minCacheB = -128;
        Integer noCacheA = 128;
        Integer noCacheB = 128;
        System.out.println(MaxCacheA == MaxCacheB);
        System.out.println(minCacheA == minCacheB);
        System.out.println(noCacheA == noCacheB);
        System.out.println(noCacheA.equals(noCacheB));

    }

    /**
     * 测试 Integer的缓存 IntegerCache.cache
     */
    private static void testIntAndIntegerCache() {
        System.out.println("---int---");
        int a = 127, b = 127;
        System.out.println(a == b);         //true
        a = 128;
        b = 128;
        System.out.println(a == b);         //true

        System.out.println("---Integer---");
        Integer aa = 127, bb = 127;
        System.out.println(aa == bb);       //true
        aa = 128;
        bb = 128;
        System.out.println(aa == bb);       //false
        System.out.println(aa.equals(bb));  //true
    }

    private static boolean valueIsNumber(Object value) {
        try {
            Integer parseInt = Integer.parseInt(value.toString());
            System.out.println(parseInt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
