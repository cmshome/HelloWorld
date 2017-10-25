package com.lxk.model;

/**
 * 为测试代码块而写的model
 * <p>
 * @author lxk on 2017/2/16
 */
public class CodeBlockModel {
    private String name;
    private String age;
    private String job;

    /**
     * 代码块
     */
    {
        System.out.println("构造代码块");
    }

    public CodeBlockModel() {
        System.out.println("无参数构造函数");
    }

    public CodeBlockModel(String name, String age, String job) {
        System.out.println("有参数构造函数");
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
