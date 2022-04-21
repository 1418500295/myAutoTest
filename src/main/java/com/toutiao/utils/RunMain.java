package com.toutiao.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RunMain {

    private static DefaultHttpClient httpClient = new DefaultHttpClient();
    private static List<NameValuePair> pairList = new ArrayList<>();

    public static String getMethod(String url,JSONObject params) throws IOException {
        String result = null;
        try {
            for (Map.Entry<String,Object> entry: params.entrySet()){
                pairList.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
            }
            String param = EntityUtils.toString(new UrlEncodedFormEntity(pairList),"utf-8");
            HttpGet get = new HttpGet(url+"?"+param);
            HttpResponse response = httpClient.execute(get);
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getMethod(String url) throws IOException {
        String result = null;
        try {
            HttpGet get = new HttpGet(url);
            HttpResponse response = httpClient.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();

        }
        return result;
    }


    public static String postMethod(String url, JSONObject params) throws IOException {

        String result = null;
        try {
            HttpPost post = new HttpPost(url);
            for (String key : params.keySet()){
                pairList.add(new BasicNameValuePair(key, (String) params.get(key)));
            }

            post.setEntity(new UrlEncodedFormEntity(pairList));
            HttpResponse response = httpClient.execute(post);
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String postMethod(String url, JSONObject params, JSONObject headers) throws IOException {
        String result = null;
        try {
            HttpPost post = new HttpPost(url);
            JSONObject jsonObject = new JSONObject();
            for (Map.Entry<String,Object> entry: params.entrySet()){
                jsonObject.put(entry.getKey(),entry.getValue());
            }
            for (Map.Entry<String, Object> entry: headers.entrySet()){
                post.setHeader(entry.getKey(), (String) entry.getValue());
            }
            StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");
            post.setEntity(entity);
            HttpResponse response = httpClient.execute(post);
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    CloseableHttpClient client = HttpClients.createDefault();
        String url = "";
        HttpPost post = new HttpPost(url);
        File file = new File("C:\\Users\\Administrator\\IdeaProjects\\jiaoyisuo\\src\\屏幕截图 2022-04-08 154019.png");
        FileBody fileBody = new FileBody(file);
        StringBody comment = new StringBody("upload file", ContentType.TEXT_PLAIN);
        HttpEntity entity = MultipartEntityBuilder.create().addPart("file",fileBody)
                .addPart("comment",comment).build();
        post.setEntity(entity);
        post.setHeader("","");
        HttpResponse response = client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));

}
