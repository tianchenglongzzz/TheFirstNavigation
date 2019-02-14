package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonMoreFollow
 * @date :${DATA} 16:25
 */
public class JsonMoreFollow {

    /**
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * tagId : d56ea66e7ee741f498ca51242c8c6394
     * cursor : 0
     */

    private String userId;
    private String tagId;
    private String cursor;

    public JsonMoreFollow(String userId, String tagId, String cursor) {
        this.userId = userId;
        this.tagId = tagId;
        this.cursor = cursor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
