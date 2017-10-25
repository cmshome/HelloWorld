package com.lxk.formatTest;

import java.text.DecimalFormat;

/**
 * 数字格式化测试
 * <p>
 * @author lxk on 2017/1/22
 */
public class NumberFormatTest {
    public static void main(String[] args) {
        float scale = 34.236323F;
        DecimalFormat format = new DecimalFormat("##0.00");
        String dd = format.format(scale);
        System.out.println(dd);
        //下面简写
        long num = 1;
        //result = 9.313226E-10,也就是0.0000000009313226
        float result = ((float) num) / (1024L * 1024L * 1024L);
        System.out.println(result);
        System.out.println(format.format(result));
        System.out.println("-------------我是分界线---1----------");
        showFormat(scale);
        System.out.println("-------------我是分界线---2----------");
        showFormat(result);
        System.out.println("-------------我是分界线---3----------");
        long c = 299792458L;
        showFormat((float) c);
    }

    private static void showFormat(float value) {
        //取一位整数
        System.out.println(new DecimalFormat("0").format(value));
        //取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(value));
        //取两位整数和三位小数，整数不足部分以0填补
        System.out.println(new DecimalFormat("00.000").format(value));
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(value));
        //以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(value));
        //显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(value));
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(value));
        //每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(value));
        //将格式嵌入文本
        System.out.println(new DecimalFormat("所传入的格式化参数是：###大小。").format(value));
    }
}
