package com.lxk.designPattern.singleton;

/**
 * 单例模式第四种
 *
 * @author lxk on 2018/5/16
 */
public class SingletonPattern4 {
    /**
     * 我们把Singleton实例放到一个静态内部类中，这样可以避免了静态实例在Singleton类的加载阶段
     * （类加载过程的其中一个阶段的，此时只创建了Class对象）
     * 就创建对象，毕竟静态变量初始化是在SingletonInner类初始化时触发的，并且由于静态内部类只会被加载一次，所以这种写法也是线程安全的。
     */
    private static class Holder {
        private static SingletonPattern4 singleton = new SingletonPattern4();
    }

    private SingletonPattern4() {
    }

    public static SingletonPattern4 getSingletonInstance() {
        return Holder.singleton;
    }
}
