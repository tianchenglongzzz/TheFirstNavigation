package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:MoreFollowBean
 * @date :${DATA} 15:49
 */
public class MoreFollowBean {

    /**
     * cursor : 0
     * moreFollowList : [{"followers":0,"headImagePath":"http://39.107.1525346287307.jpg","nickname":"李瑛彬","userId":"a9fba60a4a8f4413a3ae3d5de4010cbf"}]
     */

    private String cursor;
    private List<MoreFollowListBean> moreFollowList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<MoreFollowListBean> getMoreFollowList() {
        return moreFollowList;
    }

    public void setMoreFollowList(List<MoreFollowListBean> moreFollowList) {
        this.moreFollowList = moreFollowList;
    }

    public static class MoreFollowListBean {
        /**
         * followers : 0
         * headImagePath : http://39.107.1525346287307.jpg
         * nickname : 李瑛彬
         * userId : a9fba60a4a8f4413a3ae3d5de4010cbf
         */

        private int followers;
        private String headImagePath;
        private String nickname;
        private String userId;

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
