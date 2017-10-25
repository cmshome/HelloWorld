package com.lxk.guavaTest;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

/**
 * 测试 String处理相关的几个工具
 * <p>
 * @author lxk on 2016/11/18
 */
public class StringToolsTest {
    public static void main(String[] args) {
        String targetString = getTargetString();
        commonNullOrEmpty(targetString);
        toolsNullOrEmpty(targetString);
        System.out.println(toolJoinerTest());
    }

    /**
     * 获得要判断的目标字符串
     */
    private static String getTargetString() {
        return "sss";
    }

    /**
     * 一般判断字符串null或empty
     */
    private static void commonNullOrEmpty(String targetString) {
        if (targetString == null || targetString.length() == 0) {
            System.out.println("targetString is null or empty.");
        } else {
            System.out.println("targetString is not null or empty.");
        }
    }

    /**
     * guava 工具判断字符串null或empty
     * (其实内部实现就是上面的一般判断方法，有工具不用，干嘛每次都自己啰嗦一遍)
     */
    private static void toolsNullOrEmpty(String targetString) {
        if (Strings.isNullOrEmpty(targetString)) {
            System.out.println("targetString is null or empty.");
        } else {
            System.out.println("targetString is not null or empty.");
        }
    }

    /**
     * guava 工具用分隔符把字符串序列连接起来
     * (处理字符串序列中有null)
     */
    private static String toolJoinerTest() {
        Joiner joiner = Joiner.on("-").skipNulls();//跳过null
        //joiner.join(Arrays.asList(1,2,3,4,5));//可以传集合类型参数
        Joiner joiner_ = Joiner.on("-").useForNull("*");//替换null为*
        return joiner_.join("大", null, "师", null, "胸", null, "！");
    }

}
