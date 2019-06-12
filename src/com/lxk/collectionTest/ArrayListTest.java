package com.lxk.collectionTest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lxk on 2017/2/13
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //setIndexValue();
        setIndexValue2();
        //testSortList();
        //testAddAllNull();
        //haveSameMember();
        //myToString();
    }

    /**
     * Collections.nCopies(int n, T o)  创建一个包含n个重复元素o的集合
     * 测试可以随意使用这个 set(int index, E element)
     * 随意设置index是n的value，而不会出现 IndexOutOfBoundsException 异常
     */
    @SuppressWarnings("unchecked")
    private static void setIndexValue2() {
        List<String> list = new ArrayList(Collections.nCopies(5, "123"));
        System.out.println(list.toString());
        list.set(3,"999");
        System.out.println(list.toString());
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("sss");
    }

    /**
     * 数组初始化，以及打印输出数组的内容。
     */
    private static void myToString() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(ints));
    }

    /**
     * list.addAll(null)异常
     */
    private static void testAddAllNull() {
        List<String> list = Lists.newArrayList();
        list.add(null);
        list.add(null);
        list.add(null);
        list.addAll(null);
    }

    private static void testSortList() {
        List<Integer> list = Lists.newArrayList(5,2,13,4,22,3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    /**
     * 注意在使用 set(int index, E element) 一个不注意，就会异常。
     * size()表示当前集合包含的element的个数
     * add（index ， element）。这个不仅仅是把index位置的数据给替换啦，而且把之前这个位置的数据给依次向后移动啦
     * set(int index, E element)。这个index要是大于等于size，就报异常啦。
     */
    private static void setIndexValue() {
        List<String> list = new ArrayList<>(2);
        System.out.println("list大小为：" + list.size());
        list.add("12");
        System.out.println("list大小为：" + list.size());
        //这个时候，size为1，要是set index == 1 地方的值，就异常啦。IndexOutOfBoundsException
        list.set(1, "sss");
        list.add(1, "放在下标为1的位置");
        list.add("22");
        System.out.println("list大小为：" + list.size());
        System.out.println(list.toString());
        list.add(1, "放在下标为1的位置2");
        System.out.println("list大小为：" + list.size());
        System.out.println(list.toString());
    }

    /**
     * 取2个list的交集
     */
    private static void haveSameMember() {
        List<String> list1 = Lists.newArrayList("1","2","3","4","5","6");
        List<String> list2 = Lists.newArrayList("8","2","44");
        list2.retainAll(list1);
        System.out.println(list1);
        System.out.println(list2);

    }
}
