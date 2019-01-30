package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:downListNewsjsonBean
 * @date :${DATA} 20:11
 */
public class downListNewsjsonBean {
     String downListNews;
      String channelId;
     String  cursor;

    public downListNewsjsonBean(String downListNews, String channelId, String cursor) {
        this.downListNews = downListNews;
        this.channelId = channelId;
        this.cursor = cursor;
    }

    public void setDownListNews(String downListNews) {
        this.downListNews = downListNews;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getDownListNews() {
        return downListNews;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getCursor() {
        return cursor;
    }
}
