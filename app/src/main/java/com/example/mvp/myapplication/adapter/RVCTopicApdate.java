package com.example.mvp.myapplication.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:RVTopicApdate
 * @date :${DATA} 14:29
 */
public class RVCTopicApdate extends XRecyclerView.Adapter {

    private final ArrayList<TopicBean.TopicListBean> mTopicListBeans;
    private final FragmentActivity mActivity;

    public RVCTopicApdate(ArrayList<TopicBean.TopicListBean> topicListBeans, FragmentActivity activity) {
        mTopicListBeans = topicListBeans;
        mActivity = activity;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_topic, null);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ViewHolder viewHolder= (ViewHolder) holder;
        TopicBean.TopicListBean topicListBean = mTopicListBeans.get(position);
        Log.d("tag",mTopicListBeans.get(position).getHeadImagePath());
        viewHolder.mSdvHeadImagePathTopic.setImageURI(Uri.parse(topicListBean.getHeadImagePath()));

                viewHolder.mTitle.setText(topicListBean.getTitle());

                viewHolder.mTvNicknameTopic.setTextColor(mActivity.getResources().getColor(R.color.blue));
                viewHolder.mTvNicknameTopic.setText(topicListBean.getNickname());
                viewHolder.mTvPublishTime.setText(topicListBean.getPublishTime());
                viewHolder.mTvCommentsTopic.setText(topicListBean.getComments()+"");
                viewHolder.mTvLiskesTopic.setText(topicListBean.getLikes()+"");
                viewHolder.mTvPageViewsTopic.setText(topicListBean.getPageviews()+"");
        List<String> thumb = topicListBean.getImageListThumb();
        if (thumb!=null&&thumb.size()!=0){
                    if (thumb.size()==1){
                          viewHolder.mSdvImageListThumbTopicBig.setVisibility(View.VISIBLE);
                          viewHolder.mSdvImageListThumbTopicBig.setImageURI(Uri.parse(thumb.get(0)));
                    }else {
                        viewHolder.mLlTopicSimThree.setVisibility(View.VISIBLE);
                        viewHolder.mSdvImageListThumbTopicSim1.setImageURI(Uri.parse(thumb.get(0)));
                        viewHolder.mSdvImageListThumbTopicSim3.setImageURI(Uri.parse(thumb.get(1)));
                        if (thumb.size()==3) {
                            viewHolder.mSdvImageListThumbTopicSim4.setImageURI(Uri.parse(thumb.get(2)));
                        }

                    }

                }else {
                 viewHolder.mLlTopicWenzhang.setVisibility(View.VISIBLE);
                 viewHolder.mTvTopicUrl.setText(topicListBean.getShareLink());
        }

    }

    @Override
    public int getItemCount() {
        return mTopicListBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTitle;
        @BindView(R.id.tv_comments_topic)
        TextView  mTvCommentsTopic;
        @BindView(R.id.tv_likes_topic)
        TextView mTvLiskesTopic;
        @BindView(R.id.tv_pageviews_topic)
        TextView  mTvPageViewsTopic;
        @BindView(R.id.tv_publishTime_topic)
        TextView  mTvPublishTime;
        @BindView(R.id.sdv_headImagePath_topic)
        SimpleDraweeView mSdvHeadImagePathTopic;
        @BindView(R.id.tv_nickname_topic)
        TextView mTvNicknameTopic;
        @BindView(R.id.sdv_imageListThumb_topic_big)
        SimpleDraweeView mSdvImageListThumbTopicBig;
        @BindView(R.id.sdv_imageListThumb_topic_sim_1)
        SimpleDraweeView mSdvImageListThumbTopicSim1;
        @BindView(R.id.sdv_imageListThumb_topic_sim_3)
        SimpleDraweeView mSdvImageListThumbTopicSim3;
        @BindView(R.id.sdv_imageListThumb_topic_sim_4)
        SimpleDraweeView mSdvImageListThumbTopicSim4;
        @BindView(R.id.ll_topic_sim_three)
        LinearLayout mLlTopicSimThree;
        @BindView(R.id.tv_topic_url)
        TextView mTvTopicUrl;
        @BindView(R.id.ll_topic_wenzhang)
        LinearLayout mLlTopicWenzhang;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
