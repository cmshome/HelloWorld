package com.lxk.collectionTest;

import com.google.common.collect.Maps;
import com.lxk.model.Car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author lxk on 2017/5/26
 */
public class EmptyTest {
    public static void main(String[] args) {
        //testLoopEmptyMap();
        //testEmptyList();
        //testEmptyMap();
        //testModelEmptyField();
        testArrayAsListAdd();
    }

    private static void testArrayAsListAdd() {
        String[] array = {"1","2","3"};
        List<String> list = Arrays.asList(array);
        list.add("ss");
        System.out.println(list.toString());
    }

    /**
     * 测试这个空集合是某个Java bean 的某个属性的时候的操作，也是不能add的
     */
    private static void testModelEmptyField() {
        Car car = new Car();
        car.setBoys(Collections.emptyList());
        car.getBoys().add("sss");
    }

    /**
     * Collections.emptyMap()  返回的空集合是不能进行put的
     */
    private static void testEmptyMap() {
        Map<String,String> map = Collections.emptyMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":"+ entry.getValue());
        }
        map.put("a","a");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":"+ entry.getValue());
        }
    }

    /**
     * Collections.emptyList()  返回的空集合是不能进行add的
     */
    private static void testEmptyList() {
        List<String> list = Collections.emptyList();
        for (String s : list) {
            System.out.println(s);
        }
        //异常
        list.add("1");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * empty,没关系，但是要是null就会空指针。
     */
    private static void testLoopEmptyMap() {
        Map<String, String> map = Maps.newHashMap();
        for (String s : map.values()) {
            System.out.println(s);
        }
    }
}
