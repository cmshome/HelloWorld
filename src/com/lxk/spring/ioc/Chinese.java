package com.lxk.spring.ioc;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Person的实现类（Chinese实现Person接口）
 *
 * @author lxk on 2017/3/22
 */
@Component("chinese")
class Chinese implements Person {
    /** 面向Axe(斧子)接口编程，而不是具体的实现类 */
    @Resource(name = "stoneAxe")
    private Axe axe;

    /** 实现Person接口的useAxe方法 */
    public void useAxe() { System.out.println(axe.chop()); }
}