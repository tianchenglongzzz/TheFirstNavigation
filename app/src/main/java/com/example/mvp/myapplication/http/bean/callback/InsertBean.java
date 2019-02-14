package com.example.mvp.myapplication.http.bean.callback;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:InsertBean
 * @date :${DATA} 11:46
 */
public class InsertBean {

    /**
     * code : 0
     * message : 成功
     * data : null
     */

    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
