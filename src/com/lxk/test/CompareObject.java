package com.lxk.test;

import com.google.common.collect.Lists;
import com.lxk.model.Car;
import com.lxk.model.Dog;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Compare the difference between two objects
 * <p>
 * @author lxk on 2017/3/12
 */
public class CompareObject {
    public static void main(String[] args) {
        Car s = new Car();
        System.out.println(s);
        Dog dog1 = new Dog("大师兄的dog", true, true);
        Dog dog2 = new Dog("大师兄的dog", false, false);
        List<Dog> dogs = Lists.newArrayList();
        List<Dog> myDogs = Lists.newArrayList();
        dogs.add(dog1);
        myDogs.add(dog2);
        List<String> boys = Lists.newArrayList("tom", "jerry", "jack");
        //List<String> myBoys = Lists.newArrayList("tom", "jerry", "jack");//这行注释打开，下行代码注释掉，则boys属性就相同了
        List<String> myBoys = Lists.newArrayList("tom hanks", "gery", "pul");
        Car car1 = new Car("q7", 182, dogs, boys);
        Car car2 = new Car("a6", 152, myDogs, myBoys);
        contrastObj(car1, car2);
    }

    private static void contrastObj(Object obj1, Object obj2) {
        if (obj1 instanceof Car && obj2 instanceof Car) {
            Car pojo1 = (Car) obj1;
            Car pojo2 = (Car) obj2;
            List<String> textList = Lists.newArrayList();
            try {
                Class clazz = pojo1.getClass();
                Field[] fields = pojo1.getClass().getDeclaredFields();
                for (Field field : fields) {
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                    Method getMethod = pd.getReadMethod();
                    Object o1 = getMethod.invoke(pojo1);
                    Object o2 = getMethod.invoke(pojo2);
                    String s1 = o1 == null ? "" : o1.toString();//避免空指针异常
                    String s2 = o2 == null ? "" : o2.toString();//避免空指针异常
                    //思考下面注释的这一行：会bug的，虽然被try catch了，程序没报错，但是结果不是我们想要的
                    //if (!o1.toString().equals(o2.toString())) {
                    if (!s1.equals(s2)) {
                        textList.add("不一样的属性：" + field.getName() + " 属性值：[" + s1 + "," + s2 + "]");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            for (Object object : textList) {
                System.out.println(object);
            }
        }
    }
}
