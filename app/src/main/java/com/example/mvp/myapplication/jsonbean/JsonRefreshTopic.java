package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonRefreshTopic
 * @date :${DATA} 10:48
 */
public class JsonRefreshTopic {

    /**
     * type : 2
     * cursor : 0
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * tagId : d56ea6c8c6394
     */

    private String type;
    private String cursor;
    private String userId;
    private String tagId;

    public JsonRefreshTopic(String type, String cursor, String userId, String tagId) {
        this.type = type;
        this.cursor = cursor;
        this.userId = userId;
        this.tagId = tagId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
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
}
