package com.example.mvp.myapplication.http.bean.erro;

/**
 * @packge: com.example.mvp.myapplication.http.bean.erro
 * @filename:ApiException
 * @date :${DATA} 18:41
 */
public class ApiException extends Throwable {
    private  String Exceptionname;
    private  int   code;

    public ApiException(String exceptionname, int code) {
        Exceptionname = exceptionname;
        this.code = code;
    }

    public void setExceptionname(String exceptionname) {
        Exceptionname = exceptionname;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getExceptionname() {
        return Exceptionname;
    }

    public int getCode() {
        return code;
    }
}
