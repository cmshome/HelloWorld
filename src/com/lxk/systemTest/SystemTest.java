package com.lxk.systemTest;

/**
 * @author lxk on 2017/12/18
 */
public class SystemTest {
    public static void main(String[] args) {
        testSystemGet();
    }

    /**
     * System.getProperty("user.dir")
     * 获得的是工作目录，非Java web项目的运行结果，就是当前项目的根目录。
     * 此处是：E:\fusion\intellij_work\HelloWorld
     * java web 项目的运行结果则是：tomcat的bin目录。
     */
    private static void testSystemGet() {
        System.out.println(System.getProperty("user.dir"));
    }
}
