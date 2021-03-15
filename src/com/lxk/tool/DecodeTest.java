package com.lxk.tool;

import com.lxk.util.EncryptUtil;

/**
 * @author LiXuekai on 2019/12/23
 */
public class DecodeTest {


    public static void main(String[] args) {
        String key = "CCDC_2020";
        String v = EncryptUtil.encode("104d3f42361c97077c04d04cade822999abd671e20196e1bb58b5f94dc26e3c6", key);
        System.out.println(v);
        System.out.println(EncryptUtil.decode(v, key));


        v = EncryptUtil.encode("123456", "lxk");
        System.out.println(v);
        System.out.println(EncryptUtil.decode(v, "lxk"));

    }
}
