package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonFollow
 * @date :${DATA} 13:55
 */
public class JsonFollow {

    /**
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * followUid : d56ea66e7ee741f498ca51242c8c6394
     * type : 0
     */

    private String userId;
    private String followUid;
    private String type;


    public JsonFollow(String userId, String followUid, String type) {
        this.userId = userId;
        this.followUid = followUid;
        this.type = type;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowUid() {
        return followUid;
    }

    public void setFollowUid(String followUid) {
        this.followUid = followUid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
