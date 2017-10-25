package com.lxk.threadTest.bank;

/**
 * 银行model，一个总金额属性。
 * <p>
 * @author lxk on 2017/6/26
 */
public class Bank {
    private int sum;
    //这个从来不这么用，但也算是正确的一种加锁的机制：同步代码块。
    //Object obj = new Object();

    /**
     * 要是不加[synchronized--同步函数],则会出现多线程安全问题。
     */
    public synchronized void add(int n) {
        //synchronized (obj) {
            sum = sum + n;
            try {
                Thread.sleep(10);
            } catch (Exception ignore) {
            }
            //当存钱次数变多的时候，就可以发现，存钱的线程确实是2个在交替执行存钱这个动作的。
            System.out.println(Thread.currentThread().getName() + "...sum=" + sum);
        //}
    }
}
