package com.lxk.commonTest;

import com.google.common.collect.Lists;
import com.lxk.model.CEO;
import com.lxk.model.Employee;
import com.lxk.model.Manager;
import com.lxk.model.Point;

import java.util.List;

/**
 * 测试泛型
 * <p>
 * @author lxk on 2017/6/14
 */
public class TTest {
    public static void main(String[] args) {
        testQuestionMark();
        testSuperT();
        testExtendsT();
    }

    /**
     * 测试泛型中的通配符：？  顺路就把extends给测啦。
     * 结论：
     * <? extends XXX>指填充为派生于XXX的任意子类
     * 利用<? extends XXX>定义的变量，只可取其中的值，不可修改
     */
    private static void testQuestionMark() {
        Point<Integer> integerPoint = new Point<>(10, 10);
        Point<Float> floatPoint = new Point<>(10.f, 10.f);
        Point<Double> doublePoint = new Point<>(10.d, 10.d);
        //Point<String> stringPoint = new Point<>("你猜", "我不猜");
        Point<?> point;
        point = integerPoint;
        System.out.println("x:"+point.getX()+" y:" + point.getY());
        //point.setX(10);//利用<? extends Number>定义的变量，只可取其中的值，不可修改
        point = floatPoint;
        System.out.println("x:"+point.getX()+" y:" + point.getY());
        point = doublePoint;
        System.out.println("x:"+point.getX()+" y:" + point.getY());
        //point = stringPoint;//若是在类中使用了extends number，那么这个类型就必须得是数字啦
        //System.out.println("x:"+point.getX()+" y:" + point.getY());
        List<Point<?>> list = Lists.newArrayList();
        list.add(integerPoint);
        list.add(floatPoint);
        list.add(doublePoint);
        System.out.println(list.toString());
    }


    /**
     * 测试Java泛型中的extends
     */
    private static void testExtendsT() {
    }

    /**
     * 测试Java泛型中的super
     * <? super XXX>则表示填充为任意XXX的父类
     *
     */
    private static void testSuperT() {
        List<? super Manager> sup;
        List<Employee> employeeList = Lists.newArrayList();
        sup = employeeList;
        List<Manager> managerList = Lists.newArrayList();
        sup = managerList;
        //List<CEO> ceoList = Lists.newArrayList();//不是其父类
        //sup = ceoList;
        //编译器无法确定<? super Manager>的具体类型，但唯一可以确定的是Manager()、CEO()肯定是<? super Manager>的子类，
        // 所以肯定是可以add进去的。但Employee不一定是<? super Manager>的子类，所以不能确定，
        // 不能确定的，肯定是不允许的，所以会报编译错误。
        //sup.add(new Employee());//报错
        sup.add(new Manager());//添加这个会被转成Manager类型
        sup.add(new CEO());//添加这个会被转成Manager类型
        Manager s = (Manager) sup.get(0);//道理同上
    }
}
