package com.lxk.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * JSON 转换
 */
public final class JsonUtils {

    /**
     * 把Java对象转换成json字符串
     *
     * @param object 待转化为JSON字符串的Java对象
     * @return json 串 or null
     */
    public static <T> String parseObjToJson(T object) {
        String string = null;
        try {
            string = JSON.toJSONString(object);
            //string = JSONObject.toFormatJSONString(object);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return string;
    }

    /**
     * 将Json字符串信息转换成对应的Java对象
     *
     * @param json json字符串对象
     * @param c    对应的类型
     */
    public static <T> T parseJsonToObj(String json, Class<T> c) {
        try {
            //两个都是可行的，起码我测试的时候是没问题 的。
            //JSONObject jsonObject = JSONObject.parseObject(json);
            //JSONObject jsonObject = JSON.parseObject(json, Feature.OrderedField);
            JSONObject jsonObject = JSON.parseObject(json);
            return JSON.toJavaObject(jsonObject, c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 输出格式化的json字符串
     */
    public static String toFormatJSONString(Object o) {
        return JSON.toJSONString(o, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.PrettyFormat);
    }

    /**
     *  不格式化Json数据
     */
    public static String toNoFormatJSONString(Object o) {
        return JSON.toJSONString(o, SerializerFeature.DisableCircularReferenceDetect);
    }
}
