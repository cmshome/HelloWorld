package com.lxk.commonTest;

/**
 * test char
 *
 * @author LiXuekai on 2019/8/9
 */
public class CharTest {
    public static void main(String[] args) {
        printChar1To9();
    }

    /**
     * 字符0-9对应的int数字是【48-57】
     */
    private static void printChar1To9() {
        for (char i = '0'; i <= '9'; i++) {
            System.out.println((int) i + " -- " + i);
        }

        System.out.println((char) 48);
        System.out.println((char) 51);
        System.out.println(11 >= 11);
        System.out.println(11 <= 11);
    }
}
