package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonHomePage
 * @date :${DATA} 18:51
 */
public class JsonHomePage {

    /**
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * lookUserId : d56ea66e7ee741f498cac6394
     * cursor : 0
     */

    private String userId;
    private String lookUserId;
    private String cursor;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLookUserId() {
        return lookUserId;
    }

    public void setLookUserId(String lookUserId) {
        this.lookUserId = lookUserId;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public JsonHomePage(String userId, String lookUserId, String cursor) {
        this.userId = userId;
        this.lookUserId = lookUserId;
        this.cursor = cursor;
    }
}
