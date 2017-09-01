package com.lxk.lambdaTest;

import com.google.common.collect.Lists;
import com.lxk.model.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java 8 之 lambda测试
 * 中间操作：filter()、distinct()、sorted()、map()、flatMap()等，其一般是对数据集的整理（过滤、排序、匹配、抽取等）。
 * 终结操作：如forEach()、allMatch()、anyMatch()、findAny()、 findFirst()，
 * ----------数值计算类的方法有sum、max、min、average等等。
 * ----------终止方法也可以是对集合的处理，如reduce()、 collect()等等
 * <p>
 * <p>
 * Created by lxk on 2017/8/28
 */
public class Main {
    public static void main(String[] args) {
        //testLoop();
        //testStreamFilter();
        testStreamMap();
        //testLoopOperate();
        //testOperateNumber();
        //testReduce();
    }

    /**
     * T reduce(T identity, BinaryOperator<T> accumulator);
     * identity：它允许用户提供一个循环计算的初始值。
     * accumulator：计算的累加器，
     */
    private static void testReduce() {
        //T reduce(T identity, BinaryOperator<T> accumulator);
        System.out.println("给定个初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (sum, item) -> sum + item));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::sum));
        System.out.println("给定个初始值，求min");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (min, item) -> Math.min(min, item)));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::min));
        System.out.println("给定个初始值，求max");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (max, item) -> Math.max(max, item)));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::max));

        //Optional<T> reduce(BinaryOperator<T> accumulator);
        // 注意返回值，上面的返回是T,泛型，传进去啥类型，返回就是啥类型。
        // 下面的返回的则是Optional类型
        System.out.println("无初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).orElse(0));
        System.out.println("无初始值，求max");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::max).orElse(0));
        System.out.println("无初始值，求min");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::min).orElse(0));

        System.out.println(Stream.of(1, 2, 3, 4).max(Integer::max));
        System.out.println(Stream.of(1, 2, 3, 4).max(Comparator.naturalOrder()));

    }

    /**
     * 测试用法，稍复杂的串行操作。
     * 过滤空值；去重；排序；循环输出。
     */
    private static void testOperateNumber() {
        List<Integer> integers = Arrays.asList(1, 3, null, 8, 7, 8, 13, 10);
        integers.stream().filter(Objects::nonNull).distinct().sorted().forEach(System.out::println);
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
