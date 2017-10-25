package com.lxk.spring.aop.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试切面编程AOP（注解实现）
 * <p>
 * @author lxk on 2016/11/28
 */
public class AOPAnnotationTest {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/lxk/spring/aop/annotation/applicationContext.xml");
        PersonDao personDao = (PersonDao) context.getBean("personDaoImpl");
        personDao.getPerson();
        //List<Person> personList = personDao.getPerson("sss");
        //System.out.println(personList.size());
    }
}
