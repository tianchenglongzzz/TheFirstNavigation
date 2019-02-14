package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonTagsSearch
 * @date :${DATA} 17:51
 */
public class JsonTagsSearch {

    /**
     * keyword : 无人机
     * cursor : 0
     */


    private String keyword;
    private String cursor;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public JsonTagsSearch(String keyword, String cursor) {
        this.keyword = keyword;
        this.cursor = cursor;
    }
}
