package com.example.mvp.myapplication.http.bean.callback;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:VCBean
 * @date :${DATA} 11:53
 */
public class VCBean {

    /**
     * code : 200
     * ret : success
     * data : puso
     */

    private int code;
    private String ret;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
