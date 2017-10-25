package com.lxk.threadTest.mianShiTest.one;

/**
 * @author lxk on 2017/7/14
 */
public class Child implements Runnable {
    private Object object;

    public Child(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 50) {
            synchronized (object) {
                System.out.println("子10");
                i++;
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
