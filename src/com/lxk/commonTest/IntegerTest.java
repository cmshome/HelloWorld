package com.lxk.commonTest;

/**
 * 测试 Integer 常量池问题。
 * <p>
 * @author lxk on 2017/2/23
 */
public class IntegerTest {
    public static void main(String[] args) {
        testIntegerCache();
        testIntAndIntegerCache();
        valueIsNumber("ewq");
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
