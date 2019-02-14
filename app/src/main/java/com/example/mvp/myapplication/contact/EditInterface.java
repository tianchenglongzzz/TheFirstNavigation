package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.AboutUsBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:EditInterface
 * @date :${DATA} 7:54
 */
public interface EditInterface {

    //设置V层接口
    interface IEditV extends IBaseView {
        //关于我们数据回调到V层
        void showAboutUsBean(AboutUsBean aboutUsBean);

    }
    //设置M层接口
    interface IEditM extends HttpFinshCallBack {
        //关于我们从M到P
        void setAboutUsBean(AboutUsBean aboutUsBean);

    }
    //设置P层接口
    interface IEditP{
        //请求数据关于我们
        void getAboutUsBean();
    }


}
