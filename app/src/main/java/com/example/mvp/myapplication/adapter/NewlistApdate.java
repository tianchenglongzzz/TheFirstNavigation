package com.example.mvp.myapplication.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.service.quicksettings.TileService;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.DownListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.ui.news.activity.ShowDataActivity;
import com.example.mvp.myapplication.utils.GlideUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:NewlisrApdate
 * @date :${DATA} 21:20
 */
public class NewlistApdate extends XRecyclerView.Adapter {
    private static final int ONE = 0;
    private static final int THREE = 3;
    private static final int TOW = 1;
    private static final int FOUR = 4;
    private static final String TAG = "NewlistApdate";

    private  ArrayList<UpListNewsBean.NewListBean> newlistBeanfash;
    private final Activity activity;

    public NewlistApdate(ArrayList<UpListNewsBean.NewListBean> newListBeans,Activity activity) {

        this.newlistBeanfash = newListBeans;

        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_nelayoutwsone, null);
            return new ViewHolderOne(view);
        } else if (viewType == TOW) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_nelayoutwstow, null);
            return  new ViewHolderTow(view);
        } else if (viewType == THREE) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_nelayoutwsthree, null);
            return  new ViewHolderThree(view);
        } else  {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_nelayoutwsfour, null);
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
                    viewHolderOne.mOriginTv.setText(newlistBeanfash.get(position).getOrigin());
                    viewHolderOne.mIitleTv.setText(newlistBeanfash.get(position).getTitle());
                    if (position==0||position==1){
                        viewHolderOne.mTopImg.setImageResource(R.mipmap.news_top);
                    }else {
                        viewHolderOne.mTopImg.setVisibility(View.GONE);
                    }
                     viewHolderOne.mPageviewsTv.setText(newlistBeanfash.get(position).getPageviews()+"阅读");
                    viewHolderOne.mPublishTimeTv.setText(newlistBeanfash.get(position).getPublishTime());
                    viewHolderOne.reovelsit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                              newlistBeanfash.remove(position);
                              notifyDataSetChanged();
                        }
                    });
                }else if (itemViewType==TOW){
                        ViewHolderTow viewHolderTow= (ViewHolderTow) holder;
                        viewHolderTow.mIitleTv.setText(newlistBeanfash.get(position).getTitle());
                        viewHolderTow.mOriginTv.setText(newlistBeanfash.get(position).getOrigin());
                        viewHolderTow.mPageviewsTv.setText(newlistBeanfash.get(position).getPageviews()+"阅读");
                        viewHolderTow.mPublishTimeTv.setText(newlistBeanfash.get(position).getPublishTime());
                    Uri uri = Uri.parse(newlistBeanfash.get(position).getImageListThumb().get(0));

                    Glide.with(activity).load(newlistBeanfash.get(position).getImageListThumb().get(0)).error(R.drawable.errp).into(((ViewHolderTow) holder).mImageListThumbImg);
                    if (position==0||position==1){
                        viewHolderTow.mTopImg.setImageResource(R.mipmap.news_top);
                    }else {
                        viewHolderTow.mTopImg.setVisibility(View.GONE);
                    }
                    viewHolderTow.reovelsit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newlistBeanfash.remove(position);
                            notifyDataSetChanged();
                        }
                    });
                }else if (itemViewType==THREE){
                    ViewHolderThree viewHolderThree= (ViewHolderThree) holder;
                    viewHolderThree.mIitleTv.setText(newlistBeanfash.get(position).getTitle());
                    viewHolderThree.mPageviewsTv.setText(newlistBeanfash.get(position).getPageviews()+"阅读");
                    viewHolderThree.mPublishTimeTv.setText(newlistBeanfash.get(position).getPublishTime());
                    viewHolderThree.mOriginTv.setText(newlistBeanfash.get(position).getOrigin());
                    if (newlistBeanfash.get(position).getIsTop()==1){
                        viewHolderThree.mTopImg.setImageResource(R.mipmap.news_top);
                    }else {
                        viewHolderThree.mTopImg.setVisibility(View.GONE);
                    }
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
                    viewHolderThree.reovelsit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                              newlistBeanfash.remove(position);
                              notifyDataSetChanged();
                        }
                    });
                }else if (itemViewType==FOUR){
                    ViewHolderFour viewHolderFour= (ViewHolderFour) holder;

                    viewHolderFour.mIitleTv.setText(newlistBeanfash.get(position).getTitle());
                    viewHolderFour.mOriginTv.setText(newlistBeanfash.get(position).getOrigin());
                    viewHolderFour.mPageviewsTv.setText(newlistBeanfash.get(position).getPageviews()+"阅读");
                    viewHolderFour.mPublishTimeTv.setText(newlistBeanfash.get(position).getPublishTime());
                    if (position==1||position==0){
                        viewHolderFour.mTopImg.setImageResource(R.mipmap.news_top);
                    }else {
                        viewHolderFour.mTopImg.setVisibility(View.GONE);
                    }
                    GlideUtil.setImgBig(newlistBeanfash.get(position).getImageListThumb().get(0),((ViewHolderFour) holder).mImageListThumbImg,activity);
                    viewHolderFour.reovelsit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newlistBeanfash.remove(position);
                            notifyDataSetChanged();
                        }
                    });
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
        ImageView reovelsit;
        TextView mIitleTv;
         ImageView mTopImg;
         TextView  mOriginTv;
         TextView mPageviewsTv;
          TextView mPublishTimeTv;


        public ViewHolderOne(View itemView) {
            super(itemView);
            mPageviewsTv=itemView.findViewById(R.id.news_pagevies);
            mIitleTv= itemView.findViewById(R.id.one_tiile);
            mTopImg= itemView.findViewById(R.id.news_top);
            mOriginTv=itemView.findViewById(R.id.news_origin);
            mPublishTimeTv=itemView.findViewById(R.id.news_publishTime);
            reovelsit=itemView.findViewById(R.id.new_x_one);
        }
    }

    class ViewHolderTow extends RecyclerView.ViewHolder {
        ImageView reovelsit;
        TextView mIitleTv;
        ImageView mTopImg;
        TextView  mOriginTv;
        TextView mPageviewsTv;
        TextView mPublishTimeTv;
        SimpleDraweeView mImageListThumbImg;

        public ViewHolderTow(View itemView) {
            super(itemView);
            mPageviewsTv=itemView.findViewById(R.id.news_pagevies_tow);
            mIitleTv= itemView.findViewById(R.id.one_tiile_tow);
            mTopImg= itemView.findViewById(R.id.news_top_tow);
            mOriginTv=itemView.findViewById(R.id.news_origin_tow);
            mPublishTimeTv=itemView.findViewById(R.id.news_publishTime_tow);
            mImageListThumbImg=itemView.findViewById(R.id.news_imageListThumb_tow);
            reovelsit=itemView.findViewById(R.id.new_x_tow);

        }
    }

    class ViewHolderThree extends RecyclerView.ViewHolder {
        ImageView reovelsit;
        TextView mIitleTv;
        ImageView mTopImg;
        TextView  mOriginTv;
        TextView mPageviewsTv;
        TextView mPublishTimeTv;
        SimpleDraweeView mImageListThumbImg;
        SimpleDraweeView mImageListThumbImgTow;
        SimpleDraweeView mImageListThumbImgThree;

        public ViewHolderThree(View itemView) {
            super(itemView);
            mIitleTv= itemView.findViewById(R.id.one_tiile_three);
            mTopImg= itemView.findViewById(R.id.news_top_three);
            mPageviewsTv=itemView.findViewById(R.id.news_pagevies_three);
            mOriginTv=itemView.findViewById(R.id.news_origin_three);
            mPublishTimeTv=itemView.findViewById(R.id.news_publishTime_three);
            mImageListThumbImg=itemView.findViewById(R.id.news_imageListThumb_three_three);
            mImageListThumbImgTow=itemView.findViewById(R.id.news_imageListThumb_tow_tow);
            mImageListThumbImgThree=itemView.findViewById(R.id.news_imageListThumb_three);
            reovelsit=itemView.findViewById(R.id.new_x_three);

        }
    }

    class ViewHolderFour extends RecyclerView.ViewHolder {
        ImageView reovelsit;
        TextView mIitleTv;
        ImageView mTopImg;
        TextView  mOriginTv;
        TextView mPageviewsTv;
        TextView mPublishTimeTv;
        SimpleDraweeView mImageListThumbImg;
        public ViewHolderFour(View itemView) {
            super(itemView);
            mPageviewsTv=itemView.findViewById(R.id.news_pagevies_four);
            mIitleTv= itemView.findViewById(R.id.one_tiile_four);
            mTopImg= itemView.findViewById(R.id.news_top_four);
            mOriginTv=itemView.findViewById(R.id.news_origin_four);
            mPublishTimeTv=itemView.findViewById(R.id.news_publishTime_four);
            mImageListThumbImg=itemView.findViewById(R.id.news_imageListThumb_four);
            reovelsit=itemView.findViewById(R.id.new_x_four);



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
