package com.lxk.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 自定义集合告警类
 *
 * @author lxk on 2017/11/13
 */
public class CollectionUtil {
    private static final int SIZE = 100000;

    /**
     * 获得底层是数组的list集合
     */
    public static List<String> getArrayList() {
        List<String> list = Lists.newArrayListWithExpectedSize(SIZE);
        for (Integer i = 0; i < SIZE; i++) {
            list.add(i.toString());
        }
        return list;
    }

    /**
     * 获得底层是链表的list集合
     */
    public static List<String> getLinkedList() {
        List<String> list = Lists.newArrayListWithExpectedSize(SIZE);
        for (Integer i = 0; i < SIZE; i++) {
            list.add(i.toString());
        }
        return list;
    }
}
