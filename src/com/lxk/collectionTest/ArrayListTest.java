package com.lxk.collectionTest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lxk on 2017/2/13
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //test1();
        //testSortList();
        testAddAllNull();
    }

    /**
     * list.addAll(null)异常
     */
    private static void testAddAllNull() {
        List<String> list = Lists.newArrayList();
        list.add(null);
        list.add(null);
        list.add(null);
        list.addAll(null);
    }

    private static void testSortList() {
        List<Integer> list = Lists.newArrayList(5,2,13,4,22,3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void test1() {
        List<String> list = new ArrayList<>(2);
        System.out.println("list大小为：" + list.size());
        list.add("12");
        System.out.println("list大小为：" + list.size());
        list.set(1, "sss");
        list.add(1, "放在下标为1的位置");
        list.add("22");
        System.out.println("list大小为：" + list.size());
        System.out.println(list.toString());
        list.add(1, "放在下标为1的位置");
        System.out.println("list大小为：" + list.size());
        System.out.println(list.toString());
    }

}
