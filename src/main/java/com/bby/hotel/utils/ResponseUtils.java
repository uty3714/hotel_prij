package com.bby.hotel.utils;

import com.bby.hotel.net.CommonReturnType;
import com.google.gson.Gson;

public class ResponseUtils {

    /**
     * 获取响应成功信息
     * @param datas datas
     * @return String json
     */
    public static CommonReturnType getResponseSuc(Object datas){
        CommonReturnType result = null;
        if(datas != null){
            result = new CommonReturnType("success",datas);
            return result;
        }else{
            //返回一个失败
            result = getResponseFail("获取数据对象异常");
            return result;
        }
    }

    /**
     * 获取响应失败信息
     * @param msg msg
     * @return String json
     */
    public static CommonReturnType getResponseFail(String msg){
        CommonReturnType result = null;
        if(msg == null){
            result = new CommonReturnType("fail","未知错误");
        }else{
            result = new CommonReturnType("fail",msg);
        }
        return result;
    }


}
