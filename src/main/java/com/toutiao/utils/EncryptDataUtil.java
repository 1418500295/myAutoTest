package com.toutiao.utils;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptDataUtil {


    public static JSONObject getData(String dataName,int caseIndex) throws NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        String baseData = DataUtil.getJsonData("base.json").getString(0);
        String paramData = DataUtil.getJsonData(dataName).getString(caseIndex);
        String base = AesCBCUtil.Encrypt(baseData);
        String data = AesCBCUtil.Encrypt(paramData);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",data);
        jsonObject.put("base",base);
        return jsonObject;

    }

    public static JSONObject getData() throws NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        String baseData = DataUtil.getJsonData("base.json").getString(0);
        String base = AesCBCUtil.Encrypt(baseData);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("base",base);
        return jsonObject;

    }
}
