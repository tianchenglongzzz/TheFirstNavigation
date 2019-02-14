package com.example.mvp.myapplication.http.bean.callback;

import java.io.Serializable;
import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:listProfessionBean
 * @date :${DATA} 22:16
 */
public class ListProfessionBean implements Serializable {


    private List<ProfessionListBean> professionList;

    public List<ProfessionListBean> getProfessionList() {
        return professionList;
    }

    public void setProfessionList(List<ProfessionListBean> professionList) {
        this.professionList = professionList;
    }

    public static class ProfessionListBean {
        /**
         * professionId : 2189fdcf3b0411e8b64c00163e30445d
         * professionName : 飞行驾驶
         */

        private String professionId;
        private String professionName;

        public String getProfessionId() {
            return professionId;
        }

        public void setProfessionId(String professionId) {
            this.professionId = professionId;
        }

        public String getProfessionName() {
            return professionName;
        }

        public void setProfessionName(String professionName) {
            this.professionName = professionName;
        }
    }
}
