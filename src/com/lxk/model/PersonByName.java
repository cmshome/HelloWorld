package com.lxk.model;

import java.util.Comparator;

/**
 * 测试model集合按某属性排序
 * <p>
 * @author lxk on 2016/11/25
 */
public class PersonByName implements Comparator<Person_> {

    @Override
    public int compare(Person_ o1, Person_ o2) {
        //这可以修改来升序或者降序
        //return o2.getName().compareTo(o1.getName());//降序
        return o1.getName().compareTo(o2.getName());//升序
    }
}
