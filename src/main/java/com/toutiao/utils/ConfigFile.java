package com.toutiao.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(String urlName){
        String testUrl = "";
        try {
            String testUri = "";
            String host = bundle.getString("host");
            String uri = bundle.getString(urlName);

            if ( !(uri.startsWith("/"))){
                testUri = "/" + uri;
            }
            else {
                testUri = uri;
            }
            testUrl = host + testUri;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testUrl;
    }


}
