package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:TopicListBean
 * @date :${DATA} 14:19
 */
public class TopicListBean {
    /**
     * comments : 0
     * headImagePath : /head/2018-04-580.png
     * imageListThumb : ["http://39.107.224f468136360.png","http://39.106394_1524968136908.jpg","http://39.104968137327.jpg"]
     * likes : 0
     * nickname : 李红梅
     * pageviews : 0
     * publishTime : 2018-04-29 10:15:40
     * shareLink : http://www.baidu.com
     * title : postman测试发布话题
     * topicId : 452faafc1bfe4f0585be52255c10748e
     * userId : d56ea66e7ee741f498ca51242c8c6394
     */
    private  int isFavoured;
    private  int isLiked;
    private  int isFollowed;
    private int comments;
    private String headImagePath;
    private int likes;
    private String nickname;
    private int pageviews;
    private String publishTime;
    private String shareLink;
    private String title;
    private String topicId;
    private String userId;
    private List<String> imageListThumb;

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public void setIsFavoured(int isFavoured) {
        this.isFavoured = isFavoured;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }

    public void setIsFollowed(int isFollowed) {
        this.isFollowed = isFollowed;
    }

    public int getIsFavoured() {
        return isFavoured;
    }

    public int getIsLiked() {
        return isLiked;
    }

    public int getIsFollowed() {
        return isFollowed;
    }
}
