package com.example.mvp.myapplication.http.bean.callback;

import java.util.ArrayList;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:HomeListBean
 * @date :${DATA} 15:02
 */
public class HomeListBean {
    private String cursor;
    ArrayList<HomePagelistBean> topicList;


    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public void setTopicList(ArrayList<HomePagelistBean> topicList) {
        this.topicList = topicList;
    }

    public String getCursor() {
        return cursor;
    }

    public ArrayList<HomePagelistBean> getTopicList() {
        return topicList;
    }
}
