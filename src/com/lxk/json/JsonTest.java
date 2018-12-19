package com.lxk.json;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.lxk.model.*;
import com.lxk.util.JsonUtils;

import java.util.Date;
import java.util.List;

/**
 * 测试json和Java对象之间的转换
 * <p>
 *
 * @author lxk on 2017/6/15
 */
public class JsonTest {
    public static void main(String[] args) {
        //Student student = getStudent();
        //obj2Json(student);
        //formatJson(student);
        //testJsonField();
        testOrdered();
    }

    /**
     * 测试json的有序
     */
    private static void testOrdered() {
        House house = new House(180, 180, "lxk", 180);
        //如果不使用注解（），不排序，json字符串的属性按字母顺序排序，不按model里面属性的顺序。
        System.out.println(JSON.toJSONString(house));
    }

    /**
     * 测试 fast json 中的JsonField注解的使用
     */
    private static void testJsonField() {
        String dog = JsonUtils.parseObjToJson(new Dog("大师兄的dog", true, true));
        Bird bird = new Bird(dog, dog, new Date(), "红色皮肤", "巨大无比", 18, "典韦", "不序列化的字段，是不会被转json输出的");
        System.out.println(bird.toString());
        String s = JsonUtils.parseObjToJson(bird);
        System.out.println(s);
        Bird deserialize = JsonUtils.parseJsonToObj(s, Bird.class);
        System.out.println(deserialize == null ? "" : deserialize.toString());
    }

    /**
     * 对象转json，json转对象。
     */
    private static void obj2Json(Student student) {
        String studentJson = JsonUtils.parseObjToJson(student);
        System.out.println(studentJson);
        Student studentFromJson = JsonUtils.parseJsonToObj(studentJson, Student.class);
        System.out.println(studentFromJson);
    }

    /**
     * 格式化和非格式化输出json字符串
     */
    private static void formatJson(Object obj) {
        System.out.println(JsonUtils.toFormatJSONString(obj));
        System.out.println(JsonUtils.toNoFormatJSONString(obj));
    }

    /**
     * 获得测试对象
     */
    public static Student getStudent() {
        Dog dog1 = new Dog("大师兄的dog", true, true);
        Dog dog2 = new Dog("大师兄的dog", false, false);
        List<Dog> dogs = Lists.newArrayList();
        dogs.add(dog1);
        dogs.add(dog2);
        List<String> boys = Lists.newArrayList("tom", "jerry", "jack");
        Car car = new Car("q7", 182, dogs, boys);
        Student student = new Student();
        student.setName("Lxk");
        student.setCar(car);
        return student;
    }
}
