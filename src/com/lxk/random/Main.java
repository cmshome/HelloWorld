package com.lxk.random;

import com.lxk.test.NoGroupTest;

import java.util.Random;

/**
 * @author lxk on 2018/5/3
 */
public class Main {
    public static void main(String[] args) {
        createRandom4();
    }

    /**
     * 使用随机算法产生一个数，要求把1-1000W之间这些数全部生成。
     * {@link NoGroupTest#testRandom()}
     */
    private static void createRandom4() {
        Random random = new Random();
        long start = System.currentTimeMillis();
        int value = 10000000;
        //使用数组速度更快，不到一秒。
        int[] list = new int[value];
        //十几秒
        //Integer[] list = new Integer[value];

        for (int j = 1; j <= value; ++j) {
            list[j-1] = j;
        }

        int index = 0;
        int count = 0;
        int tmp = 0;
        while (value > 0) {
            index = random.nextInt(value);
            tmp = list[count + index];
            list[count + index] = list[count];
            list[count] = tmp;
            ++count;
            --value;
        }

        long end = System.currentTimeMillis();
        //输出扰乱之后的集合
        //for (Integer integer : list) {
        //    System.out.print(integer + " ");
        //}
        //System.out.println();
        //----验证是否正确
        //前提是使用Integer对象数组，而不是int数组。
        //List<Integer> res = Lists.newArrayList(Arrays.asList(list));
        //Collections.sort(res);
        //for (int i = 0; i < res.size(); ++i) {
        //    //System.out.print(res.get(i) + " ");
        //    if (res.get(i) != (i + 1)) {
        //        System.out.println(i + "error" + res.get(i));
        //    }
        //}
        //----验证是否正确
        //System.out.println();
        System.out.println("create4------");
        System.out.println("执行耗时 : " + (end - start) / 1000f + " 秒 ");
        System.out.println("完了，集合大小为" + list.length);
    }
}
