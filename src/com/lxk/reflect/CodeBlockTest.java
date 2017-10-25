package com.lxk.reflect;

import com.lxk.reflect.classloaderAndForName.Line;

/**
 * 代码块执行顺序测试
 * <p>
 * @author lxk on 2017/2/21
 */
public class CodeBlockTest {
    public static void main(String[] args) {
        System.out.println("主方法");
        //普通代码块：在方法或语句中出现的{}就称为普通代码块。
        //普通代码块和一般的语句执行顺序由他们在代码中出现的次序决定--“先出现先执行”
        {
            System.out.println("main方法中最开始的，普通代码块执行");
        }
        Line line = new Line();
        System.out.println("...............");
        Line line1 = new Line();
        System.out.println("...............");
        {
            System.out.println("main方法中结尾事的，普通代码块执行");
        }
    }
}
