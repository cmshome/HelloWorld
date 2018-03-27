package com.lxk.guavaTest;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.lxk.model.Car;
import com.lxk.model.Dog;

import java.util.Arrays;
import java.util.List;

/**
 * guava Lists 测试实例
 *
 * @author lxk on 2016/11/7
 */
public class ListsTest {

    public static void main(String[] args) {
        //emptyListToArray();
        //objectListToString();
        simpleListToString();
        //testLists();

    }

    private static void simpleListToString() {
        List<String> list = Lists.newArrayList();
        System.out.println(list.toString());
        //跳过null
        Joiner joiner = Joiner.on(",").skipNulls();
        String s = joiner.join(list);
        System.out.println(s);
    }


    /**
     * list.toString()
     */
    private static void objectListToString() {
        List<String> s = Lists.newArrayList();
        List<String> ss = Lists.newArrayList();
        List<Car> list1 = Lists.newArrayList();
        List<Car> list2 = Lists.newArrayList();
        Dog dog = new Dog(true, true);
        List<Dog> dogs = Lists.newArrayList();
        dogs.add(dog);
        for (int i = 0; i < 5; i++) {
            s.add(i + "saa");
            ss.add(i + "saa");
            list1.add(new Car("i", 100 + i, dogs));
            list2.add(new Car("i", 100 + i, dogs));
        }
        //List<普通类型>，直接toString()，可以输出内容。
        System.out.println(s.toString().equals(ss.toString()));
        System.out.println(s.toString());
        //List<对象类型>，直接toString()，若对应model没复写toString()方法，输出是地址；复写toString()之后，输出就不是地址。
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(list1.toString().equals(list2.toString()));
    }

    private static void emptyListToArray() {
        List<String> list = Lists.newArrayList();
        String[] array = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 测试 guava Lists
     */
    private static void testLists() {

        List<String> list1 = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            list1.add(i + "");
        }
        System.out.println("list1: " + list1);
        List<String> list2 = Lists.newArrayList("1", "2", "3");
        System.out.println("list2: " + list2);
        List<String> list3 = Lists.newArrayList(new String[]{"22", "22"});
        System.out.println("list3: " + list3);
        List<String> list4 = Lists.newArrayList(list1);
        System.out.println("list4: " + list4);

        //下面的这个写法呢是在初始化list的时候，说明容器的扩容界限值

        //使用条件：你确定你的容器会装多少个，不确定就用一般形式的

        //说明：这个容器超过10个还是会自动扩容的。不用担心容量不够用。默认是分配一个容量为10的数组，不够将扩容
        //执行数组数据迁移操作：新建新数组，复制就数组数据到新数组（包括开辟新空间，copy数据等等，耗时，耗性能）

        //对下数字10的说明：若直接new一个list的话，默认大小是10的数组，下面的方式则是 5L + x + x/10 = 16L(x = 10)，在17的时候扩容

        //整个来说的优点有：节约内存，节约时间，节约性能。代码质量提高。
        List<String> list = Lists.newArrayListWithExpectedSize(10);

        //这个方法就是直接返回一个10的数组。
        List<String> list_ = Lists.newArrayListWithCapacity(10);
    }
}
