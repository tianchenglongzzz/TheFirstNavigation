package com.example.mvp.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.FavouriteTopicBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Optional;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:ApdaterFavouritTopic
 * @date :${DATA} 14:57
 */
public class ApdaterFavouritTopic extends RecyclerView.Adapter {

    private final ArrayList<FavouriteTopicBean.FavouritTopicListBean> mFavouritTopicListBeans;
    private final FragmentActivity mActivity;

    public ApdaterFavouritTopic(ArrayList<FavouriteTopicBean.FavouritTopicListBean> favouritTopicListBeans, FragmentActivity activity) {
        mFavouritTopicListBeans = favouritTopicListBeans;
        mActivity = activity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           if (viewType==1){
               View view = LayoutInflater.from(mActivity).inflate(R.layout.item_favourtopica, null);
               return new  ViewHoderA(view);
           }else if (viewType==2){
               View view = LayoutInflater.from(mActivity).inflate(R.layout.item_favourtopicb, null);
               return new  ViewHoderB(view);
           }else {

               View view = LayoutInflater.from(mActivity).inflate(R.layout.item_favourtopicc, null);
               return new  ViewHoderC(view);
           }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType==1){
             ViewHoderA viewHoderA= (ViewHoderA) holder;
            FavouriteTopicBean.FavouritTopicListBean topicListBean = mFavouritTopicListBeans.get(position);
            viewHoderA.headsdv.setImageURI(topicListBean.getHeadImagePath());
            viewHoderA.time.setText(topicListBean.getPublishTime());
             viewHoderA.title.setText(topicListBean.getTitle());
             viewHoderA.simbig.setImageURI(topicListBean.getImageListThumb().get(0));
             viewHoderA.commet.setText(topicListBean.getComment());
        }else if (viewType==2){
            ViewHoderB viewHoderB= (ViewHoderB) holder;
            FavouriteTopicBean.FavouritTopicListBean topicListBean = mFavouritTopicListBeans.get(position);
            viewHoderB.headsdv.setImageURI(topicListBean.getHeadImagePath());
            viewHoderB.title.setText(topicListBean.getTitle());
            viewHoderB.commet.setText(topicListBean.getComment());
            viewHoderB.time.setText(topicListBean.getPublishTime());
            List<String> thumb = topicListBean.getImageListThumb();
            int size = thumb.size();
            viewHoderB.simA.setImageURI(thumb.get(0));
            viewHoderB.simB.setImageURI(thumb.get(1));
            if (size==3){
                viewHoderB.simC.setImageURI(thumb.get(2));
            }


        }else {
            ViewHoderC viewHoderC= (ViewHoderC) holder;
            FavouriteTopicBean.FavouritTopicListBean topicListBean = mFavouritTopicListBeans.get(position);
            viewHoderC.headsdv.setImageURI(topicListBean.getHeadImagePath());
            viewHoderC.title.setText(topicListBean.getTitle());
            viewHoderC.commet.setText(topicListBean.getComment());
            viewHoderC.time.setText(topicListBean.getPublishTime());
            viewHoderC.url.setText(topicListBean.getShareLink());

        }

    }

    @Override
    public int getItemCount() {
        return mFavouritTopicListBeans.size();
    }
    @Override
    public int getItemViewType(int position) {
        List<String> thumb = mFavouritTopicListBeans.get(position).getImageListThumb();
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
    class ViewHoderA extends RecyclerView.ViewHolder{
       TextView nickename;
       TextView time;
       SimpleDraweeView  headsdv;
       TextView title;
       TextView commet;
       @NonNull
       SimpleDraweeView  simbig;
        public ViewHoderA(View itemView) {
            super(itemView);
            nickename=itemView.findViewById(R.id.nickname_tv);
            time=itemView.findViewById(R.id.publishTime_tv);
            headsdv=itemView.findViewById(R.id.sdv_headImagePath);
            title=itemView.findViewById(R.id.title_tv);
            simbig=itemView.findViewById(R.id.sdv_imageListThumb_topic_big);
            commet=itemView.findViewById(R.id.topic_commentTv);
        }
    }
    class ViewHoderB extends RecyclerView.ViewHolder{
        TextView nickename;
        TextView time;
        SimpleDraweeView  headsdv;
        TextView commet;
        TextView title;
        SimpleDraweeView  simA;
        SimpleDraweeView  simB;
        SimpleDraweeView  simC;
        public ViewHoderB(View itemView) {
            super(itemView);
            nickename=itemView.findViewById(R.id.nickname_tv);
            time=itemView.findViewById(R.id.publishTime_tv);
            headsdv=itemView.findViewById(R.id.sdv_headImagePath);
            title=itemView.findViewById(R.id.title_tv);
            simA=itemView.findViewById(R.id.favour_topic_item_sdv_1);
            simB=itemView.findViewById(R.id.favour_topic_item_sdv_2);
            simC=itemView.findViewById(R.id.favour_topic_item_sdv_4);
            commet=itemView.findViewById(R.id.topic_commentTv);

        }
    } class ViewHoderC extends RecyclerView.ViewHolder{
        TextView nickename;
        TextView time;
        TextView title;
        SimpleDraweeView  headsdv;
        TextView commet;
        @NonNull
        TextView  url;
        public ViewHoderC(View itemView) {
            super(itemView);
            nickename=itemView.findViewById(R.id.nickname_tv);
            time=itemView.findViewById(R.id.publishTime_tv);
            headsdv=itemView.findViewById(R.id.sdv_headImagePath);
            title=itemView.findViewById(R.id.title_tv);
            url=itemView.findViewById(R.id.tv_topic_url);
            commet=itemView.findViewById(R.id.topic_commentTv);


        }
    }

}
