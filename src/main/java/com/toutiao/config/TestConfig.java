package com.toutiao.config;

import lombok.Data;
import org.apache.http.entity.StringEntity;

@Data
public class TestConfig {

        public static String getDemoUrl;

        public static String postSecondUrl;
        public static String getCookiesUrl;

        public static String postWithJsonUrl;
}
