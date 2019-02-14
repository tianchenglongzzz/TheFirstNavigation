package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonListComment
 * @date :${DATA} 18:37
 */
public class JsonListComment {

    /**
     * objectId : d56ea66e7ee741f498ca51242c8c6394
     * objectType : 0
     * cursor : 0
     */

    private String objectId;
    private String objectType;
    private int cursor;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public int getCursor() {
        return cursor;
    }

    public JsonListComment(String objectId, String objectType, int cursor) {
        this.objectId = objectId;
        this.objectType = objectType;
        this.cursor = cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }
}
