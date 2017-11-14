package com.lxk.commonTest;

import com.lxk.util.CollectionUtil;
import com.lxk.util.PrintUtil;

import java.util.List;

/**
 * 关于for循环的测试
 *
 * @author lxk on 2017/4/21
 */
public class ForTest {
    public static void main(String[] args) {
        //testFor();
        testForEfficiency();
    }

    /**
     * 测试不同for的效率问题
     */
    private static void testForEfficiency() {
        List<String> arrayList = CollectionUtil.getArrayList();
        List<String> linkedList = CollectionUtil.getLinkedList();
        testForI(arrayList, linkedList);
        testForEach(arrayList, linkedList);
        testForLambda(arrayList, linkedList);
    }

    /**
     * for i
     *
     * @param arrayList  arrayList
     * @param linkedList linkedList
     */
    private static void testForI(List<String> arrayList, List<String> linkedList) {
        int size = arrayList.size();
        StringBuilder sb = new StringBuilder();
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            sb.append(arrayList.get(i));
        }
        PrintUtil.printRunTime(a, "for i for arrayList");

        size = linkedList.size();
        sb = new StringBuilder();
        a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            sb.append(linkedList.get(i));
        }
        PrintUtil.printRunTime(a, "for i for linkedList");
    }

    /**
     * for each
     *
     * @param arrayList  arrayList
     * @param linkedList linkedList
     */
    private static void testForEach(List<String> arrayList, List<String> linkedList) {
        StringBuilder sb = new StringBuilder();
        long a = System.currentTimeMillis();
        for (String s : arrayList) {
            sb.append(s);
        }
        PrintUtil.printRunTime(a, "for each for arrayList");

        sb = new StringBuilder();
        a = System.currentTimeMillis();
        for (String s : linkedList) {
            sb.append(s);
        }
        PrintUtil.printRunTime(a, "for each for linkedList");
    }

    /**
     * Java 8 的for循环
     *
     * @param arrayList  arrayList
     * @param linkedList linkedList
     */
    private static void testForLambda(List<String> arrayList, List<String> linkedList) {
        StringBuilder sb = new StringBuilder();
        long a = System.currentTimeMillis();
        arrayList.forEach(sb::append);
        PrintUtil.printRunTime(a, "Lambda for arrayList");

        sb = new StringBuilder();
        a = System.currentTimeMillis();
        linkedList.forEach(sb::append);
        PrintUtil.printRunTime(a, "Lambda for linkedList");
    }

    /**
     * 测试for循环，第三个条件是i++和++i的差别
     * 发现效果是一样的
     */
    private static void testFor() {
        int max = 5;
        for (int i = 0; i < max; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < max; ++i) {
            System.out.print(i);
        }
    }
}
