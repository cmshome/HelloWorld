package com.lxk.designPattern.proxy.dynamicProxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理-拦截器
 * <p>
 * @author lxk on 2016/11/25
 */
public class MyInterceptor implements InvocationHandler {
    private Object target;//目标类

    public MyInterceptor(Object target) {
        this.target = target;
    }

    /**
     * args 目标方法的参数
     * method 目标方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("aaaaa");//切面方法a();
        //。。。
        method.invoke(this.target, args);//调用目标类的目标方法
        //。。。
        System.out.println("bbbbb");//切面方法f();
        return null;
    }
}
