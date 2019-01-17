package com.bby.hotel.utils;

import org.apache.commons.codec.binary.Base64;

public class Base65Utils {


    private static Base65Utils instance;

    public static Base65Utils getInstance(){
        if(instance == null){
            instance = new Base65Utils();
        }
        return instance;
    }

    private Base65Utils(){}

    /**
     * base64加密
     * @param str 加密的字符串
     * @return 加密后的字符串
     */
    public String base64Encode(String str){
        String result = "";
        try {
            if(str != null && !"".equals(str)){
                byte[] bytes = Base64.encodeBase64(str.getBytes());
                if(bytes != null){
                    result = new String(bytes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * base64解密
     * @param str 要解密的字符串
     * @return 解密后的字符串
     */
    public String base64Decode(String str){
        String result = "";
        try {
            if(str != null && !"".equals(str)){
                byte[] bytes =  Base64.decodeBase64(str.getBytes());
                result = new String(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
