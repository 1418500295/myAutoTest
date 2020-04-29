package com.toutiao.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.toutiao.config.TestConfig;
import com.toutiao.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@Slf4j
public class DemoTest {


    @Test
    public void getDemo() throws IOException {
        TestConfig.getDemoUrl = ConfigFile.getUrl("getDemo");
        System.out.println(TestConfig.getDemoUrl);

        JSONObject jsonObject = DataUtil.getJsonData("getDemo.json").getJSONObject(0);
        String result = RunMain.getMethod(TestConfig.getDemoUrl, jsonObject);
        System.out.println(result);
    }


    @Test
    public void memberHeed() throws NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        String url = "";
        JSONObject jsonObject = EncryptDataUtil.getData("member_heed.json", 0);
        String result = RunMain.getMethod(url, jsonObject);
        JSONObject res = JSON.parseObject(AesCBCUtil.Decrypt(result));
    }


    @Test
    public void getWithParam() throws IOException {
        String url = "http://localhost:8889/getwithparam?name=huhansan&age=10";
        HttpGet get = new HttpGet(url);
        HttpResponse response = new DefaultHttpClient().execute(get);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);


    }


    public void first() {
        System.out.println("hah");

    }
    public void second() {
        System.out.println("我是second");

    }
}