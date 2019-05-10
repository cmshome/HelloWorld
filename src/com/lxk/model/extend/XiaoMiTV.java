package com.lxk.model.extend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 小米TV
 *
 * @author LiXuekai on 2019/5/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XiaoMiTV extends TV {
    private long price;
    private String color;

    public XiaoMiTV(String id, String name, long price, String color) {
        super(id, name);
        this.price = price;
        this.color = color;
    }
}
