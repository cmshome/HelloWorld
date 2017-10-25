package com.lxk.threadTest.bank;

/**
 * 顾客，实现runnable()接口，多个人可以一起存钱
 * <p>
 * @author lxk on 2017/6/26
 */
public class Customer implements Runnable {
    private Bank b = new Bank();

    @Override
    public void run() {
        for (int x = 0; x < 3; x++) {
            b.add(100);
        }
    }
}
