package com.lxk.lambdaTest;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Java 8 之 lambda测试
 * <p>
 * Created by lxk on 2017/8/28
 */
public class Main {
    public static void main(String[] args) {
        testLoop();
    }

    /**
     * 测试集合循环
     */
    private static void testLoop() {
        List<String> list = getLoopList();
        beforeLoop(list);
        lambdaLoop(list);
    }

    /**
     * 使用lambda循环一个集合
     */
    private static void lambdaLoop(List<String> list) {
        //list.forEach(s -> System.out.println(s));//这么写,被编辑器提示更换为下面的写法。
        list.forEach(System.out::print);
        System.out.println();
        list.forEach(s -> System.out.print(s + " "));//要是对单个操作的话，就不能用上面的简写了。
        System.out.println();
    }

    /**
     * 以前循环一个集合，for和foreach循环
     */
    private static void beforeLoop(List<String> list) {
        for (String s : list) {
            System.out.print(s);
        }
        System.out.println();
    }

    /**
     * 获得个循环的集合
     */
    private static List<String> getLoopList() {
        List<String> all = Lists.newArrayList();
        for (Integer i = 0; i < 10; i++) {
            all.add(i.toString());
        }
        return all;
    }


}
