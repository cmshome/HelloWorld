package com.lxk.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 首先任意选取一个数据（通常选用数组的第一个数）作为关键数据，然后将所有比它小的数都放到它前面，
 * 所有比它大的数都放到它后面，这个过程称为一趟快速排序。
 * 值得注意的是，快速排序不是一种稳定的排序算法，
 * 也就是说，多个相同的值的相对位置也许会在算法结束时产生变动。
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
