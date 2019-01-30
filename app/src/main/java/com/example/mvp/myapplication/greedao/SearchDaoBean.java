package com.example.mvp.myapplication.greedao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @packge: com.example.mvp.myapplication.greedao
 * @filename:SearchDaoBean
 * @date :${DATA} 21:05
 */
@Entity
public class SearchDaoBean {
    @Id
    Long id;
    String  searchName;
    @Generated(hash = 86515070)
    public SearchDaoBean(Long id, String searchName) {
        this.id = id;
        this.searchName = searchName;
    }
    @Generated(hash = 1406499419)
    public SearchDaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSearchName() {
        return this.searchName;
    }
    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
}
