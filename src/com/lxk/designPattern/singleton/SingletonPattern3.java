package com.lxk.designPattern.singleton;

/**
 * 双重锁形式
 * 这个模式将同步内容下放到if内部，提高了执行的效率，不必每次获取对象时都进行同步，
 * 只有第一次才同步，创建了以后就没必要了。避免土豪模式下创建单例，可能存在的线程不安全问题。
 * <p>
 * @author lxk on 2017/3/23
 */
public class SingletonPattern3 {
    private static SingletonPattern3 singletonInstance;

    private SingletonPattern3() {
    }

    /**
     * 静态方法同步的时候，使用的锁，就不能是this，而是类.class
     */
    public static SingletonPattern3 getSingletonInstance() {
        if (singletonInstance == null) {
            //这个地方可能有多个线程，在这排队，ABCD..。
            synchronized (SingletonPattern3.class) {
                if (singletonInstance == null) {
                    //假设第一次A线程走到这，然后，呈挂起状态。这个时候，单例对象还未创建；
                    // 假设此时，B线程也来了判断单例对象==null成立，但是，因为A线程已经给里层的if判断上锁，所以，B只能在外等着。
                    //假设A线程被唤醒，那么，单例就会下面语句赋值，单例对象就创建啦。然后释放锁。B就可以进来啦。
                    //B线程进来之后，先判断单例对象是否为null，发现已经不是null啦，那么就不需要创建啦。
                    //CD线程同样，
                    //再往后面来的，第一个if就进不来啦，那就不会判断锁了。
                    singletonInstance = new SingletonPattern3();
                }
            }
        }
        return singletonInstance;
    }
}
