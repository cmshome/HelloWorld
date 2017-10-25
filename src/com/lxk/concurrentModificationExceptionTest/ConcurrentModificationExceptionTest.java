package com.lxk.concurrentModificationExceptionTest;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * ConcurrentModificationException的出现情况
 * <p>
 * @author lxk on 2016/11/11
 */
public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        modCountTest();
    }

    /**
     * modCount 相关测试
     */
    private static void modCountTest() {
        List<String> list = Lists.newArrayList();
        setListData(list);//给list设值:{0-9}
        System.out.println("原来未修改集合" + list);
        //wrongWay0(list);  //1：使用迭代器迭代的时候，集合结构遭到修改
        //rightWay1(list);  //  for循环删除安全
        //wrongWay1(list);  //2：for each 删除集合元素
        wrongWay2(list);    //3：多线程并发操作一个集合时候
        System.out.println("被修改过的集合" + list);
    }

    /**
     * 获得一个list集合
     */
    private static void setListData(List<String> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
    }

    /**
     * 第一种：会抛ConcurrentModificationException的异常方法
     */
    private static void wrongWay0(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (iterator.next().equals("5")) {
                //iterator.remove();//正确移除集合元素姿势
                list.remove(temp);//抛异常移除集合元素姿势
            }
        }
    }

    /**
     * 第二种：会抛ConcurrentModificationException的异常方法
     */
    private static void wrongWay1(List<String> list) {
        for (String s : list) {
            if ("5".equals(s)) {
                list.remove(s);
            }
        }
    }

    /**
     * 第二种：不抛异常姿势。
     * （若只是简单循环集合，可用for each循环，若要增删集合，则用for i 循环,避免出错）
     */
    private static void rightWay1(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if ("5".equals(list.get(i))) {
                list.remove(i);
            }
        }
    }

    /**
     * 第三种：会抛ConcurrentModificationException的异常方法
     */
    private static void wrongWay2(final List<String> list) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("4")) {
                        list.remove(i);
                    }
                }
            }
        }).start();
    }

}
