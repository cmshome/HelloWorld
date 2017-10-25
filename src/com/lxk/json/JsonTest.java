package com.lxk.json;

import com.google.common.collect.Lists;
import com.lxk.model.Car;
import com.lxk.model.Dog;
import com.lxk.model.Student;
import com.lxk.util.JsonUtils;

import java.util.List;

/**
 * 测试json和Java对象之间的转换
 * <p>
 * @author lxk on 2017/6/15
 */
public class JsonTest {
    public static void main(String[] args) {
        Student student = getStudent();
        String studentJson = JsonUtils.parseObjToJson(student);
        System.out.println(studentJson);
        Student studentFromJson = JsonUtils.parseJsonToObj(studentJson, Student.class);
        System.out.println(studentFromJson);
    }

    private static Student getStudent() {
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
