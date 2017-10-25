package com.lxk.spring.ioc;

/**
 * 定义Axe(斧子英文Axe)接口
 * <p>
 * @author lxk on 2017/3/22
 */
interface Axe {
    String chop(); //Axe接口里有个砍(chop)的方法,原作里面是void，但是这里应该是返回String类型
}
