package com.lxk.http;

import com.google.common.collect.Lists;
import com.lxk.http.ClientException.ErrorType;
import com.lxk.util.JsonUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 底层的REST client 如果采用Tocken登录的方式，将会把Tocken带上，但这里不参与验证
 *
 * @author Johnson
 */
class Client {

    private static final String TEST_PAGE = "login/test";
    private static final int OK = 200;
    private static final int FORBIDDEN = 403;

    private static final int SOCKET_TIMEOUT = 3000;

    private static final int CONNECT_TIMEOUT = 3000;

    private static final String CHARSET = "utf-8";

    private String tocken;

    private String url;

    private int socketTimeout;

    private int connectTimeout;

    private String charset;

    public Client(String url) {
        this(url, SOCKET_TIMEOUT, CONNECT_TIMEOUT, CHARSET);
    }

    /**
     * REST客户端
     *
     * @param url            主地址，比如 127.0.0.1:8080
     * @param socketTimeout  超时时间
     * @param connectTimeout 超时时间
     * @param charset        字符编码
     */
    public Client(String url, int socketTimeout, int connectTimeout, String charset) {
        if (url.endsWith("/") || url.endsWith("\\")) {
            url = url.substring(0, url.length() - 1);
        }
        this.url = url;
        this.socketTimeout = socketTimeout;
        this.connectTimeout = connectTimeout;
        this.charset = charset;
    }

    /**
     * 设置默认的请求配置
     */
    private RequestConfig getDefaultRequestConfig() {
        // 设置请求和传输超时时间
        return RequestConfig.custom().setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectTimeout).build();
    }

    /**
     * 获取响应的正文内容
     */
    private String getResponseContent(HttpResponse response) throws ParseException, IOException {
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, charset);
    }

    /**
     * 判断当前是否是登陆状态
     */
    public boolean isLogin() {
        // 如果没有Tocken，直接返回
        if (tocken == null) {
            return false;
        }
        // 有Tocken不一定，需要访问测试页面
        try {
            httpGet(TEST_PAGE);
            return true;
        } catch (ClientException clientException) {
            System.out.println();
            System.out.println("login error" + clientException);
            return false;
        }
    }

    /**
     * 登录
     *
     * @param loginPath 登录的路径，包括用户名和密码的参数
     */
    public void login(String loginPath) throws ClientException {
        String loginUrl = this.url + "/" + loginPath;
        RequestConfig requestConfig = getDefaultRequestConfig();
        HttpGet loginRequest = new HttpGet(loginUrl);
        loginRequest.addHeader("accept", "application/json");
        if (tocken != null) {
            loginRequest.addHeader(CCSession.TOCKEN, tocken);
        }
        loginRequest.setConfig(requestConfig);
        CloseableHttpClient loginClient = HttpClients.createDefault();
        try {
            HttpResponse loginResponse = loginClient.execute(loginRequest);
            if (loginResponse.getStatusLine().getStatusCode() == OK) {
                // 返回正常，检查tocken
                Header[] hearers = loginResponse.getHeaders(CCSession.TOCKEN);
                if (hearers == null || hearers.length <= 0) {
                    throw new ClientException(ErrorType.NotLogin, getResponseContent(loginResponse));
                } else {
                    this.tocken = hearers[0].getValue();
                }
            } else {
                throw new ClientException(ErrorType.NetError, "Error Code:"
                        + loginResponse.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            System.out.println("Login Error" + e);
            throw ClientException.getClientException(e);
        } finally {
            try {
                loginClient.close();
            } catch (IOException ignore) {
            }
        }
    }

    /**
     * GET请求
     *
     * @param path Get的路径
     */
    public <T> T httpGet(String path) throws ClientException {
        String url = this.url + "/" + path;
        HttpGet getRequest = new HttpGet(url);
        getRequest.addHeader("accept", "application/json");
        if (tocken != null) {
            getRequest.addHeader(CCSession.TOCKEN, tocken);
        }
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpResponse response = client.execute(getRequest);
            switch (response.getStatusLine().getStatusCode()) {
                case OK:
                    return getValue(response);
                case FORBIDDEN:
                    throw new ClientException(ErrorType.NotLogin);
                default:
                    throw new ClientException(ErrorType.NetError, "Error Code:"
                            + response.getStatusLine().getStatusCode());
            }
        } catch (ClientException ce) {
            System.out.println("HTTPGet Error" + ce);
            throw ce;
        } catch (Exception e) {
            System.out.println("HTTPGet Error" + e);
            throw ClientException.getClientException(e);
        } finally {
            try {
                client.close();
            } catch (IOException ignore) {
            }
        }
    }

    /**
     * PUT请求
     *
     * @param path PUT请求的路径
     */
    public <T> T httpPut(String path) throws ClientException {
        String url = this.url + "/" + path;
        HttpPut request = new HttpPut(url);
        request.setHeader("Content-type", "application/json;charset=" + charset);
        request.setHeader("Accept", "application/json;charset=" + charset);
        if (tocken != null) {
            request.addHeader(CCSession.TOCKEN, tocken);
        }
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpResponse response = client.execute(request);
            switch (response.getStatusLine().getStatusCode()) {
                case OK:
                    return getValue(response);
                case FORBIDDEN:
                    throw new ClientException(ErrorType.NotLogin);
                default:
                    throw new ClientException(ErrorType.NetError, "Error Code:"
                            + response.getStatusLine().getStatusCode());
            }
        } catch (ClientException ce) {
            System.out.println("HTTPPut Error" + ce);
            throw ce;
        } catch (Exception e) {
            System.out.println("HTTPPut Error" + e);
            throw ClientException.getClientException(e);
        } finally {
            try {
                client.close();
            } catch (IOException ignore) {
            }
        }
    }

    /**
     * Post请求
     *
     * @param path     Post的路径
     * @param postData Post请求的参数
     * @param fileData Post的文件参数
     */
    public <T> T httpPost(String path, Map<String, String> postData, Map<String, File> fileData) throws ClientException {
        String url = this.url + "/" + path;
        HttpPost request = new HttpPost(url);
        request.setHeader("Accept", "application/json;charset=" + charset);
        if (tocken != null) {
            request.addHeader(CCSession.TOCKEN, tocken);
        }
        ContentType contentType = ContentType.TEXT_PLAIN.withCharset(charset);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        if (postData != null) {
            for (Entry<String, String> entry : postData.entrySet()) {
                builder.addPart(entry.getKey(), new StringBody(entry.getValue(), contentType));
            }
        }
        if (fileData != null) {
            for (Entry<String, File> entry : fileData.entrySet()) {
                builder.addBinaryBody(entry.getKey(), entry.getValue());
            }
        }
        request.setEntity(builder.build());
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpResponse response = client.execute(request);
            switch (response.getStatusLine().getStatusCode()) {
                case OK:
                    return getValue(response);
                case FORBIDDEN:
                    throw new ClientException(ErrorType.NotLogin);
                default:
                    throw new ClientException(ErrorType.NetError, "Error Code:"
                            + response.getStatusLine().getStatusCode());
            }
        } catch (ClientException ce) {
            System.out.println("HTTPPut Error" + ce);
            throw ce;
        } catch (Exception e) {
            System.out.println("HTTPPut Error" + e);
            throw ClientException.getClientException(e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Post请求，只有Form表单的模式，没有文件
     *
     * @param path     Post的路径
     * @param postData Post请求的参数
     */
    public <T> T httpFormPost(String path, Map<String, String> postData) throws ClientException {
        String url = this.url + "/" + path;
        HttpPost request = new HttpPost(url);
        request.setHeader("Accept", "application/json;charset=" + charset);
        if (tocken != null) {
            request.addHeader(CCSession.TOCKEN, tocken);
        }
        List<NameValuePair> nvps = Lists.newArrayList();
        if (postData != null) {
            for (Entry<String, String> entry : postData.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            request.setEntity(new UrlEncodedFormEntity(nvps, charset));
            HttpResponse response = client.execute(request);
            switch (response.getStatusLine().getStatusCode()) {
                case OK:
                    return getValue(response);
                case FORBIDDEN:
                    throw new ClientException(ErrorType.NotLogin);
                default:
                    throw new ClientException(ErrorType.NetError, "Error Code:" + response.getStatusLine().getStatusCode());
            }
        } catch (ClientException ce) {
            System.out.println("HTTPPut Error" + ce);
            throw ce;
        } catch (Exception e) {
            System.out.println("HTTPPut Error" + e);
            throw ClientException.getClientException(e);
        } finally {
            try {
                client.close();
            } catch (IOException ignore) {

            }
        }
    }

    public String getUrl() {
        return url;
    }

    @SuppressWarnings("unchecked")
    private <T> T getValue(HttpResponse response) throws ParseException, IOException, ClientException {
        String rstContent = getResponseContent(response);

        JsonResult rst = JsonUtils.parseJsonToObj(rstContent, JsonResult.class);
        if (rst != null && rst.isSuccess()) {
            return (T) rst.getObj();
        } else {
            throw new ClientException(ErrorType.ClientError, rst == null ? "null" : rst.getMsg());
        }
    }
}
