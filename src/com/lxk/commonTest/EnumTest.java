package com.lxk.commonTest;

import com.lxk.model.enumModel.GameEnum;
import com.lxk.model.enumModel.SeasonEnum;
import com.lxk.model.enumModel.TypeEnum;

import java.util.List;

/**
 * Java枚举用法测试
 * <p>
 * @author lxk on 2016/12/15
 */
public class EnumTest {
    public static void main(String[] args) {
        forEnum();
        useEnumInJava();
        testNewEnum();
        testEnumEqual();
    }

    /**
     * 测试枚举比较,使用equal和==
     */
    private static void testEnumEqual() {
        GameEnum s1 = GameEnum.BIG;
        GameEnum s2 = GameEnum.BIG;
        GameEnum ss1 = GameEnum.SMALL;
        System.out.println("s1 == s2：" + (s1 == s2));
        System.out.println("s1.equals(s2)：" + (s1.equals(s2)));

        System.out.println("s1 == ss1：" + (s1 == ss1));
        System.out.println("s1.equals(ss1)：" + (s1.equals(ss1)));
    }

    /**
     * 测试新建某个枚举的枚举变量
     * @see GameEnum
     * @see com.lxk.collectionTest.GetDifferenceSet#getDifferenceSetByGuava(List, List)
     */
    private static void testNewEnum() {
        GameEnum s = GameEnum.BIG;
        GameEnum ss = GameEnum.SMALL;
        GameEnum sss = GameEnum.FATTER;
    }

    /**
     * 循环枚举,输出ordinal属性；若枚举有内部属性，则也输出。(说的就是我定义的TYPE类型的枚举的typeName属性)
     */
    private static void forEnum() {
        for (SeasonEnum seasonEnum : SeasonEnum.values()) {
            System.out.println(seasonEnum + "  ordinal  " + seasonEnum.ordinal());
        }
        System.out.println("------------------");
        for (TypeEnum typeEnum : TypeEnum.values()) {
            System.out.println("type = " + typeEnum + "    type.name = " + typeEnum.name() + "   typeName = " + typeEnum.getTypeName() + "   ordinal = " + typeEnum.ordinal());
        }
    }

    /**
     * 在Java代码使用枚举
     */
    private static void useEnumInJava() {
        String typeName = "f5";
        TypeEnum typeEnum = TypeEnum.fromTypeName(typeName);
        if (TypeEnum.BALANCE.equals(typeEnum)) {
            System.out.println("根据字符串获得的枚举类型实例跟枚举常量一致");
        } else {
            System.out.println("大师兄代码错误");
        }
    }

}
