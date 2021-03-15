package com.lxk.me;

import com.fusion.match.factory.QueryFilterParserFactory;
import com.fusion.match.lucene.QueryFilter;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author LiXuekai on 2020/12/16
 */
public class Test {
    protected static final Map<String, Object> map = Maps.newLinkedHashMap();

    public static void main(String[] args) {
        map.put("amount", 1000);
        map.put("amount1", 1000.0);
        map.put("amountString", "1000.00");
        map.put("amountString2", "1000.00123");
        map.put("name", "lxk");
        map.put("text", "lxk");
        map.put("regex", "abcsdas+-*lxkasdh.,/");
        map.put("abc", "aaa");
        map.put("k1", "k1");
        map.put("k2", "k2");
        map.put("tom", "tom");

        String query = "tom:(a b c d to*) k1:(k ka k2)";

        QueryFilter parse;
        try {
            parse = QueryFilterParserFactory.parse(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        boolean match = parse.match(map);
        System.out.println(match);


    }
}
