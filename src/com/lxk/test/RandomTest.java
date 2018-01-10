package com.lxk.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 随机数测试
 *
 * @author lxk on 2018/1/10
 */
public class RandomTest {
    public static void main(String[] args) {
        Integer integer = 10;
        getFullRandomArray(integer);
    }

    /**
     * 根据给定长度n，获得内容为0到n-1的一个随机的数组。
     *
     * @param length 给定数组长度
     */
    private static void getFullRandomArray(Integer length) {
        Set<Integer> set = Sets.newHashSet();
        List<Integer> list = Lists.newArrayListWithExpectedSize(length);
        while (set.size() < length) {
            Integer temp = new Random().nextInt(length);
            System.out.println(temp);
            if (set.add(temp)) {
                list.add(temp);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
