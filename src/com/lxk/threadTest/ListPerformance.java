package com.lxk.threadTest;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lxk on 2017/2/10
 */
public class ListPerformance {
    private final int threadNumber;

    private ListPerformance(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    private static class TestThread implements Runnable {
        private static long totalTime;
        private final int No;
        private final int loop = 100000;
        private final Thread t;
        private final List<Integer> list;

        TestThread(int No, List<Integer> list) {
            this.No = No;
            this.list = list;
            t = new Thread(this);
        }

        void start() {
            t.start();
        }

        synchronized void addTime(long time) {
            totalTime += time;
        }

        @Override
        public void run() {
            long time = randomAccess();
            addTime(time);
        }

        @Override
        public String toString() {
            return "Thread " + No + ":";
        }

        long randomAccess() {
            Date date1 = new Date();
            Random random = new Random();
            for (int i = 0; i < loop; i++) {
                int n = random.nextInt(loop);
                list.get(n);
            }
            Date date2 = new Date();
            // System.out.println(this + list.getClass().getSimpleName()
            // + " time:" + time);
            return date2.getTime() - date1.getTime();
        }

    }

    private void initList(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    public void test(List<Integer> list) {
        System.out.println("Test List Performance");
        TestThread[] ts = new TestThread[threadNumber];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new TestThread(i, list);
        }
        for (TestThread t : ts) {
            t.start();
        }
    }

    public static void main(String[] args) {
        ListPerformance lp = new ListPerformance(64);
        List<Integer> al = Collections.synchronizedList(new ArrayList<Integer>());
        int count = 100000;
        lp.initList(al, count);
        lp.test(al);
        System.out.println(al.size());
        System.out.println(TestThread.totalTime);

        TestThread.totalTime = 0;
        CopyOnWriteArrayList<Integer> cl = new CopyOnWriteArrayList<>(al);
        lp.test(cl);
        System.out.println(cl.size());
        System.out.println(TestThread.totalTime);
    }
}
