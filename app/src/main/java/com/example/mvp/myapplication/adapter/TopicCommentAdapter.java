package com.example.mvp.myapplication.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.ListCommentBean;
import com.example.mvp.myapplication.ui.news.activity.ShowDataActivity;
import com.example.mvp.myapplication.ui.topic.activity.TopicDataActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:TopicCommentAdapter
 * @date :${DATA} 18:39
 */
public class TopicCommentAdapter extends XRecyclerView.Adapter {

    private final ArrayList<ListCommentBean.CommentListBean> mCommentListBeans;
    private final Activity mTopicDataActivity;

    public TopicCommentAdapter(ArrayList<ListCommentBean.CommentListBean> commentListBeans, Activity topicDataActivity) {
        mCommentListBeans = commentListBeans;
        mTopicDataActivity = topicDataActivity;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mTopicDataActivity).inflate(R.layout.item_comment, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.mCommentIconImg.setImageURI(Uri.parse(mCommentListBeans.get(position).getHeadImagePath()));
        viewHolder.mCommentNicknameImg.setText(mCommentListBeans.get(position).getNickname());
        viewHolder.mCommentContentTv.setText(mCommentListBeans.get(position).getContent());
        viewHolder.mCommentCommentTimeTv.setText(mCommentListBeans.get(position).getCommentTime());
    }

    @Override
    public int getItemCount() {
        return mCommentListBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.comment_icon_img)
        SimpleDraweeView mCommentIconImg;
        @BindView(R.id.comment_nickname_img)
        TextView mCommentNicknameImg;
        @BindView(R.id.comment_commentTime_tv)
        TextView mCommentCommentTimeTv;
        @BindView(R.id.comment_content_tv)
        TextView mCommentContentTv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
