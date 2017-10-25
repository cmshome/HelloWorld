package com.lxk.extendTest;

/**
 * 测试继承中的super用法
 *
 * @author lxk on 2017/4/26
 */
public class ExtendTestMain {
    public static void main(String[] args) {
        testExtend();
    }

    /**
     * 测试super的使用
     */
    private static void testExtend() {
        Child child = new Child();
        child.say();
        child.sayHello();
    }
}
