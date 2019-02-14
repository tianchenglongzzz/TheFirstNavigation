package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:TopicListBean
 * @date :${DATA} 14:25
 */
public class TopicBean {

    /**
     * cursor : 2
     * topicList : [{"comments":0,"headImagePath":"/head/2018-04-580.png","imageListThumb":["http://39.107.224f468136360.png","http://39.106394_1524968136908.jpg","http://39.104968137327.jpg"],"likes":0,"nickname":"李红梅","pageviews":0,"publishTime":"2018-04-29 10:15:40","shareLink":"http://www.baidu.com","title":"postman测试发布话题","topicId":"452faafc1bfe4f0585be52255c10748e","userId":"d56ea66e7ee741f498ca51242c8c6394"}]
     */

    private String cursor;
    private List<TopicListBean> topicList;
    private String minCursor;

    public void setMinCursor(String minCursor) {
        this.minCursor = minCursor;
    }

    public String getMinCursor() {
        return minCursor;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<TopicListBean> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<TopicListBean> topicList) {
        this.topicList = topicList;
    }


}
