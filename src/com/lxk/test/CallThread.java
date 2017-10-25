package com.lxk.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;

public class CallThread {
    private static class MyRunnable implements Runnable {
        int index = 0;
        int max = 4 * 2;
        HashMap<Integer, List<Integer>> map = Maps.newHashMapWithExpectedSize(4);

        {
            for (int i = 0; i < 4; i++) {
                map.put(i, Lists.newArrayListWithCapacity(8));
            }
        }

        boolean isRunning = true;

        @Override
        public synchronized void run() {
            while (true) {
                int name = Integer.valueOf(Thread.currentThread().getName());
                while (index % 4 != name) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    if (!isRunning) {
                        return;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {
                }
                for (int i = 0, arrIndex = index; i < 4; i++) {
                    try {
                        if (arrIndex-- < 0) {
                            break;
                        }
                        List<Integer> list = map.get(i);
                        if (list.size() < max) {
                            list.add(name + 1);
                        }
                    } catch (Exception ignore) {
                    }
                }
                System.err.println("A:" + map.get(0));
                System.err.println("B:" + map.get(1));
                System.err.println("C:" + map.get(2));
                System.err.println("D:" + map.get(3));
                System.err.println("-----------------------");

                if (map.get(map.size() - 1).size() == max) {
                    isRunning = false;
                    this.notifyAll();
                    return;
                } else {
                    index++;
                }
                this.notifyAll();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyRunnable();
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(runnable);
            t.setName(String.valueOf(i));
            t.start();
        }
    }
}
