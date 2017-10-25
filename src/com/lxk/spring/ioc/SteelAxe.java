package com.lxk.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * Axe的第二个实现类 SteelAxe 钢斧
 * 这个@Component 等价于 <bean id="steelAxe" class="..SteelAxe">
 * @author lxk on 2017/3/22
 */
@Component
class SteelAxe implements Axe{

    /** 实现Axe接口的chop方法 */
    @Override
    public String chop() {
        return "钢斧砍柴真快";
    }
}