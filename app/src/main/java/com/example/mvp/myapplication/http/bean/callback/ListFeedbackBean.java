package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:ListFeedbackBean
 * @date :${DATA} 12:45
 */
public class ListFeedbackBean {

    private List<FeedbackListBean> feedbackList;

    public List<FeedbackListBean> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<FeedbackListBean> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public static class FeedbackListBean {
        /**
         * content : null
         * feedbackId : 3
         * feedbackTime : 2018-04-24
         * imagePath : http://39.107.22406185.png
         * type : 1
         * userId : d56ea66e7ee7ca51242c8c6394
         */

        private String content;
        private String feedbackId;
        private String feedbackTime;
        private String imagePath;
        private String type;
        private String userId;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFeedbackId() {
            return feedbackId;
        }

        public void setFeedbackId(String feedbackId) {
            this.feedbackId = feedbackId;
        }

        public String getFeedbackTime() {
            return feedbackTime;
        }

        public void setFeedbackTime(String feedbackTime) {
            this.feedbackTime = feedbackTime;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
