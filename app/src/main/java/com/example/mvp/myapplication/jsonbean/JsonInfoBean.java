package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonInfoBean
 * @date :${DATA} 13:54
 */
public class JsonInfoBean {
   private String userid;
    private String newsid;

    public JsonInfoBean(String userid, String newsid) {
        this.userid = userid;
        this.newsid = newsid;
    }

    public void setUserid(String userid) {

        this.userid = userid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getUserid() {

        return userid;
    }

    public String getNewsid() {
        return newsid;
    }
}
