package com.lxk.java8;

import com.lxk.util.CollectionUtil;

import java.util.List;

/**
 * 根据条件，删除集合中的元素
 *
 * @author lxk on 2018/1/24
 */
public class RemoveIfTest {
    public static void main(String[] args) {
        removeIfTest();
    }

    /**
     * 删除集合中复合条件的成员，empty集合也可以
     */
    private static void removeIfTest() {
        List<String> list = CollectionUtil.getArrayList();
        System.out.println(list.size());
        list.removeIf(s -> !s.equals("1"));
        System.out.println(list.size());
        System.out.println(list.toString());
    }
}
