package com.lxk.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入，使用注解实现
 * <p>
 * @author lxk on 2017/3/22
 */
public class Main {
    public static void main(String[] args) {
        //因为是独立的应用程序，显式地实例化Spring的上下文。下面是启动spring容器代码：寻找配置文件实例化容器
        ApplicationContext context = new ClassPathXmlApplicationContext("com/lxk/spring/ioc/applicationContext.xml");
        //通过Person bean的id来获取bean实例，面向接口编程，因此
        //此处强制类型转换为接口类型
        Person p = (Person) context.getBean("chinese");
        //直接执行Person的userAxe()方法。
        p.useAxe();
    }
}
