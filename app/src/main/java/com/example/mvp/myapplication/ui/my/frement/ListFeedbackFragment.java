package com.example.mvp.myapplication.ui.my.frement;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.ListFeedbackAdapter;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.contact.ListFeedbackInterface;
import com.example.mvp.myapplication.http.bean.callback.FeedBackBean;
import com.example.mvp.myapplication.http.bean.callback.ListFeedbackBean;
import com.example.mvp.myapplication.presenter.ListFeedbackPresenter;
import com.example.mvp.myapplication.utils.BitmapUtils;
import com.example.mvp.myapplication.utils.SoftInputUtil;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ListFeedbackFragment extends BaseFragment<ListFeedbackInterface.IlistFeedbackV,ListFeedbackPresenter<ListFeedbackInterface.IlistFeedbackV>> implements ListFeedbackInterface.IlistFeedbackV {
     @BindView(R.id.edit_fankui)
    EditText mEditText;
     @BindView(R.id.img_feedback)
    ImageView  mImageView;
    private final String mHeadImg;
    @BindView(R.id.listFeedback_rv)
    RecyclerView  mlistFeedabckrv;
    private ListFeedbackAdapter mAdapter;
    private ArrayList<ListFeedbackBean.FeedbackListBean> mListBeans;

    public ListFeedbackFragment(String headImg) {
        // Required empty public constructor
        mHeadImg = headImg;

    }

    @Override
    protected void initEvemtData() {
        mEditText.setCursorVisible(false);
        mEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode ==KeyEvent.KEYCODE_ENTER){
                    String s = mEditText.getText().toString();
                    mEditText.setText("");
                    if (!TextUtils.isEmpty(s)){
                        persenter.getfeedbackData(Global.USER,null,"0",s);
                    }
                    return  true;
                }

                return false;
            }
        });
        mListBeans = new ArrayList<>();
        mAdapter = new ListFeedbackAdapter(mListBeans, getActivity(), mHeadImg);
        mlistFeedabckrv.setLayoutManager(new LinearLayoutManager(getContext()));
        mlistFeedabckrv.setAdapter(mAdapter);
        persenter.getlistFeedbackData(Global.USER);

    }

    @Override
    public int createLayout() {
        return R.layout.fragment_list_feedback;
    }
    @OnClick({R.id.edit_fankui,R.id.feedback_ll,R.id.img_feedback})
    public  void  onClick(View view){
        switch (view.getId()){
            case R.id.edit_fankui:
                mEditText.setCursorVisible(true);
                break;
            case  R.id.feedback_ll:
                SoftInputUtil.closeSoftInput(getActivity(),mEditText);
                break;
            case  R.id.img_feedback:
                Matisse.from(this)
                        .choose( MimeType.allOf()) // 选择 mime 的类型
                        .countable(true)
                        .maxSelectable(1) // 图片选择的最多数量
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f) // 缩略图的比例
                        .imageEngine(new GlideEngine()) // 使用的图片加载引擎
                        .forResult(Global.REQUEST_CODE_CHOOSE); // 设置作为标记的请求码
                break;

        }
    }
    @Override
    public ListFeedbackPresenter<ListFeedbackInterface.IlistFeedbackV> createPresnter() {
           return new ListFeedbackPresenter<>();

    }

    @Override
    public void showListFeedbackData(ListFeedbackBean listFeedbackBean) {
           mListBeans.addAll(listFeedbackBean.getFeedbackList());
           mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showfeedbackData(FeedBackBean feedBackBean) {
         mListBeans.clear();
        persenter.getlistFeedbackData(Global.USER);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Global.REQUEST_CODE_CHOOSE&&resultCode== Activity.RESULT_OK){
            List<Uri> uris = Matisse.obtainResult(data);
            try {
                File file = BitmapUtils.getFile(BitmapUtils.getBitmapFormUri(getActivity(), uris.get(0)));
                persenter.getfeedbackData(Global.USER,file,"1",null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
