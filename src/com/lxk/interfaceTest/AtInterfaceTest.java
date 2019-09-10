package com.lxk.interfaceTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

class Student {
    void say() {
        System.out.println("hello");
    }
}

class Person {
    //下面2个注解的作用相当于 @Resource(name="ss") 一个
    //区别在于@Resource是javax的，下面2个是spring自己的
    @Autowired
    @Qualifier(value = "ss")
    private Student ss;

    void say() {
        this.ss.say();
    }
}

/**
 * @author lxk on 2016/9/29
 *
 * 注解测试
 */
class AtInterfaceTest {
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/fusion/intellij_work/TrunkNew/sss.xml");
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("src/sss.xml");//这个时候sss.xml是在项目的根目录下的src文件夹下
        ApplicationContext ctx = new FileSystemXmlApplicationContext("sss.xml");//这个时候sss.xml是在项目的根目录下
        Person p = (Person) ctx.getBean("person");
        p.say();
    }
}
