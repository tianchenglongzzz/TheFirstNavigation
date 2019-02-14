package com.example.mvp.myapplication.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.ListNotifyBean;
import com.example.mvp.myapplication.ui.my.activity.ListNotifyActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:ListNotifyAdapter
 * @date :${DATA} 22:17
 */
public class ListNotifyAdapter extends RecyclerView.Adapter {
    private static final int SYSTEM = 0;
    private static final int CONCERN = 1;
    private static final int COMMENT = 2;
    private static final int LIKES = 3;

    private final ArrayList<ListNotifyBean> mListNotifyBeans;
    private Activity mListNotifyActivity1;

    public ListNotifyAdapter(ArrayList<ListNotifyBean> listNotifyBeans, Activity listNotifyActivity) {
        mListNotifyBeans = listNotifyBeans;
        mListNotifyActivity1 = listNotifyActivity;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SYSTEM) {
            View view = LayoutInflater.from(mListNotifyActivity1).inflate(R.layout.item_notify_system, null);
            return  new  ViewHolderSystem(view);
        }
        if (viewType == CONCERN) {
            View view = LayoutInflater.from(mListNotifyActivity1).inflate(R.layout.item_notify_concern, null);
            return new ViewHolderCoocern(view);
        }
        if (viewType == COMMENT) {
            View view = LayoutInflater.from(mListNotifyActivity1).inflate(R.layout.item_notify_comment, null);
            return new ViewHolderComment(view);
        } else {
            View view = LayoutInflater.from(mListNotifyActivity1).inflate(R.layout.item_notify_likes, null);
            return  new ViewHolderLikes(view);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        ListNotifyBean notifyBean = mListNotifyBeans.get(position);
        if (viewType == SYSTEM) {
           ViewHolderSystem  viewHolderSystem= (ViewHolderSystem) holder;
           viewHolderSystem.mContentTv.setText(notifyBean.getNotifyContent());
           viewHolderSystem.mNicknameTv.setText("系统通知");
           viewHolderSystem.mTitleTv.setText(notifyBean.getNotifyTitle());
           viewHolderSystem.mTimeTv.setText(notifyBean.getNotifyTime());
        }
        if (viewType == CONCERN) {
          ViewHolderCoocern coocern= (ViewHolderCoocern) holder;
          coocern.mNicknameTv.setText(notifyBean.getNickname());
          coocern.mSdvHeadImagePath.setImageURI(notifyBean.getHeadImagePath());
          coocern.mPublishTimeTv.setText(notifyBean.getNotifyTime());
        }
        if (viewType == COMMENT) {
          ViewHolderComment comment= (ViewHolderComment) holder;
          comment.mNicknameTv.setText(notifyBean.getNickname());
          comment.mCommentTv.setText(notifyBean.getNotifyContent());
          comment.mSdvHeadImagePath.setImageURI(notifyBean.getHeadImagePath());
          comment.mContentTv.setText(notifyBean.getNotifyTitle());
          comment.mPublishTimeTv.setText(notifyBean.getNotifyTime());
        } else if (viewType==LIKES){
            ViewHolderLikes holderLikes= (ViewHolderLikes) holder;
             holderLikes.mNicknameTv.setText(notifyBean.getNickname());
             holderLikes.mPublishTimeTv.setText(notifyBean.getNotifyTime());
             holderLikes.mSdvHeadImagePath.setImageURI(notifyBean.getHeadImagePath());
        }
    }

    @Override
    public int getItemCount() {
        return mListNotifyBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        String notifyType = mListNotifyBeans.get(position).getNotifyType();
        Log.d("tag",notifyType);
        int i = Integer.parseInt(notifyType);////通知类型：0-系统通知，1-关注通知，2-评论通知，3-点赞通知
        if (i == 0) {
            return SYSTEM;
        } else if (i == 1) {
            return CONCERN;
        } else if (i == 2) {
            return COMMENT;
        } else{
            return LIKES;
        }



    }

    static class ViewHolderSystem extends RecyclerView.ViewHolder {
        @NonNull
        @BindView(R.id.nickname_tv)
        TextView mNicknameTv;
        @NonNull
        @BindView(R.id.time_tv)
        TextView mTimeTv;
        @NonNull
        @BindView(R.id.title_tv)
        TextView mTitleTv;
        @NonNull
        @BindView(R.id.content_tv)
        TextView mContentTv;

        ViewHolderSystem(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderCoocern extends RecyclerView.ViewHolder {
        @NonNull
        @BindView(R.id.sdv_headImagePath)
        SimpleDraweeView mSdvHeadImagePath;
        @NonNull
        @BindView(R.id.nickname_tv)
        TextView mNicknameTv;
        @NonNull
        @BindView(R.id.publishTime_tv)
        TextView mPublishTimeTv;

        ViewHolderCoocern(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderComment extends RecyclerView.ViewHolder {
        @BindView(R.id.content_tv)
        TextView mContentTv;
        @BindView(R.id.sdv_headImagePath)
        SimpleDraweeView mSdvHeadImagePath;
        @BindView(R.id.nickname_tv)
        TextView mNicknameTv;
        @BindView(R.id.publishTime_tv)
        TextView mPublishTimeTv;
        @BindView(R.id.comment_tv)
        TextView mCommentTv;

        ViewHolderComment(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderLikes extends RecyclerView.ViewHolder {
        @NonNull
        @BindView(R.id.sdv_headImagePath)
        SimpleDraweeView mSdvHeadImagePath;
        @NonNull
        @BindView(R.id.nickname_tv)
        TextView mNicknameTv;
        @NonNull
        @BindView(R.id.publishTime_tv)
        TextView mPublishTimeTv;

        ViewHolderLikes(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
