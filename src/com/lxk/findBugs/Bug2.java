package com.lxk.findBugs;

import com.google.common.collect.Lists;
import com.lxk.model.Car;
import com.lxk.model.Dog;
import com.lxk.model.Student;

/**
 * 引用传递也就是地址传递需要注意的地方，引起的bug
 * <p>
 * @author lxk on 2017/3/23
 */
public class Bug2 {
    public static void main(String[] args) {
        Student student1 = new Student();
        Car car = new Car("oooo", 100, Lists.newArrayList(new Dog("aaa",true,true)));
        student1.setCar(car);
        student1.setName("lxk");
        //克隆完之后，student1和student2应该没关系的，修改student1不影响student2的值，但是完之后发现，你修改car的值，student2也受影响啦。
        Student student2 = student1.clone();
        System.out.println("学生2：" + student2);//先输出student2刚刚克隆完之后的值，然后在修改student1的相关引用类型的属性值(car)和基本属性值(name)
        car.setSign("X5");
        car.setMyDog(null);
        student1.setName("xxx");
        System.out.println("学生2：" + student2);//再次输出看修改的结果
    }
}
