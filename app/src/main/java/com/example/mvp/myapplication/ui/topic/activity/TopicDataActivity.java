package com.example.mvp.myapplication.ui.topic.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.TopicCommentAdapter;
import com.example.mvp.myapplication.adapter.TopicInfoImgAdapter;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.TopicInfoInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListCommentBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;
import com.example.mvp.myapplication.jsonbean.JsonFollow;
import com.example.mvp.myapplication.jsonbean.JsonInserCommentBean;
import com.example.mvp.myapplication.jsonbean.JsonListComment;
import com.example.mvp.myapplication.jsonbean.JsonShouChang;
import com.example.mvp.myapplication.presenter.TopicInfoPresenter;
import com.example.mvp.myapplication.presenter.TopicPresenter;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.example.mvp.myapplication.watcher.SoftKeyboardStateWatcher;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.RequestBody;

//详情
public class TopicDataActivity extends BaseActivity<TopicInfoInterface.ITopicInfoIntefaceV,TopicInfoPresenter<TopicInfoInterface.ITopicInfoIntefaceV>>
        implements TopicInfoInterface.ITopicInfoIntefaceV {
    @BindView(R.id.topic_ingo_nsv)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.img_headImagePath_info)
    SimpleDraweeView mImgHeadImagePathInfo;
    @BindView(R.id.tv_nickname_info)
    TextView mTvNicknameInfo;
    @BindView(R.id.tv_publishTime)
    TextView mTvPublishTime;
    @BindView(R.id.rv_topic_info)
    RecyclerView mRvTopicInfo;
    @BindView(R.id.img_praise)
    ImageView mImgPraise;
    @BindView(R.id.tv_praise)
    TextView mTvPraise;
    @BindView(R.id.tv_topic_listComment)
    RecyclerView mTvTopicListComment;
    @BindView(R.id.info_share)
    TextView mInfoShare;
    @BindView(R.id.info_comment)
    TextView mInfoComment;
    @BindView(R.id.info_favoured)
    TextView mInfoFavoured;
    @BindView(R.id.cv_tool)
    CardView mCvTool;
    @BindView(R.id.topic_title_tv)
    TextView mTopicTilteTv;
    @BindView(R.id.topic_isFollowed_tv)
    TextView mIsFollowedButton;
    @BindView(R.id.topic_info_toobar)
    Toolbar mToolbar;
    @BindView(R.id.topic_info_url_tv)
    TextView mTopicInfoUrlTv;
    @BindView(R.id.topic_comment_title_tv)
    TextView mTopicCommentTitle;
    @BindView(R.id.topic_head_rl)
    RelativeLayout mRelativeLayout;
    String followType="0";
    Handler mHandler =new Handler();
    private String mId;
    private ArrayList<ListCommentBean.CommentListBean> mCommentListBeans;
    private TopicCommentAdapter mTopicCommentAdapter;
    private String mShareLinkUrl;
    private int mMie;
    private PopupWindow mPopComment;
    private String mCursor;
    private String mUserId;
    //判断是否收藏 的 int
    private int mIsFavoured;


    @Override
    public int createLayout() {
        return R.layout.activity_topic_data;
    }

    @Override
    public void origination() {
        setToobar();
        Intent intent = getIntent();
        mId = intent.getStringExtra("id");
        mMie = intent.getIntExtra("ie",0);

        persemter.getTopicListjson(mId,"c383f4c9026d471da0184ad5b24c0365");
        mCommentListBeans = new ArrayList<>();
        mTopicCommentAdapter = new TopicCommentAdapter(mCommentListBeans,this);
        mTvTopicListComment.setLayoutManager(new LinearLayoutManager(this));
        mTvTopicListComment.setAdapter(mTopicCommentAdapter);
        String json = jsonUtils.getStudent(new JsonListComment(mId, "1", 0));
        persemter.getlistComment(json);
        if (mMie==1){
            mTopicTilteTv.setVisibility(View.GONE);
            mRelativeLayout.setVisibility(View.GONE);
           mRvTopicInfo.setVisibility(View.GONE);
        }
        SoftKeyboardStateWatcher watcher = new SoftKeyboardStateWatcher(mNestedScrollView, this);
        watcher.addSoftKeyboardStateListener(new SoftKeyboardStateWatcher.SoftKeyboardStateListener() {
            @Override
            public void onSoftKeyboardOpened(int keyboardHeightInPx) {

            }

            @Override
            public void onSoftKeyboardClosed() {
                mCvTool.setVisibility(View.VISIBLE);
                mPopComment.dismiss();
            }
        });

    }

    private void setToobar() {
         mToolbar.setTitle("");
         mToolbar.setNavigationIcon(R.mipmap.smallfanhui);
         setSupportActionBar(mToolbar);
         mToolbar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                   finish();
             }
         });
    }

    @Override
    public TopicInfoPresenter createPresenter() {
        return new TopicInfoPresenter();
    }

    @OnClick({R.id.topic_info_toobar, R.id.img_headImagePath_info, R.id.tv_nickname_info, R.id.tv_publishTime, R.id.rv_topic_info, R.id.img_praise, R.id.tv_praise, R.id.tv_topic_listComment, R.id.info_share, R.id.info_comment, R.id.info_favoured, R.id.cv_tool,R.id.topic_isFollowed_tv})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.topic_info_toobar:
                break;
            case R.id.img_headImagePath_info:
                break;
            case R.id.tv_nickname_info:
                break;
            case R.id.tv_publishTime:
                break;
            case R.id.rv_topic_info:
                break;
            case R.id.img_praise:
                break;
            case R.id.tv_praise:
                break;
            case R.id.tv_topic_listComment:
                break;
            case R.id.info_share://分享
                break;
            case R.id.info_comment://评论
                showCommentP();
                break;
            case R.id.info_favoured://收藏
                if (mIsFavoured==0) {
                    String json = jsonUtils.getStudent(new JsonShouChang(Global.USER, mId, "1", "1"));
                    persemter.getFavourite(json);
                }else {

                }

                break;
            case R.id.cv_tool:
                break;
            case  R.id.topic_isFollowed_tv://关注
                setYetFollowe();
                setFollowe();
                break;
        }
    }

    private void setFollowe() {
        Log.d("tag","====================");
        String json = jsonUtils.getStudent(new JsonFollow(Global.USER, mUserId, followType));
        persemter.followUser(json);
    }
//详情的数据
    @SuppressLint("ResourceAsColor")
    @Override
    public void showTopicListBean(TopicListBean topicListBean) {
        mIsFavoured = topicListBean.getIsFavoured();
            setTextViewImg();
        setHead(topicListBean);
        mUserId = topicListBean.getUserId();
        if (topicListBean.getImageListThumb()!=null) {

            setRvApdate(topicListBean.getImageListThumb());
        }else {
            mRvTopicInfo.setVisibility(View.GONE);
            mTopicInfoUrlTv.setVisibility(View.VISIBLE);
            mShareLinkUrl = topicListBean.getShareLink();
            mTopicInfoUrlTv.setText(mShareLinkUrl);
            mTopicInfoUrlTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
                    intent.setData(Uri.parse(mShareLinkUrl)); //为Intent设置DATA属性
                    startActivity(intent);
                }
            });


        }


    }

    private void setTextViewImg() {
              if (mIsFavoured==0){
                  Drawable drawable = getResources().getDrawable(R.mipmap.news_favoured);
                  drawable.setBounds(0,0,drawable.getMinimumHeight(),drawable.getMinimumWidth());
                  mInfoFavoured.setCompoundDrawables(drawable,null,null,null);
              }else {
                  Drawable drawable = getResources().getDrawable(R.mipmap.news_favoured_high);
                  drawable.setBounds(0,0,drawable.getMinimumHeight(),drawable.getMinimumWidth());
                  mInfoFavoured.setCompoundDrawables(drawable,null,null,null);
              }

    }

    //获得评论数据
    @Override
    public void showlistComment(ListCommentBean listCommentBean) {
        mCursor = listCommentBean.getCursor();
        mTopicCommentTitle.setText("热门评论"+listCommentBean.getCommentList().size()+"条");
        if (listCommentBean!=null) {
            mCommentListBeans.clear();
            mCommentListBeans.addAll(listCommentBean.getCommentList());
            mTopicCommentAdapter.notifyDataSetChanged();
        }



        }

        //获得评论之后的数据
    @Override
    public void showCommentData(InfoBean value) {
      showTost(value.getMessage());
        String json = jsonUtils.getStudent(new JsonListComment(mId, "1", Integer.parseInt(mCursor)));
        persemter.getlistComment(json);
    }
  //关注之后的数据
    @Override
    public void showFollow(InfoBean infoBean) {
         setYetFollowe();

    }
   //收藏之后返回的数据
    @Override
    public void showFavouriteData(InfoBean infoBean) {
        String message = infoBean.getMessage();
        showTost(message+infoBean.getCode());
        if (mIsFavoured==1) {
             mIsFavoured=0;
          }else {
              mIsFavoured=1;
          }
          setTextViewImg();
    }


    //设置关注状态
    private void setBackFollowe() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GradientDrawable drawable= (GradientDrawable)mIsFollowedButton.getBackground();
                drawable.setColor(getResources().getColor(R.color.read));
                mIsFollowedButton.setText("关注");
                mIsFollowedButton.setBackground(drawable);
            }
        });

    }


    //设置适配器
    private void setRvApdate(List<String> imageListThumb) {

        TopicInfoImgAdapter adapter = new TopicInfoImgAdapter(this,imageListThumb);
        mRvTopicInfo.setLayoutManager(new GridLayoutManager(this,3));
        mRvTopicInfo.setAdapter(adapter);

    }

    //设置顶头布局
    @SuppressLint("ResourceAsColor")
    private void setHead(TopicListBean topicListBean) {
        mTopicTilteTv.setText(topicListBean.getTitle());
        mImgHeadImagePathInfo.setImageURI(Uri.parse(topicListBean.getHeadImagePath()));
        mTvNicknameInfo.setText(topicListBean.getNickname());
        mTvPublishTime.setText(topicListBean.getPublishTime());
        int isFavoured = topicListBean.getIsFavoured();
        if (isFavoured==1){

            followType="1";
            setYetFollowe();

        }
        int isLiked = topicListBean.getIsLiked();
        showTost(isLiked+"");
        if (isLiked==1){
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       mImgPraise.setImageResource(R.mipmap.topic_praise_high);
                   }
               });

        }else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mImgPraise.setImageResource(R.mipmap.topic_praise);
                }
            });

        }
    }

//关注 的状态
    private void setYetFollowe() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mIsFollowedButton.getText().toString().equals("取消")){
                    mIsFollowedButton.setText("关注");
                    GradientDrawable drawable= (GradientDrawable)mIsFollowedButton.getBackground();
                    drawable.setColor(getResources().getColor(R.color.read));
                    mIsFollowedButton.setBackground(drawable);
                }else {
                    mIsFollowedButton.setText("取消");
                    GradientDrawable drawable= (GradientDrawable)mIsFollowedButton.getBackground();
                    drawable.setColor(getResources().getColor(R.color.gray));
                    mIsFollowedButton.setBackground(drawable);
                }

            }
        });

    }
  //输入框pop 建立 与 弹出
    private void showCommentP() {
        final View popcoment = LayoutInflater.from(this).inflate(R.layout.popcoment, null);
        setPopC(popcoment);
        TextView cancel = popcoment.findViewById(R.id.popcoment_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCvTool.setVisibility(View.VISIBLE);
                mPopComment.dismiss();
            }
        });
     final EditText topicCommentEdText=popcoment.findViewById(R.id.comment_ed);
     TextView topicCommentTextView=popcoment.findViewById(R.id.comment_enter);
     topicCommentTextView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

                  if (!TextUtils.isEmpty(topicCommentEdText.getText().toString())) {
                      String json = jsonUtils.getStudent(new JsonInserCommentBean("c383f4c9026d471da0184ad5b24c0365", mId, "1", topicCommentEdText.getText().toString()));
                      persemter.getCommentData(json);
                      mPopComment.dismiss();
                  }else {

                      showTost("输入不能为空");
                  }

         }
     });
    }

    private void setPopC(View popcoment) {
        mCvTool.setVisibility(View.GONE);
        mPopComment = new PopupWindow(this);
        mPopComment.setContentView(popcoment);
        mPopComment.setBackgroundDrawable(new ColorDrawable());
        mPopComment.setFocusable(true);
        mPopComment.setAnimationStyle(R.style.anim_pop_bottombar);
        mPopComment.setHeight(this.getWindowManager().getDefaultDisplay().getHeight());
        mPopComment.setWidth(this.getWindowManager().getDefaultDisplay().getWidth());
        mPopComment.showAtLocation(mToolbar, Gravity.NO_GRAVITY, 0, 0);
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        @SuppressLint("ResourceType") MenuItem add = menu.add(R.menu.info_menu);
        return super.onCreateOptionsMenu(menu);
    }
}
