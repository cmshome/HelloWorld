package com.lxk.threadTest.mianShiTest.staticAttribute;

/**
 * @author lxk on 2017/11/17
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.start();
        t2.start();

    }
}
