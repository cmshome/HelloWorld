package com.lxk.model;

/**
 * @author lxk on 2017/4/26
 */
public class Parent {
    public int age = 18;

    private String name = "lxk";

    public Parent() {
    }

    public Parent(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void say() {
        System.out.println("this is parent say !");
    }

    public void sayHello() {
        System.out.println("this is parent sayHello !");
    }

}
