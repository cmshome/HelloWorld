package com.lxk.json;

import com.alibaba.fastjson.JSON;
import com.dslplatform.json.DslJson;
import com.dslplatform.json.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Map;

/**
 * 读的一个很大的19M的一个json字符串，转map的效率测试
 * 比较了fastjson、jackson、dsljson 三个对比。
 *
 * @author LiXuekai on 2019/5/21
 */
public class TestJson {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public static String[] factors = {};
    private static String JSON_STR = null;
    private static int count = 0;
    private final DslJson<Object> dslJson = new DslJson<Object>();

    //@Test
    //public void testJsoniter2() throws IOException {
    //    JsonIterator jsonIterator = JsonIterator.parse("[123,{'id':20, 'errorMsg':'this error'},456]".replace('\'', '"'));
    //    AtomicReference<ErrorMessage> errorMessage = new AtomicReference<>();
    //    jsonIterator.readAny().forEach(any -> {
    //        if (any.valueType() == ValueType.OBJECT) {
    //            errorMessage.set(any.as(ErrorMessage.class));
    //        }
    //    });
    //    Console.print(errorMessage.get());
    //    Assert.isTrue(true, "Not to false");
    //}

    //@Test
    //public void testJsoniter() throws IOException {
    //    JsonIterator jsonIterator = JsonIterator.parse("{'id':10, 'errorMsg':'this error'}".replace('\'', '"'));
    //    ErrorMessage errorMessage = jsonIterator.read(ErrorMessage.class);
    //    Assert.notNull(errorMessage, "can't be empty ");
    //}

    @Test
    public void testFor() throws IOException {
        File file = new File("/Users/fang/Downloads/lxk-out.txt");
        file.mkdirs();
        PrintWriter printWriter = new PrintWriter(file);
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        for (int i = 0; i < 1000000; i++) {
            if (i == 999999) {
                buffer.append("\"k" + i + "\":" + "\"v" + i + "\"" + "}");
                break;
            }
            buffer.append("\"k" + i + "\":" + "\"v" + i + "\"" + ",");
        }
        printWriter.println(buffer.toString());
        printWriter.flush();
    }

    @Before
    public void init() throws Exception {
        FileReader fis = new FileReader(new File("/Users/fang/Downloads/lxk-out.txt"));
        BufferedReader br = new BufferedReader(fis);
        JSON_STR = br.readLine();
    }

    @Test
    public void test() throws IOException {
        int i = 0;
        int max = 5;
        while (i < max) {
            fastJson();
            jackson();
            dslJsonTest();
            System.out.println("-----");
            i++;
        }
    }

    private void dslJsonTest() throws IOException {
        count = 0;
        long a = System.currentTimeMillis();
        final byte[] buff = JSON_STR.getBytes("UTF-8");
        JsonReader<Object> jsonReader = dslJson.newReader(buff);
        Map map = jsonReader.next(Map.class);
        map.forEach((k, v) -> {
            count++;
        });
        System.out.println("testDslJson 执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
    }

    private void jackson() throws IOException {
        count = 0;
        long a = System.currentTimeMillis();
        Map<String, String> map = MAPPER.readValue(JSON_STR, Map.class);
        map.forEach((k, v) -> {
            count++;
        });
        System.out.println("testJackson 执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
    }

    private void fastJson() {
        count = 0;
        long a = System.currentTimeMillis();
        Map<String, String> map = JSON.parseObject(JSON_STR, Map.class);
        map.forEach((k, v) -> {
            count++;
        });
        System.out.println("testFastJson 执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
    }

    @Test
    public void testFastJson() {
        fastJson();
    }

    //@Test
    //public void testJsoniter03() throws IOException {
    //    long startTime = System.currentTimeMillis();
    //    JsonIterator jsonIterator = JsonIterator.parse(JSON_STR);
    //    Map<String, String> map = jsonIterator.readAny().as(Map.class);
    //    map.forEach((k, v) -> {
    //        count++;
    //    });
    //    System.out.println(System.currentTimeMillis() - startTime);
    //    System.out.println(count);
    //}

    @Test
    public void testJackson() throws IOException {
        jackson();
    }

    @Test
    public void testDslJson() throws IOException {
        dslJsonTest();
    }
}
