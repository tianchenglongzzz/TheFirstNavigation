package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:favouriteTopic
 * @date :${DATA} 13:40
 */
public class FavouriteTopicBean {

    /**
     * cursor : 0
     * favouritTopicList : [{"favouritId":"64bc42b6f7574daea9b3d78300bc388d","comment":"电话信号","headImagePath":"http://39.107.jpg","imageListThumb":["http://39.107.4010cbf_1525399390175.jpg","http://3ae3d5de4010cbf_1525399390280.jpg","http://39.107.224.233/fi1525399390850.jpg"],"nickname":"李瑛彬","publishTime":"2018-05-04 10:03:12","shareLink":"","title":"好烦好烦减肥不吃","topicId":"1357ebadf21848feaffa4674c5f5ef67","userId":"a9fba60a4a8f4413a3ae3d5de4010cbf"}]
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
         * favouritId : 64bc42b6f7574daea9b3d78300bc388d
         * comment : 电话信号
         * headImagePath : http://39.107.jpg
         * imageListThumb : ["http://39.107.4010cbf_1525399390175.jpg","http://3ae3d5de4010cbf_1525399390280.jpg","http://39.107.224.233/fi1525399390850.jpg"]
         * nickname : 李瑛彬
         * publishTime : 2018-05-04 10:03:12
         * shareLink :
         * title : 好烦好烦减肥不吃
         * topicId : 1357ebadf21848feaffa4674c5f5ef67
         * userId : a9fba60a4a8f4413a3ae3d5de4010cbf
         */

        private String favouritId;
        private String comment;
        private String headImagePath;
        private String nickname;
        private String publishTime;
        private String shareLink;
        private String title;
        private String topicId;
        private String userId;
        private List<String> imageListThumb;

        public String getFavouritId() {
            return favouritId;
        }

        public void setFavouritId(String favouritId) {
            this.favouritId = favouritId;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(String headImagePath) {
            this.headImagePath = headImagePath;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }
    }
}
