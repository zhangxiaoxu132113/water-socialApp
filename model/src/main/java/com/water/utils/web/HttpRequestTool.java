package com.water.utils.web;

import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLHandshakeException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangmiaojie on 2017/2/22.
 */
public class HttpRequestTool {

    /**
     * post请求
     *
     * @param requestUrl
     * @param paramMap
     * @param headerMap
     * @param cls
     * @param isOutInfo
     * @return
     */
    public static Object postRequest(String requestUrl, Map<String, String> paramMap, Map<String, String> headerMap, CookieConfig cookieConfig, Class cls, boolean isOutInfo) {
        CloseableHttpClient client = null;
        HttpPost post = null;
        Object obj = null;
        try {
            post = new HttpPost(requestUrl);
            client = HttpClients.custom()
                    .setRetryHandler(setRequestRetryCount(3))
                    .setDefaultCookieStore(setCookies(cookieConfig))
                    .build();
            RequestConfig requestConfig = RequestConfig.custom() // 设置请求超时时间
                    .setConnectionRequestTimeout(10000)
                    .setConnectTimeout(10000)
                    .setSocketTimeout(10000)
                    .build();
            post.setConfig(requestConfig);

            if (paramMap != null && paramMap.entrySet().size() > 0) {
                List params = new ArrayList();
                for (Map.Entry<String, String> param : paramMap.entrySet()) {
                    params.add(new BasicNameValuePair(param.getKey(), param.getValue()));
                }
                post.setEntity(new UrlEncodedFormEntity(params, "UTF-8")); //设置请求参数
            }

            if (headerMap != null && headerMap.entrySet().size() > 0) {
                List<Header> headers = new ArrayList<Header>();
                for (Map.Entry<String, String> header : headerMap.entrySet()) {
                    headers.add(new BasicHeader(header.getKey(), header.getValue()));
                }
                post.setHeaders((Header[]) headers.toArray()); //设置请求头信息
            }
            HttpContext localContext = new BasicHttpContext();
            CloseableHttpResponse response = client.execute(post, localContext);
            outHeaderInfo(isOutInfo, response, localContext);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
            if (cls != null) { //解析json为pojo
                ScriptEngineManager sem = new ScriptEngineManager();
                ScriptEngine se = sem.getEngineByName("js");
                try {
//                    se.eval(result);
                    obj = JSON.parseObject(result, cls);
                } catch (Exception e) {
                    System.out.println("json 解析失败!");
                    e.printStackTrace();
                }
            } else {
                obj = result;
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * post请求
     *
     * @param requestUrl
     */
    public static void postRequest(String requestUrl) {
        postRequest(requestUrl, null, null, null, null, false);
    }

    /**
     * post请求
     *
     * @param requestUrl
     * @param isOutInfo
     */
    public static void postRequest(String requestUrl, boolean isOutInfo) {
        postRequest(requestUrl, null, null, null, null, isOutInfo);
    }

    /**
     * post请求
     *
     * @param requestUrl
     * @param paramMap
     * @param isOutInfo
     */
    public static Object postRequest(String requestUrl, Map<String, String> paramMap, boolean isOutInfo) {
        return postRequest(requestUrl, paramMap, null, null, null, isOutInfo);
    }

    /**
     * post请求
     *
     * @param requestUrl
     * @param paramMap
     * @param cls
     * @param isOutInfo
     */
    public static Object postRequest(String requestUrl, Map<String, String> paramMap, Class cls, boolean isOutInfo) {
        return postRequest(requestUrl, paramMap, null, null, cls, isOutInfo);
    }

    /**
     * get请求
     *
     * @param requestUrl
     * @param cls
     * @param headerMap
     * @param isOutInfo
     * @return
     */
    public static Object getRequest(String requestUrl, Class cls, Map<String, String> headerMap, CookieConfig cookieConfig, boolean isOutInfo) {
        CloseableHttpClient client = null;
        HttpGet get = null;
        Object obj = null;
        try {
            client = HttpClients.custom()
                    .setRetryHandler(setRequestRetryCount(3))
                    .setDefaultCookieStore(setCookies(cookieConfig))
                    .build();
            get = new HttpGet(requestUrl);
            HttpContext localContext = new BasicHttpContext();
            RequestConfig config = RequestConfig.custom()
                    .setConnectionRequestTimeout(1000)
                    .setConnectTimeout(1000)
                    .setSocketTimeout(1000)
                    .build();
            get.setConfig(config);// 设置请求超时时间
            if (headerMap != null && headerMap.entrySet().size() > 0) {
                List<Header> headers = new ArrayList<Header>();
                for (Map.Entry<String, String> header : headerMap.entrySet()) {
                    headers.add(new BasicHeader(header.getKey(), header.getValue()));
                }
                get.setHeaders((Header[]) headers.toArray()); //设置请求头信息
            } else {
                get.setHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"));
            }

            CloseableHttpResponse response = client.execute(get, localContext);
            outHeaderInfo(isOutInfo, response, localContext);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
            if (cls != null) { //解析json为pojo
                ScriptEngineManager sem = new ScriptEngineManager();
                ScriptEngine se = sem.getEngineByName("js");
                try {
//                    se.eval(result);
                    obj = JSON.parseObject(result, cls);
                } catch (Exception e) {
                    System.out.println("json 解析失败!");
                    e.printStackTrace();
                }
            } else {
                obj = result;
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * get请求
     *
     * @param requestUrl
     */
    public static Object getRequest(String requestUrl) {
        return getRequest(requestUrl, null, null, null, false);
    }

    /**
     * get请求
     *
     * @param requestUrl
     * @param isOutInfo
     */
    public static Object getRequest(String requestUrl, boolean isOutInfo) {
        return getRequest(requestUrl, null, null, null, isOutInfo);
    }

    /**
     * get请求
     *
     * @param requestUrl
     * @param isOutInfo
     */
    public static Object getRequest(String requestUrl, Class cls, boolean isOutInfo) {
        return getRequest(requestUrl, cls, null, null, isOutInfo);
    }

    public static void main(String[] args) {
        getRequest("https://www.facebook.com", true);

    }

    /**
     * 设置请求次数
     *
     * @param retryCount
     * @return
     */
    public static HttpRequestRetryHandler setRequestRetryCount(final int retryCount) {
        HttpRequestRetryHandler requestRetryHandler = new HttpRequestRetryHandler() {
            //            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext httpContext) {
                System.out.println("访问失败，尝试重新访问【" + executionCount + "】");
                if (executionCount > retryCount) {
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// 服务停掉则重新尝试连接
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// SSL异常不需要重试
                    return false;
                }
                HttpRequest request = (HttpRequest) httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
                boolean idempotent = (request instanceof HttpEntityEnclosingRequest);
                if (!idempotent) {// 请求内容相同则重试
                    return true;
                }
                return false;
            }
        };
        return requestRetryHandler;
    }

    /**
     * 设置请求cookie
     *
     * @param cookieConfig
     * @return
     */
    public static CookieStore setCookies(CookieConfig cookieConfig) {
        CookieStore cookieStore = new BasicCookieStore();
        if (cookieConfig != null && (cookieConfig.getCookirMap() != null && cookieConfig.getCookirMap().entrySet().size() > 0)) {
            for (Map.Entry<String, String> cookieParam : cookieConfig.getCookirMap().entrySet()) {
                BasicClientCookie cookie = new BasicClientCookie(cookieParam.getKey(), cookieParam.getValue());
                cookie.setDomain(cookieConfig.getDomain());
                cookie.setExpiryDate(cookieConfig.getExpiryDate());
                cookieStore.addCookie(cookie);
            }
        }
        return cookieStore;
    }

    /**
     * 打印输出响应头部信息 TODO 后面使用logback来输出信息
     *
     * @param isOutInfo
     * @param response
     */
    private static void outHeaderInfo(boolean isOutInfo, CloseableHttpResponse response, HttpContext localContext) {
        if (isOutInfo && response != null) {
            int statusCode = response.getStatusLine().getStatusCode();
            Header[] headers = response.getAllHeaders();
            System.out.println("------------------- 响应头信息 -------------------");
            System.out.println("响应状态码 : " + statusCode);
            for (Header header : headers) {
                System.out.println(header.getName() + " : " + header.getValue());
            }
            System.out.println("---------------------- end ----------------------");
        }

        if (localContext != null) {
            HttpRequest request = (HttpRequest) localContext
                    .getAttribute(ExecutionContext.HTTP_REQUEST);
            Header[] headers = request.getAllHeaders();
            System.out.println("------------------- 请求头信息 -------------------");
            for (Header header : headers) {
                System.out.println(header.getName() + " : " + header.getValue());
            }
            System.out.println("---------------------- end ----------------------");
        }
    }
}
