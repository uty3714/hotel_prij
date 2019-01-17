package com.bby.hotel.net;

public class CommonReturnType {

    private String ret; //success 返回成功 fail 返回失败
    private String msg = "";
    private Object datas = null;


    public CommonReturnType(String ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }

    public CommonReturnType(String ret, Object datas) {
        this.ret = ret;
        this.datas = datas;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }
}
