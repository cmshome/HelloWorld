package com.lxk.formatTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 数字格式化测试
 * <p>
 *
 * @author lxk on 2017/1/22
 */
public class NumberFormatTest {
    public static void main(String[] args) {
        //beforeTestGroup();
        scientificNumber();
    }

    /**
     * 科学计数法的还原
     */
    private static void scientificNumber() {
        double bigValue = 6.21482E+18D;
        System.out.println(bigValue);

        DecimalFormat df = new DecimalFormat("0");
        System.out.println(df.format(bigValue));

        double num2 = 50123.12;
        System.out.println(num2);
        BigDecimal bd2 = new BigDecimal(num2);
        System.out.println(bd2.toPlainString());
        System.out.println(df.format(num2));

        BigDecimal bd = new BigDecimal("1.1920928955078125e-7");
        String str = bd.toPlainString();
        System.out.println(str);
    }

    private static void beforeTestGroup() {
        Float result;
        //result = 9.313226E-10,也就是0.0000000009313226
        //result = ((float) 1L) / (1024L * 1024L * 1024L);
        //result = 1230.5F;
        result = 1230.55F;
        //result = 1230.466F;
        System.out.println("-------------我是分界线-------------");
        showFormat(result);
        //result = 10.5F;
        //result = 10.4F;
        result = 10.6F;
        System.out.println("-------------我是分界线-------------");
        showFormatMore(result);
    }

    /**
     * 测试各种舍入模式的不同
     *
     * @param result 待格式化的参数
     */
    private static void showFormatMore(Float result) {
        System.out.println("初始值：" + result.toString());
        DecimalFormat decimalFormat = new DecimalFormat("0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        System.out.println("HALF_EVEN：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("HALF_UP：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
        System.out.println("HALF_DOWN：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        System.out.println("FLOOR：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        System.out.println("CEILING：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.UP);
        System.out.println("UP：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println("DOWN：" + decimalFormat.format(result));
    }

    /**
     * 打印数据遭格式化之后的效果(默认是HALF_EVEN，他不是四舍五入，)
     *
     * @param value 待格式化的参数
     */
    private static void showFormat(Float value) {
        System.out.println("初始值：" + value.toString());
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
