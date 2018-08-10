package com.lxk.model;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class Car implements Cloneable, Comparable<Car> , Serializable {
    private String sign;
    private int price;
    private List<Dog> myDog;
    private List<String> boys;

    public Car() {
    }

    public Car(String sign, int price) {
        this.sign = sign;
        this.price = price;
    }

    public Car(String sign, int price, List<Dog> myDog) {
        this.sign = sign;
        this.price = price;
        this.myDog = myDog;
    }

    public Car(String sign, int price, List<Dog> myDog, List<String> boys) {
        this.sign = sign;
        this.price = price;
        this.myDog = myDog;
        this.boys = boys;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Dog> getMyDog() {
        return myDog;
    }

    public void setMyDog(List<Dog> myDog) {
        this.myDog = myDog;
    }

    public List<String> getBoys() {
        return boys;
    }

    public void setBoys(List<String> boys) {
        this.boys = boys;
    }

    @Override
    public int compareTo(Car o) {
        //同理也可以根据sign属性排序，就不举例啦。
        return this.getPrice() - o.getPrice();
    }

    @Override
    public String toString() {
        return "Car{" +
                "sign='" + sign + '\'' +
                ", price=" + price +
                ", myDog=" + myDog +
                ", boys=" + boys +
                '}';
    }

    @Override
    public Car clone() {
        Car car = null;
        try {
            car = (Car) super.clone();
            if (myDog != null) {
                car.setMyDog(Lists.newArrayList(myDog));
            }
            if (boys != null) {
                car.setBoys(Lists.newArrayList(boys));
            }
        } catch (CloneNotSupportedException ignored) {
            System.out.println(ignored.getMessage());
        }
        return car;
    }
}