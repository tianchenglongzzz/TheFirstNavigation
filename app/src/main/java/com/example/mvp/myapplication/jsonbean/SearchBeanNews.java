package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:SearchBeanNews
 * @date :${DATA} 20:20
 */
public class SearchBeanNews {
   String  keyword;
   String  cursor;

    public SearchBeanNews(String keyword, String cursor) {
        this.keyword = keyword;
        this.cursor = cursor;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getKeyword() {

        return keyword;
    }

    public String getCursor() {
        return cursor;
    }
}
