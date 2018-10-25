package com.lxk.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 鸟
 *
 * @author LiXuekai on 2018/10/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bird {
    @JSONField(ordinal = 6, name = "内容是json字符串的属性", jsonDirect = true)
    private String dog1;

    @JSONField(ordinal = 5, name = "内容是json字符串的属性,对比下差异")
    private String dog2;

    /**
     * ordinal，默认值为0，不用设置啦。
     */
    @JSONField(ordinal = 4, name = "生产日期", format = "yyyy年MM月dd日 HH时mm分ss秒")
    private Date birthday;

    @JSONField(ordinal = 3, name = "颜色")
    private String color;

    @JSONField(ordinal = 2, name = "体型大小")
    private String size;

    @JSONField(ordinal = 1, name = "年龄")
    private int age;
    /**
     * 反序列化false，那么在反序列化的时候，就不会把json的值转给对象的这个属性。
     */
    @JSONField(name = "名称", deserialize = false)
    private String name;
    /**
     * 不序列化此属性字段，那么在转json的时候，就不会在json中出现
     */
    @JSONField(ordinal = 7, name = "不序列化的属性字段", serialize = false)
    private String deserialize;


}
