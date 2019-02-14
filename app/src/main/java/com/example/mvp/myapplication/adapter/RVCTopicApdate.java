package com.example.mvp.myapplication.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;
import com.example.mvp.myapplication.ui.my.activity.UserHomePageActivity;
import com.example.mvp.myapplication.ui.topic.activity.TopicDataActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

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

    private final ArrayList<TopicListBean> mTopicListBeans;
    private final FragmentActivity mActivity;

    public RVCTopicApdate(ArrayList<TopicListBean> topicListBeans, FragmentActivity activity) {
        mTopicListBeans = topicListBeans;
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
           TopicListBean topicListBean = mTopicListBeans.get(position);
            Log.d("tag",mTopicListBeans.get(position).getHeadImagePath());
            viewHolder.mSdvHeadImagePathTopic.setImageURI(Uri.parse(topicListBean.getHeadImagePath()));
            viewHolder.mTitle.setText(topicListBean.getTitle());
            viewHolder.mTvNicknameTopic.setTextColor(mActivity.getResources().getColor(R.color.blue));
            viewHolder.mTvNicknameTopic.setText(topicListBean.getNickname());
            viewHolder.mTvPublishTime.setText(topicListBean.getPublishTime());
            viewHolder.mTvCommentsTopic.setText(topicListBean.getComments()+"");
            viewHolder.mTvLiskesTopic.setText(topicListBean.getLikes()+"");
            viewHolder.mTvPageViewsTopic.setText(topicListBean.getPageviews()+"");
            viewHolder.bigImageListThumb.setImageURI(Uri.parse(mTopicListBeans.get(position).getImageListThumb().get(0)));
            viewHolder.mIconUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      popWindow();
                }
            });
           viewHolder.llread.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(mActivity,TopicDataActivity.class);
                   intent.putExtra("id",mTopicListBeans.get(position).getTopicId());

                   mActivity.startActivity(intent);
               }
           });
           viewHolder.llComent.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(mActivity,TopicDataActivity.class);
                   intent.putExtra("id",mTopicListBeans.get(position).getTopicId());
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
                     viewHolder.mTvLiskesTopic.setText(mTopicListBeans.get(position).getLikes()+1+"");
                    mOnItemLikes.onlike(mTopicListBeans.get(position).getTopicId());
                   }else {
                       Toast.makeText(mActivity,"以点赞改话题",Toast.LENGTH_SHORT).show();
                   }
               }
           });
            viewHolder.mSdvHeadImagePathTopic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,UserHomePageActivity.class);
                    intent.putExtra("id",mTopicListBeans.get(position).getUserId());
                    mActivity.startActivity(intent);

                }
            });
        }else if (viewType==2){
             final ViewHolder2 viewHolder2= (ViewHolder2) holder;
            TopicListBean topicListBean = mTopicListBeans.get(position);
            viewHolder2.mSdvHeadImagePathTopic.setImageURI(Uri.parse(topicListBean.getHeadImagePath()));
            viewHolder2.mTitle.setText(topicListBean.getTitle());
            viewHolder2.mTvNicknameTopic.setTextColor(mActivity.getResources().getColor(R.color.blue));
            viewHolder2.mTvNicknameTopic.setText(topicListBean.getNickname());
            viewHolder2.mTvPublishTime.setText(topicListBean.getPublishTime());
            viewHolder2.mTvCommentsTopic.setText(topicListBean.getComments()+"");
            viewHolder2.mTvLiskesTopic.setText(topicListBean.getLikes()+"");
            viewHolder2.mTvPageViewsTopic.setText(topicListBean.getPageviews()+"");
            viewHolder2.mSdvImageListThumbTopicSim1.setImageURI(Uri.parse(mTopicListBeans.get(position).getImageListThumb().get(0)));
            viewHolder2.mSdvImageListThumbTopicSim2.setImageURI(Uri.parse(mTopicListBeans.get(position).getImageListThumb().get(1)));
            if (mTopicListBeans.get(position).getImageListThumb().size()>2){
                viewHolder2.mSdvImageListThumbTopicSim3.setImageURI(Uri.parse(mTopicListBeans.get(position).getImageListThumb().get(2)));

            }
            viewHolder2.llread.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",mTopicListBeans.get(position).getTopicId());

                    mActivity.startActivity(intent);
                }
            });
            viewHolder2.llComent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",mTopicListBeans.get(position).getTopicId());
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
                        viewHolder2.mTvLiskesTopic.setText(mTopicListBeans.get(position).getLikes()+1+"");
                        mOnItemLikes.onlike(mTopicListBeans.get(position).getTopicId());
                    }else {
                        Toast.makeText(mActivity,"以点赞改话题",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            viewHolder2.mSdvHeadImagePathTopic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,UserHomePageActivity.class);
                    intent.putExtra("id",mTopicListBeans.get(position).getUserId());
                    mActivity.startActivity(intent);

                }
            });
        }else  {
            final ViewHolder3 viewHolder3= (ViewHolder3) holder;
         TopicListBean topicListBean = mTopicListBeans.get(position);
            viewHolder3.mSdvHeadImagePathTopic.setImageURI(Uri.parse(topicListBean.getHeadImagePath()));
            viewHolder3.mTitle.setText(topicListBean.getTitle());
            viewHolder3.mTvNicknameTopic.setTextColor(mActivity.getResources().getColor(R.color.blue));
            viewHolder3.mTvNicknameTopic.setText(topicListBean.getNickname());
            viewHolder3.mTvPublishTime.setText(topicListBean.getPublishTime());
            viewHolder3.mTvCommentsTopic.setText(topicListBean.getComments()+"");
            viewHolder3.mTvLiskesTopic.setText(topicListBean.getLikes()+"");
            viewHolder3.mTvPageViewsTopic.setText(topicListBean.getPageviews()+"");
            viewHolder3.mTvTopicUrl.setText(mTopicListBeans.get(position).getShareLink());
            viewHolder3.llread.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",mTopicListBeans.get(position).getTopicId());
                    mActivity.startActivity(intent);
                }
            });
            viewHolder3.llComent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,TopicDataActivity.class);
                    intent.putExtra("id",mTopicListBeans.get(position).getTopicId());
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
                        viewHolder3.mTvLiskesTopic.setText(mTopicListBeans.get(position).getLikes()+1+"");
                        mOnItemLikes.onlike(mTopicListBeans.get(position).getTopicId());
                    }else {
                        Toast.makeText(mActivity,"以点赞改话题",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            viewHolder3.mSdvHeadImagePathTopic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity,UserHomePageActivity.class);
                    intent.putExtra("id",mTopicListBeans.get(position).getUserId());
                    mActivity.startActivity(intent);

                }
            });

        }
        }

    public void setOnItemLikes(RVTopicApdate.OnItemLikes onItemLikes) {
        mOnItemLikes = onItemLikes;
    }

    public RVTopicApdate.OnItemLikes mOnItemLikes;
    public    interface  OnItemLikes{
        void  onlike(String objectId);
    }
    private void popWindow() {
        LayoutInflater.from(mActivity).inflate(R.layout.pop_topic_repor,null);
        PopupWindow window = new PopupWindow(mActivity);
        window.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        window.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);

    }


    @Override
    public int getItemCount() {
        return mTopicListBeans.size();
    }

     class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView mIconUp;
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
         LinearLayout   llLike;
         LinearLayout   llComent;
         LinearLayout   llread;

        ViewHolder2(View view) {
            super(view);
            llread=view.findViewById(R.id.read_ll_2);
            llComent=view.findViewById(R.id.comments_ll_2);
            llLike=view.findViewById(R.id.like_ll_2);
            mIconUp=view.findViewById(R.id.img_icon_up);
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
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIconUp;
        TextView mTitle;
        TextView  mTvCommentsTopic;
        TextView mTvLiskesTopic;
        TextView  mTvPageViewsTopic;
        TextView  mTvPublishTime;
        SimpleDraweeView mSdvHeadImagePathTopic;
        @BindView(R.id.tv_nickname_topic)
        TextView mTvNicknameTopic;
        SimpleDraweeView bigImageListThumb;
        LinearLayout   llLike;
        LinearLayout   llComent;
        LinearLayout   llread;
        ViewHolder(View view) {
            super(view);
            llread=view.findViewById(R.id.read_ll);
            llComent=view.findViewById(R.id.comments_ll);
            llLike=view.findViewById(R.id.likes_ll);
            mIconUp=view.findViewById(R.id.img_icon_up_2);
            mTitle=view.findViewById(R.id.tv_title);
            mTvCommentsTopic=view.findViewById(R.id.tv_comments_topic);
            mTvLiskesTopic=view.findViewById(R.id.tv_likes_topic);
            mTvPageViewsTopic=view.findViewById(R.id.tv_pageviews_topic);
            mTvPublishTime=view.findViewById(R.id.tv_publishTime_topic);
            mSdvHeadImagePathTopic=view.findViewById(R.id.sdv_headImagePath_topic);
            mTvNicknameTopic=view.findViewById(R.id.tv_nickname_topic);
            bigImageListThumb=view.findViewById(R.id.sdv_imageListThumb_topic_big);

        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder {
        ImageView mIconUp;
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
        ViewHolder3(View view) {
            super(view);
            llread=view.findViewById(R.id.read_ll_3);
            llComent=view.findViewById(R.id.comments_ll_3);
            llLike=view.findViewById(R.id.likes_ll_3);
            mIconUp=view.findViewById(R.id.img_icon_up_3);
            ButterKnife.bind(this, view);
            mTitle=view.findViewById(R.id.tv_title_3);
            mTvCommentsTopic=view.findViewById(R.id.tv_comments_topic_3);
            mTvLiskesTopic=view.findViewById(R.id.tv_likes_topic_3);
            mTvPageViewsTopic=view.findViewById(R.id.tv_pageviews_topic_3);
            mTvPublishTime=view.findViewById(R.id.tv_publishTime_topic_3);
            mSdvHeadImagePathTopic=view.findViewById(R.id.sdv_headImagePath_topic_3);
            mTvNicknameTopic=view.findViewById(R.id.tv_nickname_topic_3);
            mTvTopicUrl=view.findViewById(R.id.tv_topic_url);






        }
    }
        @Override
        public int getItemViewType(int position) {
            List<String> thumb = mTopicListBeans.get(position).getImageListThumb();
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
}

