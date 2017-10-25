package com.lxk.sort;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 * @author lxk on 2017/7/11
 */
public class KuaiSu {
    public static void main(String[] args) {
        int[] ints = {12, 2, 2, 5, 7, 15};
        quickSort(ints, 0, ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * @param array 排序数组
     * @param start 数组下标start 0
     * @param end   数组下标end
     */
    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int i = start, j = end, x = array[start];
            while (i < j) {
                while (i < j && array[j] >= x) // 从右向左找第一个小于x的数
                {
                    j--;
                }
                if (i < j) {
                    array[i++] = array[j];
                }

                while (i < j && array[i] < x) // 从左向右找第一个大于等于x的数
                {
                    i++;
                }
                if (i < j) {
                    array[j--] = array[i];
                }
            }
            array[i] = x;
            quickSort(array, start, i - 1); // 递归调用
            quickSort(array, i + 1, end);
        }
    }
}
