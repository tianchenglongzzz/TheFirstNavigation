package com.example.mvp.myapplication.http.bean.callback;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:UserhomePageBean
 * @date :${DATA} 15:08
 */
public class UserhomePageBean {

    /**
     * followers : 0
     * headImagePath : /head/225346287307.jpg
     * isFollowed : 0
     * nickname : 李瑛彬
     * personalProfile : null
     * topics : 0
     * userId : a9fba60a4a8f4413a3ae3d5de4010cbf
     */

    private int followers;
    private String headImagePath;
    private int isFollowed;
    private String nickname;
    private String personalProfile;
    private int topics;
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

    public int getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(int isFollowed) {
        this.isFollowed = isFollowed;
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

    public int getTopics() {
        return topics;
    }

    public void setTopics(int topics) {
        this.topics = topics;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
