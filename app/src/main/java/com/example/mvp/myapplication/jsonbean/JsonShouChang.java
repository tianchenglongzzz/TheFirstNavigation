package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonShouChang
 * @date :${DATA} 11:34
 */
public class JsonShouChang {

    /**
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * objectId : d56ea66e7ee741f498ca51242c8c6394
     * objectType : 0
     * type : 0
     */

    private String userId;
    private String objectId;
    private String objectType;
    private String type;

    public JsonShouChang(String userId, String objectId, String objectType, String type) {
        this.userId = userId;
        this.objectId = objectId;
        this.objectType = objectType;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
