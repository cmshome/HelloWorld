package com.lxk.threadTest.mianShiTest.staticAttribute;

/**
 * @author lxk on 2017/11/17
 */
public class MyThread implements Runnable {

    volatile static Integer i = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (i) {
                if (i < 100) {
                    i++;
                    String currentThreadName = Thread.currentThread().getName();
                    System.out.println(currentThreadName + " i = " + i);
                } else {
                    break;
                }
            }
        }

    }

}
