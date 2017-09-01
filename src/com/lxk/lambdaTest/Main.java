package com.lxk.lambdaTest;

import com.google.common.collect.Lists;
import com.lxk.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Java 8 之 lambda测试
 * <p>
 * Created by lxk on 2017/8/28
 */
public class Main {
    public static void main(String[] args) {
        //testLoop();
        testStreamFilter();
        //testStreamMap();
        //testLoopOperate();
    }

    /**
     * 测试collection.stream().filter()
     */
    private static void testStreamFilter() {
        List<User> list = getLoopList();
        System.out.println("对集合进行过滤：user name 包含 1 的用户");
        List<User> filtered = list.stream().filter(s -> s.getName().contains("1")).collect(Collectors.toList());
        filtered.forEach(user -> System.out.println(user.toString()));
        println();
    }

    /**
     * 测试collection.stream().map()
     */
    private static void testStreamMap() {
        List<User> list = getLoopList();
        System.out.println("对集合进行操作：user name + “1” ");
        List<String> nameList = list.stream().map(User::getName).collect(Collectors.toList());
        nameList.forEach(System.out::print);
        println();
    }

    /**
     * 测试循环的时候，顺带操作集合中的内容。
     */
    private static void testLoopOperate() {
        List<User> list = getLoopList();
        System.out.println("对集合进行操作：user's name + “_1” ");
        //list.forEach(user -> user.setName(user.getName() + "_1"));
        list.forEach(user -> {
            String name = user.getName();
            user.setName(name + "_1");
        });
        //操作完，循环输出一下，看下是否操作OK。
        list.forEach(System.out::println);
        println();
    }

    /**
     * 测试集合循环
     */
    private static void testLoop() {
        List<User> list = getLoopList();
        beforeLoop(list);
        lambdaLoop(list);
    }
    /**
     * 以前循环一个集合，for和foreach循环
     */
    private static void beforeLoop(List<User> list) {
        for (User user : list) {
            System.out.println(user.toString());
        }
        println();
    }

    /**
     * 使用lambda循环一个集合
     */
    private static void lambdaLoop(List<User> list) {
        //三行循环效果相同
        //list.forEach(user -> System.out.println(user.toString()));
        //list.forEach(user -> System.out.println(user));//下面一行代码就是简写形式
        list.forEach(System.out::println);
        println();
    }


    /**
     * 获得个循环的集合
     */
    private static List<User> getLoopList() {
        List<User> all = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            all.add(new User("lxk_" + i, "pwd_" + i));
        }
        return all;
    }

    /**
     * 打印分行符公共方法
     */
    private static void println() {
        System.out.println("___________________我是分行符___________________");
    }


}
