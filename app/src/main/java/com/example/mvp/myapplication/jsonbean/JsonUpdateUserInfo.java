package com.example.mvp.myapplication.jsonbean;

/**
 * @packge: com.example.mvp.myapplication.jsonbean
 * @filename:JsonUpdateUserInfo
 * @date :${DATA} 17:40
 */
public class JsonUpdateUserInfo {

    /**
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * birthday : 2018-04-19
     * nickname : asd
     * personalProfile : 哈哈哈哈哈
     * professionId : 2188e7113b0411e8b64c00163e30445d
     * sex : 1
     */

    private String userId;
    private String birthday;
    private String nickname;
    private String personalProfile;
    private String professionId;
    private String sex;

    public JsonUpdateUserInfo(String userId, String birthday, String nickname, String personalProfile, String professionId, String sex) {
        this.userId = userId;
        this.birthday = birthday;
        this.nickname = nickname;
        this.personalProfile = personalProfile;
        this.professionId = professionId;
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
