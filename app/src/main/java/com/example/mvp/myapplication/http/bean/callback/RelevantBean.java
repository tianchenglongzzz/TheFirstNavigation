package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:RelevantBean
 * @date :${DATA} 10:58
 */
public class RelevantBean {

    /**
     * pageviews : 0
     * imageListThumb : ["http://www.ga.cn/images/defaultpic.gif"]
     * layoutType : 1
     * newsId : aa2b9ac65a3148279ea0a90e24c0d0f0
     * origin : 中国通航网
     * publishTime : 2018-04-26
     * title : 哈飞制造运12E国产飞机畅销多国赢大赞！美俄都被征服送来大单
     */

    private int pageviews;
    private String layoutType;
    private String newsId;
    private String origin;
    private String publishTime;
    private String title;
    private List<String> imageListThumb;

    public int getPageviews() {
        return pageviews;
    }

    public void setPageviews(int pageviews) {
        this.pageviews = pageviews;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImageListThumb() {
        return imageListThumb;
    }

    public void setImageListThumb(List<String> imageListThumb) {
        this.imageListThumb = imageListThumb;
    }
}
