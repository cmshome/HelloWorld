package com.lxk.model;

import java.io.Serializable;

/**
 * 测试model集合按某属性排序
 * <p>
 * @author lxk on 2016/11/25
 */
public class Person_ implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;

    public Person_(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Person_ clone() {
        Person_ person_ = null;
        try {
            person_ = (Person_) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return person_;
    }
}