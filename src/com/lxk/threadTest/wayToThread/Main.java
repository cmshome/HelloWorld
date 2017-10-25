package com.lxk.threadTest.wayToThread;

import java.util.concurrent.FutureTask;

/**
 * 线程测试（实现多线程的几种方式）
 * <p>
 * @author lxk on 2016/11/12
 */
public class Main {
    public static void main(String[] args) {
        newThreadWay1();//实现Runnable接口
        //newThreadWay2();//继承Thread类
        //newThreadWay3();//实现Callable接口
        //newThreadWay1_();//也就是个简单的匿名对象，直接实现Runnable接口，省去了新建个类的步骤
        //newThreadWay1__();//一样也是实现Runnable接口，省去了新建个类的步骤，不过不是匿名对象而已
    }

    /**
     * 创建线程方式1实现
     * 实现Runnable接口，重写run方法
     * 实现接口的优点：可以方便扩展
     */
    private static void newThreadWay1() {
        ThreadWay1 threadWay1 = new ThreadWay1();
        new Thread(threadWay1).start();
        //new Thread(new ThreadWay1()).start();//等于上面的2行代码
        System.out.println(Thread.currentThread().getName() + "...implements Runnable way");
    }


    /**
     * 创建线程方式2实现
     * 继承Thread类，重写run函数
     */
    private static void newThreadWay2() {
        ThreadWay2 threadWay2 = new ThreadWay2();
        threadWay2.start();
        //new ThreadWay2().start();//等于上面的2行代码
        System.out.println(Thread.currentThread().getName() + "...extends way");
    }

    /**
     * 创建线程方式3实现
     * 实现Callable接口，重写call方法
     */
    private static void newThreadWay3() {
        int resultFromThread;
        try {
            ThreadWay3 threadWay3 = new ThreadWay3();
            FutureTask<Integer> future = new FutureTask<>(threadWay3);
            new Thread(future).start();
            Thread.sleep(5000);// 可能做一些事情
            //注意：
            // 这个有个问题：主线程必须等子线程执行完，才可以继续执行，变成了同步啦，这就不太好啦。失去了多线程的意义啦。
            resultFromThread = future.get();
            System.out.println(Thread.currentThread().getName() + "...implements Callable<T>..." + resultFromThread);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建线程方式1实现
     * 实现Runnable接口，重写run方法
     * (匿名对象：new个线程对象直接开启)
     */
    private static void newThreadWay1_() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {//死循环
                    try {
                        Thread.sleep(1000);//毫秒
                        System.out.println(Thread.currentThread().getName() + "...new Runnable()匿名对象");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        System.out.println(Thread.currentThread().getName() + "......new Runnable()匿名对象");
    }

    /**
     * 创建线程方式1实现
     * 实现Runnable接口，重写run方法
     * (实例化一个线程对象，然后调用start方法开启线程)
     */
    private static void newThreadWay1__() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        Thread.sleep(1000);//毫秒
                        System.out.println(Thread.currentThread().getName() + "...new Runnable()非匿名对象");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        System.out.println(Thread.currentThread().getName() + "...new Runnable()非匿名对象");
    }
}