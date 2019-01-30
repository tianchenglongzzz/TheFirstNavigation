package com.example.mvp.myapplication.http.bean.callback;

/**
 * @packge: com.example.mvp.myapplication.http.bean
 * @filename:InfoBean
 * @date :${DATA} 10:51
 */
public class InfoBean<T> {
      int  code;
      String  message;
      T data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
