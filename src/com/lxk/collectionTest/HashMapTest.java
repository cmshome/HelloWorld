package com.lxk.collectionTest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author lxk on 2017/4/11
 */
public class HashMapTest {
    public static void main(String[] args) {
        //testIterator();
        testReference();
    }

    private static void testReference() {
        Map<String,Object> map = Maps.newHashMap();
        map.put("1",12);
        map.put("12",12);
        List<Map<String,Object>> list = Lists.newArrayList();
        list.add(map);
        map = Maps.newHashMap();
        map.put("13",12);
        map.put("123",12);
        list.add(map);
        for (Map<String, Object> objectMap : list) {
            System.out.println(objectMap);
        }
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
