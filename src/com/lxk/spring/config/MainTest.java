package com.lxk.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lxk on 2017/3/3
 */
public class MainTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/lxk/spring/config/applicationContext.xml");
        BigBrother bigBrother = (BigBrother) context.getBean("p");
        bigBrother.show();
    }
}
