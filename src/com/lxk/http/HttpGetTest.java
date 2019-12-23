package com.lxk.http;

import com.lxk.util.HttpClientUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.junit.Test;

import java.io.IOException;

/**
 * @author LiXuekai on 2019/12/17
 */
public class HttpGetTest {
    @Test
    public void test() {
        String url = "http://localhost:8888/lxk/test/";
        try {
            String tokenKey = "token";
            String tokenValue = "1234567890";
            HttpClientUtils.HttpClientResult doGet = HttpClientUtils.doGet(url, tokenKey, tokenValue);
            System.out.println(doGet.getContent());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static CookieStore setCookieStore(HttpResponse httpResponse) {

        CookieStore cookieStore = new BasicCookieStore();
        //Set-Cookie由服务器发送，它包含在响应请求的头部中。它用于在客户端创建一个Cookie
        // JSESSIONID
        String setCookie = httpResponse.getFirstHeader("Set-Cookie").getValue();
        String JSESSIONID = setCookie.substring("JSESSIONID=".length(), setCookie.indexOf(";"));
        System.out.println("JSESSIONID:" + JSESSIONID);
        // 新建一个Cookie
        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", JSESSIONID);
        cookie.setVersion(0);
        cookie.setDomain("127.0.0.1");
        cookie.setPath("/LoginClient");

        cookieStore.addCookie(cookie);

        return cookieStore;
    }
}
