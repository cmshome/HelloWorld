package com.lxk.extendTest;

import com.lxk.model.Child;
import com.lxk.model.Parent;
import com.lxk.util.PrintUtil;

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

        PrintUtil.divideLine();

        //java 的多态，说的就是这个。
        Parent parent = new Child();
        parent.say();
    }
}
