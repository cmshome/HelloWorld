package com.lxk.fast;

import com.google.common.collect.Lists;
import com.lxk.model.Car;
import com.lxk.model.Dog;

/**
 * 测试谁快 直接构造或者一个个set，他们的效率差多少
 *
 * @author LiXuekai on 2019/6/18
 */
public class FastIsConstructOrSet {
    public static void main(String[] args) {
        testFast();
    }

    /**
     * 使用JProfiler看时间占比
     */
    private static void testFast() {
        while (true) {
            //27.4%
            set();
            //72.6%
            construct();
        }
    }

    /**
     * 构造函数来给属性赋值
     */
    private static void construct() {
        Car car = new Car("oooo", 100, Lists.newArrayList(new Dog("aaa", true, true)));
    }

    /**
     * set来给属性赋值
     */
    private static void set() {
        Car car = new Car();
        car.setSign("oooo");
        car.setPrice(100);
        Dog dog = new Dog();
        dog.setName("aaa");
        dog.setAlive(true);
        dog.setLoyal(true);
        car.setMyDog(Lists.newArrayList(dog));
    }
}
