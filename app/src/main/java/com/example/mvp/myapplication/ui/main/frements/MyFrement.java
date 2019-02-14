package com.example.mvp.myapplication.ui.main.frements;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.base.fragment.BottomFragment;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.UserCenterInterface;
import com.example.mvp.myapplication.http.bean.callback.UserCenterBean;
import com.example.mvp.myapplication.presenter.UserCenterPresenter;
import com.example.mvp.myapplication.ui.login.activity.LoginActivity;
import com.example.mvp.myapplication.ui.my.activity.FeedbackActivity;
import com.example.mvp.myapplication.ui.my.activity.InforomTowActivity;
import com.example.mvp.myapplication.ui.my.activity.ListCommentActivity;
import com.example.mvp.myapplication.ui.my.activity.ListFollowActivity;
import com.example.mvp.myapplication.ui.my.activity.ListNotifyActivity;
import com.example.mvp.myapplication.ui.my.activity.MyCollectActivity;
import com.example.mvp.myapplication.ui.my.activity.MyListTopicActivity;
import com.example.mvp.myapplication.ui.my.activity.SettingActivity;
import com.example.mvp.myapplication.ui.my.activity.UpdateinfoActivity;
import com.example.mvp.myapplication.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFrement extends BaseFragment<UserCenterInterface.IUserCenterV,UserCenterPresenter<UserCenterInterface.IUserCenterV>> implements UserCenterInterface.IUserCenterV{
    @BindView(R.id.my_unMessages_tv)
    TextView mMyUnMessages;
    @BindView(R.id.my_login_true_nickname_tv)
    TextView  mNickName;
    @BindView(R.id.my_login_true_settingNickname_tv)
    TextView mSettingNickname;
    @BindView(R.id.my_login_icon_false_img)
    ImageView mMyLoginIconFalseImg;
    @BindView(R.id.my_login_false_text_ll)
    LinearLayout mMyLoginFalseTextLl;
    @BindView(R.id.my_login_false_collect_tv)
    TextView mMyLoginFalseCollectTv;
    @BindView(R.id.my_login_false_history_tv)
    TextView mMyLoginFalseHistoryTv;
    @BindView(R.id.my_login_false_concern_tv)
    TextView mMyLoginFalseConcernTv;
    @BindView(R.id.my_login_false_discuss_tv)
    TextView mMyLoginFalseDiscussTv;
    @BindView(R.id.my_login_false_newsInform_rl)
    RelativeLayout mMyLoginFalseNewsInformRl;
    @BindView(R.id.my_login_false_myPublish_rl)
    RelativeLayout mMyLoginFalseMyPublishRl;
    @BindView(R.id.my_login_false_userFeedback_rl)
    RelativeLayout mMyLoginFalseUserFeedbackRl;
    @BindView(R.id.my_login_false_setting_rl)
    TextView mMyLoginFalseSettingRl;
    @BindView(R.id.my_login_false_ll)
    LinearLayout mMyLoginFalseLl;
    @BindView(R.id.my_login_icon_true_sdv)
    SimpleDraweeView mMyLoginIconTrueImg;
    @BindView(R.id.my_login_true_tow_ll)
    LinearLayout mMyLoginFalseTrueLl;
    @BindView(R.id.my_login_true_collect_tv)
    TextView mMyLoginTrueCollectTv;
    @BindView(R.id.my_login_true_collect_ll)
    LinearLayout mMyLoginTrueCollectLl;
    @BindView(R.id.my_login_true_history_tv)
    TextView mMyLoginTrueHistoryTv;
    @BindView(R.id.my_login_true_history_ll)
    LinearLayout mMyLoginTrueHistoryLl;
    @BindView(R.id.my_login_true_concern_tv)
    TextView mMyLoginTrueConcernTv;
    @BindView(R.id.my_login_true_concern_ll)
    LinearLayout mMyLoginTrueConcernLl;
    @BindView(R.id.my_login_true_discuss_tv)
    TextView mMyLoginTrueDiscussTv;
    @BindView(R.id.my_login_true_discuss_ll)
    LinearLayout mMyLoginTrueDiscussLl;
    @BindView(R.id.my_login_true_newsInform_hot_img)
    ImageView mMyLoginTrueNewsInformHotImg;
    @BindView(R.id.my_login_true_newsInform_rl)
    RelativeLayout mMyLoginTrueNewsInformRl;
    @BindView(R.id.my_login_true_myPublish_rl)
    RelativeLayout mMyLoginTrueMyPublishRl;
    @BindView(R.id.my_login_true_userFeedback_rl)
    RelativeLayout mMyLoginTrueUserFeedbackRl;
    @BindView(R.id.my_login_true_setting_rl)
    RelativeLayout mMyLoginTrueSettingRl;
    @BindView(R.id.my_login_true_ll)
    LinearLayout mMyLoginTrueLl;
    private View view;
    private Unbinder unbinder;
    private String mHeadImagePath;

    public MyFrement() {
        // Required empty public constructor
    }




    @OnClick({R.id.my_login_icon_false_img, R.id.my_login_false_text_ll, R.id.my_login_false_collect_tv, R.id.my_login_false_history_tv, R.id.my_login_false_concern_tv, R.id.my_login_false_discuss_tv, R.id.my_login_false_newsInform_rl, R.id.my_login_false_myPublish_rl, R.id.my_login_false_userFeedback_rl, R.id.my_login_false_setting_rl, R.id.my_login_false_ll, R.id.my_login_true_collect_tv, R.id.my_login_true_collect_ll, R.id.my_login_true_history_tv, R.id.my_login_true_history_ll, R.id.my_login_true_concern_tv, R.id.my_login_true_concern_ll, R.id.my_login_true_discuss_tv, R.id.my_login_true_discuss_ll, R.id.my_login_true_newsInform_hot_img, R.id.my_login_true_newsInform_rl, R.id.my_login_true_myPublish_rl, R.id.my_login_true_userFeedback_rl, R.id.my_login_true_setting_rl, R.id.my_login_true_ll,R.id.my_login_true_settingNickname_tv})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.my_login_icon_false_img:
                startLoainActivity();
                break;
            case R.id.my_login_false_text_ll:
                break;
            case R.id.my_login_false_collect_tv:
                break;
            case R.id.my_login_false_history_tv:
                break;
            case R.id.my_login_false_concern_tv:
                break;
            case R.id.my_login_false_discuss_tv:
                break;
            case R.id.my_login_false_newsInform_rl:
                break;
            case R.id.my_login_false_myPublish_rl:
                break;
            case R.id.my_login_false_userFeedback_rl:
                break;
            case R.id.my_login_false_setting_rl:
                break;
            case R.id.my_login_false_ll:
                break;
            case R.id.my_login_true_collect_tv:
                break;
            case R.id.my_login_true_collect_ll:
                 startActivityForResult(new Intent(getContext(),MyCollectActivity.class),20);
                break;
            case R.id.my_login_true_history_tv:
                break;
            case R.id.my_login_true_history_ll:
                break;
            case R.id.my_login_true_concern_tv:
                break;
            case R.id.my_login_true_concern_ll:
                 initListFollowAcivity();
                break;
            case R.id.my_login_true_discuss_tv:
                break;
            case R.id.my_login_true_discuss_ll:
                 startActivity(new Intent(getContext(),ListCommentActivity.class));
                break;
            case R.id.my_login_true_newsInform_hot_img:
                break;
            case R.id.my_login_true_newsInform_rl:
                startActivity(new Intent(getContext(),ListNotifyActivity.class));
                break;
            case R.id.my_login_true_myPublish_rl:
                startActivity(new Intent(getContext(),MyListTopicActivity.class));
                break;
            case R.id.my_login_true_userFeedback_rl:
                Intent intent = new Intent(getContext(), FeedbackActivity.class);
                intent.putExtra("headImg",mHeadImagePath);
                startActivity(intent);
                break;
            case R.id.my_login_true_setting_rl:
                startActivityForResult(new Intent(getContext(),SettingActivity.class),20);
                break;
            case R.id.my_login_true_ll:
                break;
            case R.id.my_login_true_settingNickname_tv:
                startEditInfo();
                break;
        }
    }

    private void initListFollowAcivity() {
        Intent intent = new Intent(getContext(), ListFollowActivity.class);
        startActivity(intent);
    }

    private void startEditInfo() {
        Intent intent = new Intent(getContext(), UpdateinfoActivity.class);
        startActivityForResult(intent,10);

    }

    private void startLoainActivity() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initEvemtData() {

        boolean state = SharedPreferencesUtils.getSharedPreferences(getContext()).getBoolean("loginState", false);
        if (state){
             initData();
        }else {

        }
    }

    private void initData() {
        mMyLoginFalseLl.setVisibility(View.GONE);
        mMyLoginTrueLl.setVisibility(View.VISIBLE);
        persenter.setCenterData("c383f4c9026d471da0184ad5b24c0365");
    }

    @Override
    public int createLayout() {
        return R.layout.fragment_my_frement;
    }
    @Subscribe
    public void  getEvenBusLoginWin(String login){
          showTost(login);
        initData();
        SharedPreferencesUtils.getSharedPreferences(getContext()).putBoolean("loginState",true);
    }

    @Override
    public UserCenterPresenter createPresnter() {
        return new UserCenterPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
      EventBus.getDefault().unregister(this);

    }

    @Override
    public void showCenterData(UserCenterBean data) {
        mHeadImagePath = data.getHeadImagePath();
        mMyLoginTrueHistoryTv.setText(data.getHistoryReads()+"");
              mMyLoginTrueCollectTv.setText(data.getFavorites()+"");
              mMyLoginTrueDiscussTv.setText(data.getComments()+"");
              mMyLoginTrueCollectTv.setText(data.getFollowing()+"");
              mMyLoginIconTrueImg.setImageURI(Uri.parse(data.getHeadImagePath()));
              mNickName.setText(data.getNickname());
              if (data.getUnMessages()==1){
                  mMyUnMessages.setText("您的话题审核未通过");
              }else if (data.getUnMessages()==2){
                  mMyUnMessages.setText("您的评伦不符合规则");
              }else if (data.getUnMessages()==3){
                  mMyUnMessages.setText("您的用户存在问题");
              }else if (data.getUnMessages()==4){
                  mMyUnMessages.setText("标题截取");
              }else if (data.getUnMessages()==5){
                  mMyUnMessages.setText("您加入的圈子有最新平论");
              }else if (data.getUnMessages()==6){
                  mMyUnMessages.setText("有人评论了您的话题");
              }else if (data.getUnMessages()==7){
                  mMyUnMessages.setText("有人关注了您");
              }else if (data.getUnMessages()==8){
                  mMyUnMessages.setText("有人点赞了您的话题");
              }else {
                  mMyUnMessages.setText("没有通知");
              }





    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10&&resultCode==10){
            persenter.setCenterData("c383f4c9026d471da0184ad5b24c0365");
        }else if (requestCode==20&&resultCode==20){
            mMyLoginTrueLl.setVisibility(View.GONE);
            mMyLoginFalseLl.setVisibility(View.VISIBLE);

        }
    }
}
