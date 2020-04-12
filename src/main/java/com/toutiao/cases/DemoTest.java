package com.toutiao.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.toutiao.config.TestConfig;
import com.toutiao.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
        JSONObject jsonObject = DataUtil.getJsonData("getDemo.json").getJSONObject(0);
        String result = RunMain.getMethod(TestConfig.getDemoUrl,jsonObject);
        System.out.println(result);
    }


    @Test
    public void memberHeed() throws NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        String url = "";
        JSONObject jsonObject = EncryptDataUtil.getData("member_heed.json",0);
        String result = RunMain.getMethod(url,jsonObject);
        JSONObject res = JSON.parseObject(AesCBCUtil.Decrypt(result));
    }


}

