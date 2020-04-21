package com.toutiao.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AesCBCUtil {

    private static final String KEY = "";
    private static final String IV = "";
    private static final String ENCODING = "utf-8";

    //加密,请求参数需使用base64加密两次
    public static String Encrypt(String content) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        byte[] raw = KEY.getBytes(ENCODING);
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw,"AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,ivParameterSpec);
        byte[] encryptContent = cipher.doFinal(content.getBytes());
        return (new String(new Base64().encode(new Base64().encode(encryptContent))));
    }
    //解密方法，响应数据解密一次

    public static String Decrypt(String content) throws IOException,
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] raw = KEY.getBytes(ENCODING);
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw,"AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec,ivParameterSpec);
        byte[] decryptContent = new BASE64Decoder().decodeBuffer(content);
        return (new String(cipher.doFinal(decryptContent)));

    }


    public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
//        String s = "dfemdMk/2fsSs9TowxjaHas7iSRNT4VIp7TL5DDym/ojChHH6BAMh0M+4xCJmLpcZAP5z/1dJ0Dov4cQ4YqhyLiu3UlOThZI8sPwpxaztaQSz+81at5pwdtezyromee8TIIemj1C2++qufHUqGS7omWocBoECwGgUcCxH0pSSDIqFZEiuKinEPD4gNpew1f3cfH2hf6nATC/IiQr2MIEqwKKvNKxexgM1ZFg9u+dxxq9jLiW2poHCAM88y38AesHV+YmbAmhCQikGZr5nnctuA==";
//        System.out.println(AesCBCUtil.Decrypt(s));
    }
}
