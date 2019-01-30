package com.example.mvp.myapplication.greedao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @packge: com.example.mvp.myapplication.greedao
 * @filename:ItemDaoBean
 * @date :${DATA} 11:23
 */
@Entity
public class ItemDaoBean {
      @Id
    Long id;
    String title;
    boolean state;
    String newsId;
@Generated(hash = 832372872)
public ItemDaoBean(Long id, String title, boolean state, String newsId) {
    this.id = id;
    this.title = title;
    this.state = state;
    this.newsId = newsId;
}
@Generated(hash = 1909544858)
public ItemDaoBean() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getTitle() {
    return this.title;
}
public void setTitle(String title) {
    this.title = title;
}
public boolean getState() {
    return this.state;
}
public void setState(boolean state) {
    this.state = state;
}
public String getNewsId() {
    return this.newsId;
}
public void setNewsId(String newsId) {
    this.newsId = newsId;
}



}
