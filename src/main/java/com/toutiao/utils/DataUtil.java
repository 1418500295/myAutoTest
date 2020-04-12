package com.toutiao.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.javaws.security.Resource;
import com.sun.org.apache.xpath.internal.objects.XNull;

import java.io.*;

public class DataUtil {

    public static JSONArray getJsonData(String fileName){
        JSONArray jsonArray = null;
        try {
            String path = System.getProperty("user.dir");
            String targetPath = path + "/src/main/resources/testdata/" + fileName;
            FileInputStream inputStream = new FileInputStream(targetPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = reader.readLine()) != null){
                str.append(line);
            }
            jsonArray = JSON.parseArray(String.valueOf(str));
//            resData = String.valueOf(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

}
