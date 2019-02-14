package com.example.mvp.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.MyListTopicBean;
import com.example.mvp.myapplication.ui.my.activity.MyListTopicActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:MylistTopicAdapter
 * @date :${DATA} 15:42
 */
public class MylistTopicAdapter extends RecyclerView.Adapter {

    private ArrayList<MyListTopicBean.FavouritTopicListBean> mListBeans;
    private MyListTopicActivity mMyListTopicActivity;

    public MylistTopicAdapter(ArrayList<MyListTopicBean.FavouritTopicListBean> listBeans, MyListTopicActivity myListTopicActivity) {
        mListBeans = listBeans;
        mMyListTopicActivity = myListTopicActivity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(mMyListTopicActivity).inflate(R.layout.item_my_topic, null);
            return new ViewHolderOne(view);
        } else if (viewType == 3) {
            View view = LayoutInflater.from(mMyListTopicActivity).inflate(R.layout.item_my_topic_three, null);
            return new ViewHolderThree(view);
        } else {
            View view = LayoutInflater.from(mMyListTopicActivity).inflate(R.layout.item_y_topic_tow, null);
            return new ViewHolderTow(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        final MyListTopicBean.FavouritTopicListBean topicListBean = mListBeans.get(position);
        List<String> thumb = topicListBean.getImageListThumb();
        if (viewType == 1) {
            ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
            viewHolderOne.mTimeTv.setText(topicListBean.getPublishTime());
            viewHolderOne.mSdvImageListThumbTopicBig.setImageURI(thumb.get(0));
            viewHolderOne.mTvCommentsTopic.setText(topicListBean.getComments() + "");
            viewHolderOne.mTvLikesTopic.setText(topicListBean.getLikes() + "");
            viewHolderOne.mTvPageviewsTopic.setText(topicListBean.getPageviews() + "");
            viewHolderOne.mTitle.setText(topicListBean.getTitle());
            viewHolderOne.mTvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickTheSettingsPopover.onClick(topicListBean);
                }
            });
        } else if (viewType == 3) {
            ViewHolderThree viewHolderThree = (ViewHolderThree) holder;
            viewHolderThree.mTimeTv.setText(topicListBean.getPublishTime());
            viewHolderThree.mSdvImageListThumbTopicSim1.setImageURI(thumb.get(0));
            viewHolderThree.mSdvImageListThumbTopicSim2.setImageURI(thumb.get(1));
            if (thumb.size() == 3) {
                viewHolderThree.mSdvImageListThumbTopicSim2.setImageURI(thumb.get(2));
            }
            viewHolderThree.mTvCommentsTopic.setText(topicListBean.getComments()+"");
            viewHolderThree.mTvLikesTopic.setText(topicListBean.getLikes() + "");
            viewHolderThree.mTvPageviewsTopic.setText(topicListBean.getPageviews()+"");
            viewHolderThree.mTitle.setText(topicListBean.getTitle());
            viewHolderThree.mTvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickTheSettingsPopover.onClick(topicListBean);
                }
            });
        } else {
            ViewHolderTow viewHolderTow = (ViewHolderTow) holder;
            viewHolderTow.mTimeTv.setText(topicListBean.getPublishTime());
            viewHolderTow.mTvTopicUrl.setText(topicListBean.getShareLink());
            viewHolderTow.mTvLikesTopic.setText(topicListBean.getShareLink());
            viewHolderTow.mTvCommentsTopic.setText(topicListBean.getComments()+"");
            viewHolderTow.mTvLikesTopic.setText(topicListBean.getLikes() + "");
            viewHolderTow.mTvPageviewsTopic.setText(topicListBean.getPageviews()+"");
            viewHolderTow.mTitle.setText(topicListBean.getTitle());
            viewHolderTow.mTvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickTheSettingsPopover.onClick(topicListBean);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mListBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        List<String> thumb = mListBeans.get(position).getImageListThumb();
        if (thumb != null && thumb.size() != 0) {
            if (thumb.size() == 1) {
                return 1;
            } else {
                return 3;
            }

        } else {

            return 2;
        }

    }

    static class ViewHolderOne extends RecyclerView.ViewHolder {
        @NonNull
        @BindView(R.id.tv_btn)
        TextView mTvBtn;
        @NonNull
        @BindView(R.id.title)
        TextView mTitle;
        @NonNull
        @BindView(R.id.time_tv)
        TextView mTimeTv;
        @NonNull
        @BindView(R.id.sdv_imageListThumb_topic_big)
        SimpleDraweeView mSdvImageListThumbTopicBig;
        @NonNull
        @BindView(R.id.tv_pageviews_topic)
        TextView mTvPageviewsTopic;
        @NonNull
        @BindView(R.id.read_ll)
        LinearLayout mReadLl;
        @NonNull
        @BindView(R.id.tv_comments_topic)
        TextView mTvCommentsTopic;
        @NonNull
        @BindView(R.id.comments_ll)
        LinearLayout mCommentsLl;
        @NonNull
        @BindView(R.id.tv_likes_topic)
        TextView mTvLikesTopic;
        @NonNull
        @BindView(R.id.like_ll)
        protected LinearLayout mLikeLl;

        ViewHolderOne(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderThree extends RecyclerView.ViewHolder {
        @NonNull
        @BindView(R.id.tv_btn)
        TextView mTvBtn;
        @NonNull
        @BindView(R.id.title)
        TextView mTitle;
        @NonNull
        @BindView(R.id.time_tv)
        TextView mTimeTv;
        @NonNull
        @BindView(R.id.sdv_imageListThumb_topic_sim_1)
        SimpleDraweeView mSdvImageListThumbTopicSim1;
        @NonNull
        @BindView(R.id.sdv_imageListThumb_topic_sim_2)
        SimpleDraweeView mSdvImageListThumbTopicSim2;
        @NonNull
        @BindView(R.id.sdv_imageListThumb_topic_sim_3)
        SimpleDraweeView mSdvImageListThumbTopicSim3;
        @NonNull
        @BindView(R.id.tv_pageviews_topic)
        TextView mTvPageviewsTopic;
        @NonNull
        @BindView(R.id.read_ll)
        LinearLayout mReadLl;
        @NonNull
        @BindView(R.id.tv_comments_topic)
        TextView mTvCommentsTopic;
        @NonNull
        @BindView(R.id.comments_ll)
        LinearLayout mCommentsLl;
        @NonNull
        @BindView(R.id.tv_likes_topic)
        TextView mTvLikesTopic;
        @NonNull
        @BindView(R.id.like_ll)
        LinearLayout mLikeLl;

        ViewHolderThree(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static class ViewHolderTow extends RecyclerView.ViewHolder{
        @NonNull
        @BindView(R.id.tv_btn)
        TextView mTvBtn;
        @NonNull
        @BindView(R.id.title)
        TextView mTitle;
        @NonNull
        @BindView(R.id.time_tv)
        TextView mTimeTv;
        @NonNull
        @BindView(R.id.tv_topic_url)
        TextView mTvTopicUrl;
        @NonNull
        @BindView(R.id.ll_topic_wenzhang)
        LinearLayout mLlTopicWenzhang;
        @NonNull
        @BindView(R.id.tv_pageviews_topic)
        TextView mTvPageviewsTopic;
        @NonNull
        @BindView(R.id.read_ll)
        LinearLayout mReadLl;
        @NonNull
        @BindView(R.id.tv_comments_topic)
        TextView mTvCommentsTopic;
        @NonNull
        @BindView(R.id.comments_ll)
        LinearLayout mCommentsLl;
        @NonNull
        @BindView(R.id.tv_likes_topic)
        TextView mTvLikesTopic;
        @NonNull
        @BindView(R.id.like_ll)
        LinearLayout mLikeLl;

        ViewHolderTow(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    ClickTheSettingsPopover mClickTheSettingsPopover;

    public void setClickTheSettingsPopover(ClickTheSettingsPopover clickTheSettingsPopover) {
        mClickTheSettingsPopover = clickTheSettingsPopover;
    }

   public interface   ClickTheSettingsPopover{
          void onClick(MyListTopicBean.FavouritTopicListBean favouritTopicListBean);
   }
}
