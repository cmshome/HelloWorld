package com.lxk.guavaTest;

import com.google.common.primitives.Ints;

import java.util.Arrays;

/**
 * @author lxk on 2018/8/9
 */
public class IntsTest {
    public static void main(String[] args) {
        ints();
    }

    private static void ints() {
        int a = 10, b =11;
        int compare = Ints.compare(a, b);
        System.out.println(compare);

        int[] numbers = { 1, 2, 3, 4, 5 };
        int[] array = { 1, 2, 3, 4, 5 };
        System.out.println(Ints.asList(numbers));

        System.out.println(Ints.join(",",numbers));

        System.out.println("max " + Ints.max(numbers));

        System.out.println("min " + Ints.min(numbers));

        System.out.println("indexOf " + Ints.indexOf(numbers, 3));

        System.out.println("contains " + Ints.contains(numbers, 3));

        System.out.println("concat " + Arrays.toString(Ints.concat(numbers, array)));

    }
}
