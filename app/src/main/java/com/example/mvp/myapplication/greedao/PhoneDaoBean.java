package com.example.mvp.myapplication.greedao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @packge: com.example.mvp.myapplication.greedao
 * @filename:PhoneDaoBean
 * @date :${DATA} 17:00
 */
//标注一张标
@Entity
public class PhoneDaoBean {
     //id
     @Id
     Long id;
     //手机号
     String phone;
     @Generated(hash = 2075045107)
     public PhoneDaoBean(Long id, String phone) {
         this.id = id;
         this.phone = phone;
     }
     @Generated(hash = 346200999)
     public PhoneDaoBean() {
     }
     public Long getId() {
         return this.id;
     }
     public void setId(Long id) {
         this.id = id;
     }
     public String getPhone() {
         return this.phone;
     }
     public void setPhone(String phone) {
         this.phone = phone;
     }



     

}
