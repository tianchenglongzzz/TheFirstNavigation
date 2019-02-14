package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:MyListTopicBean
 * @date :${DATA} 12:50
 */
public class MyListTopicBean {

    /**
     * cursor : 0
     * favouritTopicList : [{"comments":0,"imageListThumb":["http://39.107.224010cbf_1525398485467.jpg","http://39.10cbf_1525398485587.jpg","http://bf_1525398485671.jpg"],"likes":0,"pageviews":0,"publishTime":"2018-05-04 09:48:08","shareLink":"","title":"电话发挥附近减肥好烦好烦","topicId":"d7e795c7a4a3416faf1fe6f7a42dd1f3"}]
     */

    private String cursor;
    private List<FavouritTopicListBean> favouritTopicList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<FavouritTopicListBean> getFavouritTopicList() {
        return favouritTopicList;
    }

    public void setFavouritTopicList(List<FavouritTopicListBean> favouritTopicList) {
        this.favouritTopicList = favouritTopicList;
    }

    public static class FavouritTopicListBean {
        /**
         * comments : 0
         * imageListThumb : ["http://39.107.224010cbf_1525398485467.jpg","http://39.10cbf_1525398485587.jpg","http://bf_1525398485671.jpg"]
         * likes : 0
         * pageviews : 0
         * publishTime : 2018-05-04 09:48:08
         * shareLink :
         * title : 电话发挥附近减肥好烦好烦
         * topicId : d7e795c7a4a3416faf1fe6f7a42dd1f3
         */

        private int comments;
        private int likes;
        private int pageviews;
        private String publishTime;
        private String shareLink;
        private String title;
        private String topicId;
        private List<String> imageListThumb;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getPageviews() {
            return pageviews;
        }

        public void setPageviews(int pageviews) {
            this.pageviews = pageviews;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getShareLink() {
            return shareLink;
        }

        public void setShareLink(String shareLink) {
            this.shareLink = shareLink;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }
    }
}
