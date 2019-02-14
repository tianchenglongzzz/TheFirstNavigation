package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:UserListCommentBean
 * @date :${DATA} 20:52
 */
public class UserListCommentBean {

    private List<UserCommentListBean> userCommentList;

    public List<UserCommentListBean> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(List<UserCommentListBean> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public static class UserCommentListBean {
        /**
         * commentId : 302836c6e0504728aa455f901184771c
         * commentTime : 2018-05-02 16:30:35
         * content : 评论测试
         * objectId : 94231a0dc3da465297b2b5d3df15cc09
         * objectType : 1
         * title : 哈哈
         */

        private String commentId;
        private String commentTime;
        private String content;
        private String objectId;
        private String objectType;
        private String title;

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
