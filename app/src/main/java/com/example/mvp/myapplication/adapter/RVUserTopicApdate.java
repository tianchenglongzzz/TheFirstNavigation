package com.example.mvp.myapplication.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.HomePagelistBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;
import com.example.mvp.myapplication.ui.topic.activity.TopicDataActivity;
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
public class RVUserTopicApdate extends XRecyclerView.Adapter {

    private final List<HomePagelistBean> data;
    private final FragmentActivity mActivity;

    public RVUserTopicApdate(List<HomePagelistBean> data, FragmentActivity activity) {
          this.data=data;
        mActivity = activity;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_topic, null);
            return new ViewHolder(view);
        }else if (viewType==2){
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_topic_three, null);
            return new ViewHolder2(view);
        }else  {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_topic_tow, null);
            return new ViewHolder3(view);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        if (viewType==1) {
            final ViewHolder viewHolder= (ViewHolder) holder;
            viewHolder.mTitle.setText(data.get(position).getTitle());
            viewHolder.mTvNicknameTopic.setTextColor(mActivity.getResources().getColor(R.color.blue));
            viewHolder.mTvCommentsTopic.setText(data.get(position).getComments()+"");
            viewHolder.mTvLiskesTopic.setText(data.get(position).getLikes()+"");
            viewHolder.mTvPageViewsTopic.setText(data.get(position).getPageviews()+"");
            viewHolder.bigImageListThumb.setImageURI(Uri.parse(data.get(position).getImageListThumb().get(0)));
            viewHolder.llread.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",data.get(position).getTopicId());
                    mActivity.startActivity(intent);
                }
            });
            viewHolder.llComent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",data.get(position).getTopicId());
                    intent.putExtra("ie",1);
                    mActivity.startActivity(intent);
                }
            });
            viewHolder.llLike.setOnClickListener(new View.OnClickListener() {
                int i=0;
                @Override
                public void onClick(View v) {
                    if (i==0){

                        i++;
                        viewHolder.mTvLiskesTopic.setText(data.get(position).getLikes()+1+"");
                        mOnItemLikes.onlike(data.get(position).getTopicId());
                    }else {
                        Toast.makeText(mActivity,"以点赞该话题",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemUp.onItemUpClick();
                }
            });
        }else if (viewType==2){
             final ViewHolder2 viewHolder2= (ViewHolder2) holder;
            viewHolder2.mTitle.setText(data.get(position).getTitle());
            viewHolder2.mTvNicknameTopic.setTextColor(mActivity.getResources().getColor(R.color.blue));
            viewHolder2.mTvCommentsTopic.setText(data.get(position).getComments()+"");
            viewHolder2.mTvLiskesTopic.setText(data.get(position).getLikes()+"");
            viewHolder2.mTvPageViewsTopic.setText(data.get(position).getPageviews()+"");
            viewHolder2.mSdvImageListThumbTopicSim1.setImageURI(Uri.parse(data.get(position).getImageListThumb().get(0)));
            viewHolder2.mSdvImageListThumbTopicSim2.setImageURI(Uri.parse(data.get(position).getImageListThumb().get(1)));
            if (data.get(position).getImageListThumb().size()>2){
                viewHolder2.mSdvImageListThumbTopicSim2.setImageURI(Uri.parse(data.get(position).getImageListThumb().get(2)));

            }
            viewHolder2.llread.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",data.get(position).getTopicId());

                    mActivity.startActivity(intent);
                }
            });
            viewHolder2.llComent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",data.get(position).getTopicId());
                    intent.putExtra("ie",1);
                    mActivity.startActivity(intent);
                }
            });
            viewHolder2.llLike.setOnClickListener(new View.OnClickListener() {
                int i=0;
                @Override
                public void onClick(View v) {
                    if (i==0){

                        i++;
                        viewHolder2.mTvLiskesTopic.setText(data.get(position).getLikes()+1+"");
                        mOnItemLikes.onlike(data.get(position).getTopicId());
                    }else {
                        Toast.makeText(mActivity,"以点赞该话题",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            viewHolder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemUp.onItemUpClick();
                }
            });
        }else  {
            final ViewHolder3 viewHolder3= (ViewHolder3) holder;

            viewHolder3.mRelativeLayout.setVisibility(View.GONE);
            viewHolder3.mTitle.setText(data.get(position).getTitle());
            viewHolder3.mTvNicknameTopic.setTextColor(mActivity.getResources().getColor(R.color.blue));
            viewHolder3.mTvCommentsTopic.setText(data.get(position).getComments()+"");
            viewHolder3.mTvLiskesTopic.setText(data.get(position).getLikes()+"");
            viewHolder3.mTvPageViewsTopic.setText(data.get(position).getPageviews()+"");
            viewHolder3.mTvTopicUrl.setText(data.get(position).getShareLink());
            viewHolder3.llread.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",data.get(position).getTopicId());
                    mActivity.startActivity(intent);
                }
            });
            viewHolder3.llComent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",data.get(position).getTopicId());
                    intent.putExtra("ie",1);
                    mActivity.startActivity(intent);
                }
            });
            viewHolder3.llLike.setOnClickListener(new View.OnClickListener() {
                int i=0;
                @Override
                public void onClick(View v) {
                    if (i==0){

                        i++;
                        viewHolder3.mTvLiskesTopic.setText(data.get(position).getLikes()+1+"");
                        mOnItemLikes.onlike(data.get(position).getTopicId());
                    }else {
                        Toast.makeText(mActivity,"以点赞该话题",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            viewHolder3.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemUp.onItemUpClick();
                }
            });
        }

        }



    @Override
    public int getItemCount() {
        return data.size();
    }

     class ViewHolder2 extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView  mTvCommentsTopic;
        TextView mTvLiskesTopic;
        TextView  mTvPageViewsTopic;
        TextView  mTvPublishTime;
        TextView mTvNicknameTopic;
        SimpleDraweeView mSdvImageListThumbTopicSim1;
        SimpleDraweeView mSdvImageListThumbTopicSim2;
        SimpleDraweeView mSdvImageListThumbTopicSim3;
         SimpleDraweeView mSdvHeadImagePathTopic;
         LinearLayout llLike;
         LinearLayout   llComent;
         LinearLayout   llread;
         RelativeLayout mRelativeLayout;
         ImageView mIup;
        ViewHolder2(View view) {
            super(view);
            mRelativeLayout=view.findViewById(R.id.user_rl_2);
            llread=view.findViewById(R.id.read_ll_2);
            llComent=view.findViewById(R.id.comments_ll_2);
            llLike=view.findViewById(R.id.like_ll_2);
            mTitle=view.findViewById(R.id.tv_title_2);
            mTvCommentsTopic=view.findViewById(R.id.tv_comments_topic_2);
            mTvLiskesTopic=view.findViewById(R.id.tv_likes_topic_2);
            mTvPageViewsTopic=view.findViewById(R.id.tv_pageviews_topic_2);
            mTvPublishTime=view.findViewById(R.id.tv_publishTime_topic_2);
            mTvNicknameTopic=view.findViewById(R.id.tv_nickname_topic_2);
            mSdvImageListThumbTopicSim1=view.findViewById(R.id.sdv_imageListThumb_topic_sim_1);
            mSdvImageListThumbTopicSim2=view.findViewById(R.id.sdv_imageListThumb_topic_sim_2);
            mSdvImageListThumbTopicSim3=view.findViewById(R.id.sdv_imageListThumb_topic_sim_3);
            mSdvHeadImagePathTopic=view.findViewById(R.id.sdv_headImagePath_topic_2);
            mIup=view.findViewById(R.id.img_icon_up);
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout   llLike;
        LinearLayout   llComent;
        LinearLayout   llread;
        TextView mTitle;
        TextView  mTvCommentsTopic;
        TextView mTvLiskesTopic;
        TextView  mTvPageViewsTopic;
        TextView  mTvPublishTime;
        SimpleDraweeView mSdvHeadImagePathTopic;
        @BindView(R.id.tv_nickname_topic)
        TextView mTvNicknameTopic;
        SimpleDraweeView bigImageListThumb;
        RelativeLayout mRelativeLayout;
        ImageView mIup;
        ViewHolder(View view) {
            super(view);
            mRelativeLayout=view.findViewById(R.id.user_rl);
            llread=view.findViewById(R.id.read_ll);
            llComent=view.findViewById(R.id.comments_ll);
            llLike=view.findViewById(R.id.likes_ll);
            mTitle=view.findViewById(R.id.tv_title);
            mTvCommentsTopic=view.findViewById(R.id.tv_comments_topic);
            mTvLiskesTopic=view.findViewById(R.id.tv_likes_topic);
            mTvPageViewsTopic=view.findViewById(R.id.tv_pageviews_topic);
            mTvPublishTime=view.findViewById(R.id.tv_publishTime_topic);
            mSdvHeadImagePathTopic=view.findViewById(R.id.sdv_headImagePath_topic);
            mTvNicknameTopic=view.findViewById(R.id.tv_nickname_topic);
            bigImageListThumb=view.findViewById(R.id.sdv_imageListThumb_topic_big);
            mIup=view.findViewById(R.id.img_icon_up);

        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView  mTvCommentsTopic;
      TextView mTvLiskesTopic;
        TextView  mTvPageViewsTopic;
        TextView  mTvPublishTime;
        SimpleDraweeView mSdvHeadImagePathTopic;
        TextView mTvNicknameTopic;
        TextView mTvTopicUrl;
        LinearLayout   llLike;
        LinearLayout   llComent;
        LinearLayout   llread;
        ImageView mIup;
        RelativeLayout mRelativeLayout;
        ViewHolder3(View view) {
            super(view);
            mRelativeLayout=view.findViewById(R.id.user_rl_3);
            ButterKnife.bind(this, view);
            llread=view.findViewById(R.id.read_ll_3);
            llComent=view.findViewById(R.id.comments_ll_3);
            llLike=view.findViewById(R.id.likes_ll_3);
            mTitle=view.findViewById(R.id.tv_title_3);
            mTvCommentsTopic=view.findViewById(R.id.tv_comments_topic_3);
            mTvLiskesTopic=view.findViewById(R.id.tv_likes_topic_3);
            mTvPageViewsTopic=view.findViewById(R.id.tv_pageviews_topic_3);
            mTvPublishTime=view.findViewById(R.id.tv_publishTime_topic_3);
            mSdvHeadImagePathTopic=view.findViewById(R.id.sdv_headImagePath_topic_3);
            mTvNicknameTopic=view.findViewById(R.id.tv_nickname_topic_3);
            mTvTopicUrl=view.findViewById(R.id.tv_topic_url);
            mIup=view.findViewById(R.id.img_icon_up);






        }
    }
        @Override
        public int getItemViewType(int position) {
            List<String> thumb = data.get(position).getImageListThumb();
            if (thumb!=null&&thumb.size()!=0){
                if (thumb.size()==1){
                    return 1;
                }else {
                    return 2;
                }

            }else {
                return  3;
            }

        }

    public void setOnItemLikes(OnItemLikes onItemLikes) {
        mOnItemLikes = onItemLikes;
    }

    public OnItemLikes mOnItemLikes;
     public    interface  OnItemLikes{
                 void  onlike(String objectId);
        }
    RVTopicApdate.OnItemUp mOnItemUp;

    public void setOnItemUp(RVTopicApdate.OnItemUp onItemUp) {
        mOnItemUp = onItemUp;
    }

    public  interface  OnItemUp{
        void onItemUpClick();
    }

}

