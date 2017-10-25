package com.lxk.commonTest;

/**
 * 测试for循环，第三个条件是i++和++i的差别
 * 发现效果是一样的
 * <p>
 * @author lxk on 2017/4/21
 */
public class ForTest {
    public static void main(String[] args) {
        testFor();
    }

    private static void testFor() {
        for (int i = 0; i < 5; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < 5; ++i) {
            System.out.print(i);
        }
    }
}
