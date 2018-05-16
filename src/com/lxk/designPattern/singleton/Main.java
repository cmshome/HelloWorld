package com.lxk.designPattern.singleton;

/**
 * 单例模式测试类
 * <p>
 * @author lxk on 2017/3/23
 */
public class Main {
    public static void main(String[] args) {
        SingletonPattern1 singletonPattern1 = SingletonPattern1.getSingletonInstance();
        SingletonPattern2 singletonPattern2 = SingletonPattern2.getSingletonInstance();
        SingletonPattern3 singletonPattern3 = SingletonPattern3.getSingletonInstance();
        SingletonPattern4 singletonPattern4 = SingletonPattern4.getSingletonInstance();
    }
}
