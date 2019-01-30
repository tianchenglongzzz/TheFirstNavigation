package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.jiyun.com.myapplication.jsonbean
 * @filename:Vcode
 * @date :${DATA} 21:02
 */
public class Vcode {
     String phone;
     int     smsType;

    public Vcode(String phone, int smsType) {
        this.phone = phone;
        this.smsType = smsType;
    }

    public String getPhone() {
        return phone;
    }

    public int getSmsType() {
        return smsType;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public void setSmsType(int smsType) {
        this.smsType = smsType;
    }
}
