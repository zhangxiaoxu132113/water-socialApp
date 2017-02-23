package Test01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.water.db.model.Weibo;
import com.water.db.model.weibo.AccessToken;
import com.water.db.model.weibo.XLWeiBo;
import com.water.utils.web.AuthToken;
import com.water.utils.web.HttpRequestTool;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 2017/2/21.
 */
public class TestWeibo {
    public static String APP_KEY = "3917244546";
    public static String APP_SECRET = "b67aef2a9076171ac50b5768f9ba6be1";
    public static String REDIRECT_URL = "http://www.mrwater.com:8080/weibo/getAuthCode";
    public static String ACCESS_TOKEN = "2.00aZaxTDeP3GRE67b30c1dac2omDLE";

    public static void main(String[] args) {
//        getAccessToken();
        test03();
    }

    public static void getAccessToken() {
        String url = "https://api.weibo.com/oauth2/access_token";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10000)
                .setConnectTimeout(10000)
                .setSocketTimeout(10000)
                .build();
        CloseableHttpResponse response = null;
        try {
            List formparams = new ArrayList();
//            formparams.add(new BasicNameValuePair("client_id", APP_KEY));
//            formparams.add(new BasicNameValuePair("redirect_uri", dd));


            formparams.add(new BasicNameValuePair("client_id", APP_KEY));
            formparams.add(new BasicNameValuePair("client_secret", APP_SECRET));
            formparams.add(new BasicNameValuePair("grant_type", "authorization_code"));
            formparams.add(new BasicNameValuePair("code", "c3bf8ba3b2d0ed55202a1a8313a6878f"));
            formparams.add(new BasicNameValuePair("redirect_uri", REDIRECT_URL));
            httpPost.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
            httpPost.setConfig(requestConfig);

            Header[] headers = {
                    new BasicHeader("Referer", "https://api.weibo.com/oauth2/authorize?client_id=" + APP_KEY + "&redirect_uri=" + REDIRECT_URL),
                    new BasicHeader("Host", "open.weibo.cn"),
                    new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:11.0) Gecko/20100101 Firefox/11.0")
            };
            httpPost.setHeaders(headers); //添加头信息
            response = httpClient.execute(httpPost);
            for (Header header : response.getAllHeaders()) {
                System.out.println(header.getName() + ":" + header.getValue());
            }
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity);
            AccessToken accessToken = JSON.parseObject(content, AccessToken.class);
            System.out.println(content);
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test01() {
        String url1 = "https://open.weibo.cn/oauth2/authorize";
        String url = "https://api.weibo.com/oauth2/authorize?client_id=" + APP_KEY + "&redirect_uri=" + REDIRECT_URL;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10000)
                .setConnectTimeout(10000)
                .setSocketTimeout(10000)
                .build();
        CloseableHttpResponse response = null;
        try {
            List formparams = new ArrayList();
            httpPost.setConfig(requestConfig);
            Header[] headers = {
                    new BasicHeader("Referer", "https://api.weibo.com/oauth2/authorize?client_id=" + APP_KEY + "&redirect_uri=" + REDIRECT_URL),
                    new BasicHeader("Host", "open.weibo.cn"),
                    new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:11.0) Gecko/20100101 Firefox/11.0")
            };
            httpPost.setHeaders(headers); //添加头信息
            response = httpClient.execute(httpPost);
            for (Header header : response.getAllHeaders()) {
                System.out.println(header.getName() + ":" + header.getValue());
            }
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity);
            System.out.println(content);
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        String url = "https://api.weibo.com/oauth2/access_token";
        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", APP_KEY);
        params.put("client_secret", APP_SECRET);
        params.put("grant_type", "authorization_code");
        params.put("code", "2efc87b9fc1c333107a59eaed72a5641");
        params.put("redirect_uri", REDIRECT_URL);
        AuthToken authToken = (AuthToken) HttpRequestTool.postRequest(url, params, AuthToken.class, true);
        System.out.println(authToken.getAccess_token());
    }

    public static void test02() {
        String url = "https://api.weibo.com/oauth2/authorize";
        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", APP_KEY);
        params.put("redirect_uri", REDIRECT_URL);
        HttpRequestTool.postRequest(url, true);
    }

    public static void test03() {
        String url = "https://api.weibo.com/2/statuses/user_timeline.json?access_token=%s";
        url = String.format(url, new Object[]{
                ACCESS_TOKEN
        });
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("access_token", ACCESS_TOKEN);
        paramMap.put("count", "20");
        paramMap.put("page", "2");
        String result = (String) HttpRequestTool.getRequest(url);
        Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
        JSONArray weiboList = (JSONArray) resultMap.get("statuses");
        List<Weibo> weiBos = JSONArray.parseArray(weiboList.toJSONString(), Weibo.class);
        System.out.println(weiboList.toJSONString());
        for (Weibo weiBo : weiBos) {
            System.out.println(weiBo.getText());
        }
    }
}
