package com.lxk.commonTest;

import com.google.common.collect.Lists;
import com.lxk.model.Person_;

import java.util.List;

/**
 * 测试Java的clone方法
 * <p>
 * @author lxk on 2017/2/28
 */
public class CloneTest {
    public static void main(String[] args) {
        testCloneEasy();
    }

    /**
     * 简单测试：（未有对象嵌套对象的问题）
     * 测试克隆前后，使用的是否是同一个对象，即地址传递和值传递问题
     */
    private static void testCloneEasy() {
        Person_ lxk = new Person_(18, "lxk");
        List<Person_> list = Lists.newArrayList();
        list.add(lxk);
        Person_ clone = lxk.clone();
        lxk.setAge(100);
        System.out.println(clone.getAge());

    }

}
