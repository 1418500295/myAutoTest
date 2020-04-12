package com.toutiao.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.toutiao.utils.DataUtil;
import freemarker.ext.beans.HashAdapter;
import netscape.javascript.JSObject;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Demo {
    public static void main(String[] args) {

        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[3] = 4;
        System.out.println(a[1]);
        int[][] c = {{2,3,4},{3,6,5},{2,7,9}};
        System.out.println(c[2][2]);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("哈哈");
        list.add("33");
        System.out.println(list);
        String str = JSON.toJSONString(list);
        System.out.println(str.getClass());
        System.out.println(str);
        List<String> list1 = JSON.parseArray(str,String.class);
        for (String one: list1){
            System.out.println(one);
        }
        Iterator<String> iterator1 = list1.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }


        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("name",1);
        map.put("age",12);
        map.put("salary",2000);
        System.out.println(map);
        String s = JSON.toJSONString(map);
        System.out.println(s);
        Map<String,Integer> map1 = JSON.parseObject(s,(Type)Map.class);
        for (String key: map1.keySet()){
            System.out.println(key);
            System.out.println(map1.get(key));
        }

        for (Map.Entry<String,Integer> entry: map1.entrySet()){
            System.out.println("key =" + entry.getKey() +"\n" + "value = "+ entry.getValue());
        }
        Iterator<Map.Entry<String,Integer>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            System.out.println("key="+entry.getKey());
            System.out.println("value="+entry.getValue());
        }



    }

    @Test
    public void getPath() throws IOException {
        String path = "C:\\Users\\ASUS\\IdeaProjects\\myAutoTest\\src\\main\\java\\com\\toutiao\\cases\\a.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path,true);
        fileOutputStream.write("\n我的世界".getBytes());

        FileInputStream inputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder str = new StringBuilder();
        while ((line = reader.readLine()) != null){
            str.append(line);

        }
        System.out.println(str.toString());
    }
    @Test
    public void sorts(){
        int[] a = {2,4,3,7,5,9};
        Arrays.sort(a);
        for (int i=0;i <a.length;i++){
            System.out.print(a[i]);
        }

    }

    @Test
    public void first(){

        JSONObject jsonObject = DataUtil.getJsonData("base.json").getJSONObject(0);
        Map<String,Object> map = DataUtil.getJsonData("base.json").getJSONObject(0);
        System.out.println(map);
        System.out.println(jsonObject);
        for (Map.Entry<String,Object> entry: jsonObject.entrySet()){
            System.out.println(entry.getKey()+"\n"+entry.getValue());
        }
    }

}






