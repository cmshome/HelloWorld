package com.lxk.commonTest;

import com.lxk.model.Dog;

import java.util.Arrays;

/**
 * 数组测试
 * <p>
 * @author lxk on  2017/2/10
 */
public class ArraysTest {
    public static void main(String[] args) {
        String order = "1128";
        if (!order.equals("1128")) {
            testArraysCopy();
            testArrayInit();
        } else {
            testJavaBeanArray();
        }
    }

    /**
     * 测试对象数组的默认情况，默认全是null，基础知识啦。
     */
    private static void testJavaBeanArray() {
        Dog[] dogs = new Dog[10];
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }

    /**
     * 二维数组初始化
     */
    private static void testArrayInit() {
        Object[][] ss = new Object[2][2];
        Object[][] ww = {{12, 12}, {12, 12}};
        System.out.println(Arrays.toString(ss));//直接toString()，打印的是地址。
        System.out.println(Arrays.deepToString(ss));//直接toString()，打印的是地址。
        System.out.println(Arrays.deepToString(ww));
    }

    /**
     * 数组复制：Arrays.copyOf()用法
     */
    private static void testArraysCopy() {
        Object[] numbers = {1, "ss", 3, 4, 5};
        Object[] numbersCopy = Arrays.copyOf(numbers, 5);
        numbersCopy[0] = 11;
        System.out.println(Arrays.toString(numbersCopy));
        System.out.println(Arrays.toString(numbers));
    }
}
