package com.example.mvp.myapplication.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.ui.news.activity.ShowDataActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:NewlisrApdate
 * @date :${DATA} 21:20
 */
public class SerchNewlistApdate extends XRecyclerView.Adapter {
    private static final int ONE = 0;
    private static final int THREE = 3;
    private static final int TOW = 1;
    private static final int FOUR = 4;
    private static final String TAG = "NewlistApdate";

    private  ArrayList<UpListNewsBean.NewListBean> newlistBeanfash;
    private final Activity activity;

    public SerchNewlistApdate(ArrayList<UpListNewsBean.NewListBean> newListBeans, Activity activity) {

        this.newlistBeanfash = newListBeans;

        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_nelayoutwsone_serch, null);
            return new ViewHolderOne(view);
        } else if (viewType == TOW) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_nelayoutwstow_serch, null);
            return  new ViewHolderTow(view);
        } else if (viewType == THREE) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_nelayoutwsthree__serch, null);
            return  new ViewHolderThree(view);
        } else  {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_nelayoutwsfour__serch, null);
            return new ViewHolderFour(view);

        }

    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
                   holder.itemView.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent = new Intent(activity,ShowDataActivity.class);
                           intent.putExtra("newsId",newlistBeanfash.get(position).getNewsId());
                           activity.startActivity(intent);
                           }
                   });
                if (itemViewType==ONE){
                    ViewHolderOne viewHolderOne= (ViewHolderOne) holder;
                    viewHolderOne.mOriginTv.setText(newlistBeanfash.get(position).getPublishTime());
                    viewHolderOne.mIitleTv.setText(newlistBeanfash.get(position).getTitle());

                }else if (itemViewType==TOW){
                        ViewHolderTow viewHolderTow= (ViewHolderTow) holder;
                        viewHolderTow.mIitleTv.setText(newlistBeanfash.get(position).getTitle());
                        viewHolderTow.mOriginTv.setText(newlistBeanfash.get(position).getPublishTime());
                    Glide.with(activity).load(newlistBeanfash.get(position).getImageListThumb().get(0)).into(viewHolderTow.mImageListThumbImg);

                }else if (itemViewType==THREE){
                    ViewHolderThree viewHolderThree= (ViewHolderThree) holder;
                    viewHolderThree.mIitleTv.setText(newlistBeanfash.get(position).getTitle());
                    viewHolderThree.mOriginTv.setText(newlistBeanfash.get(position).getPublishTime());
                    Uri parse = Uri.parse(newlistBeanfash.get(position).getImageListThumb().get(0));
                    viewHolderThree.mImageListThumbImg.setImageURI(parse);
                    if (newlistBeanfash.get(position).getImageListThumb().size()>1) {
                        Uri parse1 = Uri.parse(newlistBeanfash.get(position).getImageListThumb().get(0));
                        viewHolderThree.mImageListThumbImg.setImageURI(parse1);
                        Uri parse2 = Uri.parse(newlistBeanfash.get(position).getImageListThumb().get(1));
                        viewHolderThree.mImageListThumbImgTow.setImageURI(parse);
                        Uri uri = Uri.parse(newlistBeanfash.get(position).getImageListThumb().get(2));
                        viewHolderThree.mImageListThumbImgThree.setImageURI(uri);
                    }
                }else if (itemViewType==FOUR){
                    ViewHolderFour viewHolderFour= (ViewHolderFour) holder;

                    viewHolderFour.mIitleTv.setText(newlistBeanfash.get(position).getTitle());
                    viewHolderFour.mOriginTv.setText(newlistBeanfash.get(position).getPublishTime());
                    Uri uri = Uri.parse(newlistBeanfash.get(position).getImageListThumb().get(0));
                    viewHolderFour.mImageListThumbImg.setImageURI(uri);
                }

    }

    @Override
    public int getItemCount() {
        return newlistBeanfash.size();
    }

    public void remove() {
          newlistBeanfash.clear();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {
        TextView mIitleTv;
         TextView  mOriginTv;




        public ViewHolderOne(View itemView) {
            super(itemView);

            mIitleTv = itemView.findViewById(R.id.tv_one_tiile);

            mOriginTv = itemView.findViewById(R.id.tv_news_origin);

        }
    }

    class ViewHolderTow extends RecyclerView.ViewHolder {

        TextView mIitleTv;
        TextView  mOriginTv;
        ImageView mImageListThumbImg;

        public ViewHolderTow(View itemView) {
            super(itemView);
            mIitleTv= itemView.findViewById(R.id.tv_one_tiile_tow);
            mOriginTv=itemView.findViewById(R.id.tv_news_origin_tow);
            mImageListThumbImg=itemView.findViewById(R.id.sim_news_imageListThumb_tow);

        }
    }

    class ViewHolderThree extends RecyclerView.ViewHolder {

        TextView mIitleTv;
        TextView  mOriginTv;
        SimpleDraweeView mImageListThumbImg;
        SimpleDraweeView mImageListThumbImgTow;
        SimpleDraweeView mImageListThumbImgThree;

        public ViewHolderThree(View itemView) {
            super(itemView);
            mIitleTv= itemView.findViewById(R.id.tv_one_tiile_three);
            mOriginTv=itemView.findViewById(R.id.tv_news_origin_three);
            mImageListThumbImg=itemView.findViewById(R.id.sim_news_imageListThumb_three_three);
            mImageListThumbImgTow=itemView.findViewById(R.id.sim_news_imageListThumb_tow_tow);
            mImageListThumbImgThree=itemView.findViewById(R.id.sim_news_imageListThumb_three);

        }
    }

    class ViewHolderFour extends RecyclerView.ViewHolder {

        TextView mIitleTv;
        TextView  mOriginTv;
        SimpleDraweeView mImageListThumbImg;
        public ViewHolderFour(View itemView) {
            super(itemView);
            mIitleTv= itemView.findViewById(R.id.tv_one_tiile_four);
            mOriginTv=itemView.findViewById(R.id.tv_news_origin_four);
            mImageListThumbImg=itemView.findViewById(R.id.sim_news_imageListThumb_four);




        }
    }

    @Override
    public int getItemViewType(int position) {
        Integer integer;

           integer = Integer.parseInt(newlistBeanfash.get(position).getLayoutType());

        int i = integer;
        if (i == 0) {
            return ONE;
        } else if (i == 1) {
            return TOW;
        } else if (i == 2) {
            return FOUR;
        } else if (i==3){
            return THREE;
        }
         return  0;
    }
  public  void addAll(ArrayList<UpListNewsBean.NewListBean> upListNewsBeans){

         newlistBeanfash.addAll(upListNewsBeans);
       notifyDataSetChanged();
  }



}
