package com.lxk.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 房子
 *
 * @author LiXuekai on 2018/12/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    @JSONField(ordinal = 0)//默认值就是0，可以不写。
    private int size;
    @JSONField(ordinal = 1)
    private int prize;
    @JSONField(ordinal = 2)
    private String owner;
    @JSONField(ordinal = 3)
    private int age;
}
