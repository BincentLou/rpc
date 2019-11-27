package com.david.rpcproxy.anno;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id: null.java, v 1.0 2019/11/21 4:26 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Component
public class BaiduHttpClient implements HttpClient{

    private static String uri = "http://www.baidu.com/s?wd=";

    @Override
    public  Object postSend(Object[] params) {
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse closeableHttpResponse = null;
//        List<BasicNameValuePair> parames = new ArrayList<>();
//        parames.add(new BasicNameValuePair("code", "001"));
//        parames.add(new BasicNameValuePair("name", "测试"));
        HttpPost httpPost = new HttpPost(uri +params[0]);
        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(parames, "UTF-8"));

            closeableHttpClient = HttpClients.createDefault();
            closeableHttpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            String result = EntityUtils.toString(httpEntity);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "出错了";
    }

    @Override
    public Object getSend(Object[] params) {
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse closeableHttpResponse = null;
        HttpGet httpGet = new HttpGet(uri +params[0]);
        try {
        // 设置请求头信息，鉴权
//            httpGet.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 设置配置请求参数
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
                    .setConnectionRequestTimeout(35000)// 请求超时时间
                    .setSocketTimeout(60000)// 数据读取超时时间
                    .build();
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            closeableHttpClient = HttpClients.createDefault();
            closeableHttpResponse = closeableHttpClient.execute(httpGet);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            String result = EntityUtils.toString(httpEntity);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "出错了";
    }

    public static String getUri() {
        return uri;
    }

    public static void setUri(String uri) {
        BaiduHttpClient.uri = uri;
    }
}
