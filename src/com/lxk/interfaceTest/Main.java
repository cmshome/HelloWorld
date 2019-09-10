package com.lxk.interfaceTest;

/**
 * @author LiXuekai on 2019/8/30
 */
public class Main {
    public static void main(String[] args) {
        Implement implement = new Implement();
        implement.loadSyncStream(System.out::println);
    }
}
