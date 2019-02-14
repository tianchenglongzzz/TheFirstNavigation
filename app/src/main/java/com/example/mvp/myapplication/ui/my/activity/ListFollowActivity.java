package com.example.mvp.myapplication.ui.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.AdapterFollow;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.contact.ListFollowInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListFollowBean;
import com.example.mvp.myapplication.jsonbean.JsonFollow;
import com.example.mvp.myapplication.presenter.ListFollowPresenter;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ListFollowActivity extends BaseActivity<ListFollowInterface.IListFollowV, ListFollowPresenter<ListFollowInterface.IListFollowV>> implements ListFollowInterface.IListFollowV {
    @BindView(R.id.toobar)
    Toolbar mToolbar;
    @BindView(R.id.eiit)
    TextView mEiit;
    @BindView(R.id.moreFollow_ll)
    LinearLayout mMoreFollowLl;
    @NonNull
    @BindView(R.id.rv)
    RecyclerView mRv;
    @BindView(R.id.follow_ll)
    LinearLayout mFollowLl;
    private AdapterFollow mAdapterFollow;
    boolean edit=false;
    private ArrayList<ListFollowBean.FollowListBean> mFollowListBeans;


    @Override
    public int createLayout() {
        return R.layout.activity_list_follow;
    }

    @OnClick(R.id.follow_ll)
    public  void onClick(){
         startActivity(new Intent(this,MoreFollowActivity.class));
    }
    @OnClick({R.id.eiit})
    public void  onClick(View view){
        switch (view.getId()){
            case R.id.eiit:
                if (edit){
                    edit=false;
                    mEiit.setText("设置");
                }else {
                    edit=true;
                    mEiit.setText("完成");
                }
                break;
        }
    }
    @Override
    public void origination() {
        setToobar(mToolbar);
        mFollowListBeans = new ArrayList<>();
        mAdapterFollow = new AdapterFollow(mFollowListBeans, this);
        mRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapterFollow);
        persemter.getListFollqData("c383f4c9026d471da0184ad5b24c0365");
        mAdapterFollow.setOnItemClick(new AdapterFollow.OnItemClick() {
            @Override
            public void onClick(int p, final String followId) {
                  if (mEiit.getText().toString().equals("设置")){

                  }else {
                      new TDialog.Builder(getSupportFragmentManager()).setLayoutRes(R.layout.popwindow_fllow)
                              .setScreenWidthAspect(ListFollowActivity.this, 1f)
                              .setScreenHeightAspect(ListFollowActivity.this, 1f)
                              .addOnClickListener(new int[]{R.id.fllow_yes,R.id.fllow_no})
                              .setOnViewClickListener(new OnViewClickListener() {
                                  @Override
                                  public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                             switch (view.getId()){
                                                 case R.id.fllow_yes:
                                                     String json = jsonUtils.getStudent(new JsonFollow(Global.USER, followId, "1" ));
                                                     persemter.follow(json);
                                                     tDialog.dismiss();
                                                     break;
                                                 case R.id.fllow_no:
                                                     tDialog.dismiss();
                                                     break;
                                             }
                                  }
                              }).create().show();

                  }
            }
        });
    }

    @Override
    public ListFollowPresenter<ListFollowInterface.IListFollowV> createPresenter() {
        return new ListFollowPresenter<>();
    }

    @Override
    public void showListFollowData(ListFollowBean listFollowBean) {
             mFollowListBeans.addAll(listFollowBean.getFollowList());
             mAdapterFollow.notifyDataSetChanged();

      }

    @Override
    public void showfollow(InfoBean infoBean) {
                mFollowListBeans.clear();
                showTost(infoBean.getMessage());
               persemter.getListFollqData(Global.USER);
    }
}
