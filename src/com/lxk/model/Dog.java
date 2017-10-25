package com.lxk.model;

import com.google.common.base.Objects;

/**
 * 测试boolean属性的getter和setter
 * <p>
 * @author lxk on 2016/12/23
 */
public class Dog {
    private String name;
    private boolean isLoyal;//是忠诚的
    private boolean alive;//活蹦乱跳的

    public Dog() {
    }

    public Dog(boolean isLoyal, boolean alive) {
        this.isLoyal = isLoyal;
        this.alive = alive;
    }

    public Dog(String name, boolean isLoyal, boolean alive) {
        this.name = name;
        this.isLoyal = isLoyal;
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLoyal() {
        return isLoyal;
    }

    public void setLoyal(boolean loyal) {
        isLoyal = loyal;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dog)) {
            return false;
        }
        Dog dog = (Dog) o;
        return Objects.equal(getName(), dog.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", isLoyal=" + isLoyal +
                ", alive=" + alive +
                '}';
    }
}
