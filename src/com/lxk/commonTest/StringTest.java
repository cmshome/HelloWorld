package com.lxk.commonTest;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * String字符串测试
 * <p>
 *
 * @author lxk on 2017/2/8
 */
public class StringTest {
    public static void main(String[] args) {
        //testValueAndAddressTransmit();
        //testStringBufferAndStringBuilder();
        //testStringNewLine();
        //testSplit();
        //testStringPool2();
        //testListToString();
        //testReverseString();
        //testStringToChar();
        //testStringPool();
        //testIndexOf();
        //testSplitPlus();
        //testNewStringArray();
        //testStringIntern();
        testManyArgs();
    }

    /**
     * 可变参数的测试
     * 可变参数的定义，必须是放在参数列表的最后面
     */
    private static void testManyArgs() {
        int d = 1;
        System.out.println(isNotNullOrEmpty(d, "a"));
        System.out.println(isNotNullOrEmpty(d, "a", "b"));
        System.out.println(isNotNullOrEmpty(d, "a", "b", ""));
    }

    private static boolean isNotNullOrEmpty(int d, String... arg) {
        System.out.println(d);
        for (String s : arg) {
            if (Strings.isNullOrEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * intern方法测试，讲字符串加入到常量池 native 方法。
     */
    private static void testStringIntern() {
        String s1 = "go" + "od";
        String s2 = "ja" + "va";
        //true
        System.out.println(s1.intern() == s1);
        //true
        System.out.println(s2.intern() == s2);
    }

    /**
     * 测试一个新建字符串的不常见姿势
     */
    private static void testNewStringArray() {
        String[] command = new String[]{"sh", "-c", "ps -ef | grep \""
                + "d:test" + "\" | grep \"" + "d:test" + "\" | grep -v \"grep\" | awk '{ print $2}'"};
        System.out.println(Arrays.toString(command));
        //结果如下：
        //[sh, -c, ps -ef | grep "d:test" | grep "d:test" | grep -v "grep" | awk '{ print $2}']
    }

    /**
     * 使用indexOf()来拆分字符串：D:\Android\sdk\add-ons
     */
    private static void testIndexOf() {
        String string = "aaa456ac";

        //查找指定字符是在字符串中的下标。在则返回所在字符串下标；不在则返回-1.
        System.out.println(string.indexOf("b"));//indexOf(String str)；返回结果：-1，"b"不存在

        // 从第四个字符位置开始往后继续查找，包含当前位置
        System.out.println(string.indexOf("a", 3));//indexOf(String str, int fromIndex)；返回结果：6

        //（与之前的差别：上面的参数是 String 类型，下面的参数是 int 类型）参考数据：a-97,b-98,c-99

        // 从头开始查找是否存在指定的字符
        System.out.println(string.indexOf(99));//indexOf(int ch)；返回结果：7
        System.out.println(string.indexOf('c'));//indexOf(int ch)；返回结果：7

        //从fromIndex查找ch，这个是字符型变量，不是字符串。字符a对应的数字就是97。
        System.out.println(string.indexOf(97, 3));//indexOf(int ch, int fromIndex)；返回结果：6
        System.out.println(string.indexOf('a', 3));//indexOf(int ch, int fromIndex)；返回结果：6

        //这个就是灵活运用String类提供的方法，拆分提供的字符串。
        String s = "D:\\Android\\sdk\\add-ons";
        System.out.println(s);
        while (s.lastIndexOf("\\") > 0) {
            s = s.substring(0, s.lastIndexOf("\\"));
            System.out.println(s);
        }
    }

    /**
     * 将字符串倒序
     */
    private static void testReverseString() {
        String string = "please call me big brother";
        char[] chars = string.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            char temp;
            temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }
        System.out.println(chars);
    }

    /**
     * 将list的内容以逗号间隔，最后不应该多个逗号。
     */
    private static void testListToString() {
        List<String> s = Lists.newArrayList("1", "2", "3");
        StringBuilder sb = new StringBuilder();
        for (String s1 : s) {
            sb.append(s1).append(",");
        }
        System.out.println(sb.toString().substring(0, sb.lastIndexOf(",")));
        System.out.println("等效的快捷方式");
        Joiner joiner = Joiner.on(",").skipNulls();//跳过null
        //System.out.println(joiner.join(s));
        System.out.println(joiner.join(s.toArray()));
    }

    /**
     * 测试string转换成char类型
     */
    private static void testStringToChar() {
        String s = "abcdefghi";
        char result[] = s.toCharArray();
        char ss = s.toCharArray()[0];
        System.out.println(ss);
        System.out.println(result);
        char char0 = s.charAt(0);
        System.out.println(char0);
    }

    /**
     * 还是测试字符串 ==
     */
    private static void testStringPool2() {
        String s0 = "ab";
        String s1 = "a";
        String s3 = "a" + "b";
        String s2 = s1 + "b";
        System.out.println(s0 == s3);
        System.out.println(s2 == s3);
    }

    /**
     * 测试字符串的 split()
     * 返回的数组，若末尾有一连串空的，则舍弃
     */
    private static void testSplit() {
        String ss = ",aa,bb,cc,dd,,,";
        String[] array = ss.split(",");

        System.out.println(array.length);//结果是5，而不是预想中的8
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 字符串 split()新发现
     */
    private static void testSplitPlus() {
        String ss = "aa12sas32sasa223sas12as12wqe";
        String[] array = ss.split("[\\d]+");
        System.out.println(Arrays.toString(array));
        ss = "aa,,sas,,sasa,,,,sasas,,,";
        array = ss.split("[,]+");
        System.out.println(Arrays.toString(array));
        ss = "aa  sas sa sa     sas  as  ";
        array = ss.split("[\\s]+");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 测试代码中的换行："\r\n"和<br>
     */
    private static void testStringNewLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("大").append("\r\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * StringBuffer和StringBuilder的使用
     */
    private static void testStringBufferAndStringBuilder() {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sbf.append("这是第").append(i).append("个; ");
        }
        System.out.println(sbf);
        System.out.println(sbf.indexOf("7"));
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sbd.append("这是第").append(i).append("个; ");
        }
        System.out.println(sbd);
        System.out.println(sbd.indexOf("7"));
    }

    /**
     * 测试值传递和地址传递
     * 结论。
     * 字符串：不管是new出来的对象，还是直接用=声明的都是值传递
     * 基本数据类型：同理，也是值传递。
     */
    private static void testValueAndAddressTransmit() {
        String transmitValue = "初始值";
        String transmitValueNew = new String("new 出来的字符串");
        Integer integer = new Integer(900);
        List<String> list = Lists.newArrayList();
        list.add("0");
        testTransmitValue(transmitValue, transmitValueNew, list, integer);
        System.out.println(transmitValue);
        System.out.println(transmitValueNew);
        System.out.println(list.toString());
        System.out.println(integer);
    }

    /**
     * 测试字符串和集合在函数之间的传值问题,解决值传递和地址传递的疑惑.
     */
    private static void testTransmitValue(String transmitValue, String transmitValueNew, List<String> list, Integer integer) {
        transmitValue += "修改的痕迹";
        transmitValueNew += "assss修改的痕迹";
        list.add("1");
        list.add("2");
        list.add("3");
        integer = 9999;
    }

    /**
     * 测试字符串常量池的问题
     */
    private static void testStringPool() {
        String a = "abc";//字面量形式
        String b = "abc";//字面量形式
        String c = new String("abc");//使用new标准的构造对象
        /*
            注意：这个虽然看起来似乎要在常量池新建三个字符串对象：ab，c，和拼接生成的abc
            但是结果是内存中仅有生成的，前面的两个算是过程变量。这反编译得出来的结论，我没测试哟！
            这样做实际上是一种优化，避免了创建多余的字符串对象，也没有发生字符串拼接问题
         */
        String d = "ab" + "c";//字面量形式
        System.out.println("a == b " + (a == b));//true
        System.out.println("a == c " + (a == c));//false
        System.out.println("a == d " + (a == d));//true
        System.out.println("b == c " + (b == c));//false
        System.out.println("b == d " + (b == d));//true
        System.out.println("c == d " + (c == d));//false
        System.out.println("-----------------");
        System.out.println("abc" == ("ab" + "c"));//true
        System.out.println("-----------------");
        String e = c.intern();//将new出来的字符串对象加入字符串常量池
        System.out.println(a == e);//true
        /*
            Java中字符串对象创建有两种形式。
            一种为字面量形式，如String str = "droid";，
            另一种就是使用new这种标准的构造对象的方法，如String str = new String("droid");
            这两种方式我们在代码编写时都经常使用，尤其是字面量的方式。然而这两种实现其实存在着一些性能和内存占用的差别。
            这一切都是源于JVM为了减少字符串对象的重复创建，其维护了一个特殊的内存，这段内存被成为字符串常量池或者字符串字面量池。
            工作原理
            当代码中出现字面量形式创建字符串对象时，JVM首先会对这个字面量进行检查。
            如果字符串常量池中存在相同内容的字符串对象的引用，则将这个引用返回。
            否则新的字符串对象被创建，然后将这个引用放入字符串常量池，并返回该引用。
         */
        System.out.println("-----------new test -----");
        String aa = "hello2";
        final String bb = "hello";
        String dd = "hello";
        String cc = bb + 2;
        String ee = dd + 2;
        String ff = "hello" + 2;
        System.out.println("------aa 和 cc ee ff 比较--------");
        System.out.println("aa == cc " + (aa == cc));//true,因为bb是final类型(这个会因为bb是否是final而结果不同，)
        System.out.println("aa == ee " + (aa == ee));//false
        System.out.println("aa == ff " + (aa == ff));//true,因为ff是直接由字面量形式创建出来的，不经过中间变量。
        //ff为字符串直接拼出来的，不经过中间变量。
        System.out.println("------ff 和 aa cc ee 比较--------");
        System.out.println("ff == aa " + (ff == aa));//true,因为ff是直接由字面量形式创建出来的，不经过中间变量。
        System.out.println("ff == cc " + (ff == cc));//true,因为bb是final类型(这个会因为bb是否是final而结果不同，)
        System.out.println("ff == ee " + (ff == ee));//false
    }
}
