package com.example.mvp.myapplication.http.bean.callback;

/**
 * @packge: com.example.mvp.myapplication.http.bean
 * @filename:LoginBean
 * @date :${DATA} 10:54
 */
public class LoginBean {
    private int comments;//评论数
    private  int favorites;//收藏数
    private     int following;//关注数；
    private  String headImagePath;//头像地址
    private  int  historyReads;//历史阅读
    private   boolean isWifiImages;//是否在WIFI下下载图片：false|true
    private  String nickname;//称尼
    private String personalProfile;//个人简介
    private String phone;//手机号
    private String unMessages;//未读消息
    private  String userId;//用户Id

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public void setHistoryReads(int historyReads) {
        this.historyReads = historyReads;
    }

    public void setWifiImages(boolean wifiImages) {
        isWifiImages = wifiImages;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUnMessages(String unMessages) {
        this.unMessages = unMessages;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getComments() {
        return comments;
    }

    public int getFavorites() {
        return favorites;
    }

    public int getFollowing() {
        return following;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public int getHistoryReads() {
        return historyReads;
    }

    public boolean isWifiImages() {
        return isWifiImages;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public String getPhone() {
        return phone;
    }

    public String getUnMessages() {
        return unMessages;
    }

    public String getUserId() {
        return userId;
    }
}
