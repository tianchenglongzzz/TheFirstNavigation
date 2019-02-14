package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:jsonTopicInfoBean
 * @date :${DATA} 14:18
 */
public class jsonTopicInfoBean {

    /**
     * topicId : d56ea66e7ee741f498ca51242c8c6394
     * userId : d56ea66e7ee741f498ca51242c8c6394
     */

    private String topicId;
    private String userId;

    public jsonTopicInfoBean(String topicId, String userId) {
        this.topicId = topicId;
        this.userId = userId;
    }
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
