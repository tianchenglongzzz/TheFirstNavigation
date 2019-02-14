package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:listFollowBean
 * @date :${DATA} 18:38
 */
public class ListFollowBean {

    private List<FollowListBean> followList;

    public List<FollowListBean> getFollowList() {
        return followList;
    }

    public void setFollowList(List<FollowListBean> followList) {
        this.followList = followList;
    }

    public static class FollowListBean {
        /**
         * followId : a9fba60a4a8e4010cbf
         * followTime : 2018-04-26 17:45:23
         * followUid : a9fba60a4a8e4010cbf
         * headImagePath : /hea1524732343313.jpg
         * nickname : 李瑛彬
         * personalProfile : null
         */

        private String followId;
        private String followTime;
        private String followUid;
        private String headImagePath;
        private String nickname;
        private String personalProfile;

        public String getFollowId() {
            return followId;
        }

        public void setFollowId(String followId) {
            this.followId = followId;
        }

        public String getFollowTime() {
            return followTime;
        }

        public void setFollowTime(String followTime) {
            this.followTime = followTime;
        }

        public String getFollowUid() {
            return followUid;
        }

        public void setFollowUid(String followUid) {
            this.followUid = followUid;
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

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }
    }
}
