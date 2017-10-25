package com.lxk.collectionTest;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author lxk on 2017/4/11
 */
public class HashMapTest {
    public static void main(String[] args) {
        testIterator();
    }

    /**
     * 测试Iterator迭代器
     */
    private static void testIterator() {
        HashMap<String, String> map = Maps.newHashMap();
        map.put("a", "one");
        map.put("b", "two");
        map.put("c", "three");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
