package com.example.mvp.myapplication.http.bean.callback;

import com.umeng.commonsdk.debug.W;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:UserCenterBean
 * @date :${DATA} 12:16
 */
public class UserCenterBean {

    /**
     * comments : 0
     * favorites : 0
     * following : 0
     * headImagePath : null
     * historyReads : 0
     * isWifiImages : 0
     * nickname : null
     * personalProfile : null
     * phone : 18301413850
     * unMessages : 0
     * userId : d56ea66e7ee741f498ca51242c8c6394
     */

    private int comments;
    private int favorites;
    private int following;
    private String headImagePath;
    private int historyReads;
    private int isWifiImages;
    private String nickname;
    private String personalProfile;
    private String phone;
    private int unMessages;
    private String userId;

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public int getHistoryReads() {
        return historyReads;
    }

    public void setHistoryReads(int historyReads) {
        this.historyReads = historyReads;
    }

    public int getIsWifiImages() {
        return isWifiImages;
    }

    public void setIsWifiImages(int isWifiImages) {
        this.isWifiImages = isWifiImages;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

        public  String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUnMessages() {
        return unMessages;
    }

    public void setUnMessages(int unMessages) {
        this.unMessages = unMessages;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
