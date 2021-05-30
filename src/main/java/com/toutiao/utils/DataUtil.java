package com.toutiao.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Cleanup;

import java.io.*;

public class DataUtil {

    private static DataUtil dataUtil = new DataUtil();

    public  static JSONArray getJsonData(String fileName){
        JSONArray jsonArray = null;
        try {
//            String path = System.getProperty("user.dir");
//            String targetPath = path + "/src/main/resources/testdata/" + fileName;
            //解决在远程服务器上无法找到文件的问题
            //InputStream inputStream = GetTestDataUtil.class.getResourceAsStream("/testdata/"+fileName);
           @Cleanup InputStream inputStream = dataUtil.getClass().getResourceAsStream("/testdata/" + fileName);
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

    public static void main(String[] args) {
        System.out.println(new DataUtil().getJsonData("getDemo.json"));
    }


}
