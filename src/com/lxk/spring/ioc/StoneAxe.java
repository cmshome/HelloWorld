package com.lxk.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * Axe的第一个实现类 StoneAxe 石斧
 * 这个@Component("stoneAxe") 等价于 <bean id="stoneAxe" class="..StoneAxe">
 * @author lxk on 2017/3/22
 */
@Component("stoneAxe")
class StoneAxe implements Axe {

    /** 实现Axe接口的chop方法 */
    @Override
    public String chop() { return "石斧砍柴好慢"; }
}