package com.lxk.collectionTest;

import java.util.Collections;
import java.util.List;

/**
 * 测试 Collections.emptyList() 所得到的集合的操作
 * <p>
 * @author lxk on 2017/3/23
 */
public class EmptyList {
    public static void main(String[] args) {
        Collections.emptyList();
        List<String> list = Collections.emptyList();
        System.out.println(list.size());
        System.out.println(list.toString());
        for (String s : list) {
            System.out.println(s);
        }
        try {
            list.add("");//异常
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

