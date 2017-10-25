package com.lxk.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lxk on 2017/3/3
 */
@Component("p")
public class BigBrother {
    // 利用@Value注解，即使没有该属性或者属性文件也不会报错

    // @Value输入属性值name，默认值xydefault
    @Value("${name:xydefault}")
    private String name;

    //@Value("${mongodb.name:lxk}")
    //private String dbName;
    //
    //@Value("${mongodb.username:lxklxk}")
    //private String dbUser;
    //
    //@Value("${mongodb.password:123456}")
    //private String dbPwd;
    //
    //// @Value输入属性值num，默认值-1
    //@Value("${num:-1}")
    //private Integer num;
    //
    //// @Value输入属性值type，默认值-2
    //@Value("${type:-2}")
    //private Integer type;

    public BigBrother() {
    }

    void show() {
        System.out.println(name);
    }

}
