package com.lxk.threadTest.countdownlatch;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CountDownLatch 测试
 * 倒计时器，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
 *
 * @author lxk on 2018/4/17
 */
public class CountDownLatchTest {
    private static final Integer THREAD_COUNT_NUM = 7;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    /**
     * 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
     * ExecutorService executor = Executors.newCachedThreadPool();
     * 创建固定大小的线程池，可以延迟或定时的执行任务。
     * ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_COUNT_NUM);
     * 创建单个线程池。线程池中只有一个线程
     * ExecutorService executor = Executors.newSingleThreadExecutor();
     */

    public static void main(String[] args) throws InterruptedException {
        //创建固定大小的线程池
        //阿里建议不使用Executors去创建线程池，因为这个隐藏了线程池的实现
        //使用ThreadPoolExecutor去创建，更加明确线程池的运行规则，规避资源耗尽的风险。
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("BasicThreadPoolJob-CachedThreadPool-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(6,
                10,
                5,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        //ExecutorService executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < THREAD_COUNT_NUM; i++) {
            int index = i;
            executor.execute(() -> {
                try {
                    System.out.println("第" + index + "颗龙珠已经收集到！");
                    Thread.sleep(new Random().nextInt(3000));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("集齐七龙珠，召唤神龙！");
        executor.shutdown();
    /*
        public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler)




     */
    }
}
