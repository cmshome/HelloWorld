package com.lxk.guavaTest;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author lxk on 2017/2/28
 */
public class SetsTest {
    public static void main(String[] args) {
        List<String> big = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> small = Lists.newArrayList("1", "2", "3", "3", "2", "1");
        //long a = System.currentTimeMillis();
        List<String> guava = getDifferenceSetByGuava(big, small);
        //System.out.println("执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
        ////为了显示一致，我给集合排个序，因为guava是按newHashSet集合来整的，newHashSet又是无序的,so ...
        //Collections.sort(guava);
        //System.out.println(guava.toString());
        //testAddAllToSet();
        //testSetAddFailed();
    }

    /**
     * set add失败返回false，成功true。
     */
    private static void testSetAddFailed() {
        //Set<String> set = Sets.newHashSet("1","2");
        //String a = "a";
        //set.add(a);
        //System.out.println(set.add("1"));
        //System.out.println(2 == 1 + 1);//运算符优先级的简单测试
        List<String> list1 = Lists.newArrayList("1", "2", "3","1", "2", "3");
        List<String> list2 = Lists.newArrayList("1", "2", "3","1", "2", "3","6");
        Set<String> set1 = Sets.newHashSet(list1);
        System.out.println(set1);
    }

    /**
     * 测试一下set的addAll方法，重复的就不添加，不重复的还是可以添加的。
     */
    private static void testAddAllToSet() {
        List<String> small = Lists.newArrayList("1", "2", "3", "7", "2", "1");
        Set<String> set = Sets.newHashSet("1","2");
        set.addAll(small);
        set.forEach(System.out::println);
    }

    /**
     * 使用guava工具类来取List集合的差集--专业轮子谷歌造
     *
     * @param big   大集合
     * @param small 小集合
     * @return 两个集合的差集
     */
    private static List<String> getDifferenceSetByGuava(List<String> big, List<String> small) {
        System.out.println(big.toString());
        System.out.println(small.toString());
        //差集
        Set<String> differenceSet = Sets.difference(Sets.newHashSet(big), Sets.newHashSet(small));
        System.out.println(Arrays.toString(differenceSet.toArray()));
        //并集
        Set<String> union = Sets.union(Sets.newHashSet(big), Sets.newHashSet(small));
        System.out.println(Arrays.toString(union.toArray()));
        //交集
        Set<String> intersection = Sets.intersection(Sets.newHashSet(big), Sets.newHashSet(small));
        System.out.println(intersection.toString());
        return Lists.newArrayList(differenceSet);
    }
}
