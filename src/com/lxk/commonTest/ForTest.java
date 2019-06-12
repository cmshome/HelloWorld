package com.lxk.commonTest;

import com.lxk.util.CollectionUtil;

import java.util.List;

/**
 * 关于for循环的测试
 *
 * @author lxk on 2017/4/21
 */
public class ForTest {
    private static final int SIZE = 40;

    public static void main(String[] args) {
        //testFor();
        testForEfficiency();
        //test();
    }


    /**
     * 测试不同for的效率问题
     */
    private static void testForEfficiency() {
        String[] array = CollectionUtil.getArray(SIZE);
        List<String> arrayList = CollectionUtil.getArrayList(SIZE);
        List<String> linkedList = CollectionUtil.getLinkedList(SIZE);

        while (true) {
            testArray(array);
            testArrayList(arrayList);
            testLinkedList(linkedList);
        }

    }

    /**
     * arrayList 在使用forI循环，forEach循环和lambda循环的效率测试
     */
    private static void testArrayList(List<String> arrayList) {
        testForI(arrayList);
        testForEach(arrayList);
        testLambda(arrayList);
    }

    /**
     * array 在使用forI循环的效率测试
     */
    private static void testArray(String[] array) {
        testForI(array);
    }

    private static void testForI(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append(array[i]);
        }
    }

    /**
     * linkedList 在使用forI循环，forEach循环和lambda循环的效率测试
     */
    private static void testLinkedList(List<String> linkedList) {
        testForI(linkedList);
        testForEach(linkedList);
        testLambda(linkedList);
    }

    private static void testLambda(List<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        arrayList.forEach(sb::append);
    }

    private static void testForEach(List<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        for (String s : arrayList) {
            sb.append(s);
        }
    }

    private static void testForI(List<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append(arrayList.get(i));
        }
    }

    private static void forIAfter() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append(i);
        }
    }

    private static void forIBefore() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; ++i) {
            sb.append(i);
        }
    }

    /**
     * 前后使用++对效率没影响，都是百分之五十的比例。
     */
    private static void test() {
        while (true) {
            forIAfter();
            forIBefore();
        }
    }
}
