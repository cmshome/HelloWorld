package com.lxk.collectionTest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author lxk on 2018/9/18
 */
public class CollectionTest {
    public static void main(String[] args) {
        testAddAll();
    }

    /**
     * Collections.addAll
     */
    private static void testAddAll() {
        Map<String, String[]> map = Maps.newHashMap();
        map.put("2",new String[]{"1","2"});
        map.put("1",new String[]{"1","2"});
        map.put("3",new String[]{});
        Collection<String[]> values = map.values();
        List<String> list = Lists.newArrayList();
        values.forEach(strings -> {
            Collections.addAll(list, strings);
        });
        list.forEach(System.out::println);

    }
}
