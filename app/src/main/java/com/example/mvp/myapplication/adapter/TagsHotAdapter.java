package com.example.mvp.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.ui.topic.activity.ShowTagsTopicActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:TagsHotAdapter
 * @date :${DATA} 20:45
 */
public class TagsHotAdapter extends RecyclerView.Adapter {

    private final ArrayList<TagsHotBean> mTagsHotBeans;
    private final FragmentActivity mActivity;
    //看是否是是搜索
    //默认为true//不搜索

    private  boolean sareb=true;
    private String sare;

    public TagsHotAdapter(ArrayList<TagsHotBean> tagsHotBeans, FragmentActivity activity) {
        mTagsHotBeans = tagsHotBeans;
        mActivity = activity;

    }
   //调用这个方法就把适配器从默认模式改为搜索模式
    public void setSare(boolean sareb,String  sare) {
        this.sareb = sareb;
        this.sare=sare;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_tagshot, null);
          return new  ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (sareb) {
            //适配器默认模式
            if (position == 0) {

                viewHolder.mTvTageshotItem.setText("热门分类标签");
                viewHolder.mImageView.setVisibility(View.GONE);
            } else {
                viewHolder.mTvTageshotItem.setText(mTagsHotBeans.get(position - 1).getTag());
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mActivity, ShowTagsTopicActivity.class);
                        intent.putExtra("name", mTagsHotBeans.get(position).getTag());
                        intent.putExtra("id", mTagsHotBeans.get(position).getId());
                        mActivity.startActivity(intent);
                    }
                });
            }
        }else {
            //适配器搜索模式
            if (position == 0) {
                viewHolder.mTvTageshotItem.setText("搜索分类标签");
                viewHolder.mImageView.setVisibility(View.GONE);
            } else {
                final String tag = mTagsHotBeans.get(position - 1).getTag();
                int indexOf = tag.indexOf(sare);
                int end=indexOf+sare.length();
                //使文字变色
                SpannableString s = new SpannableString(tag);

                Log.d("TAG",indexOf+"============"+end);
                s.setSpan(new ForegroundColorSpan(R.color.read),indexOf,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                viewHolder.mTvTageshotItem.setText(s);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(mActivity, ShowTagsTopicActivity.class);
                        intent.putExtra("name",tag);
                        intent.putExtra("id", mTagsHotBeans.get(position).getId());
                        mActivity.startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return mTagsHotBeans.size()+1;
    }

    static class ViewHolder  extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_tageshot)
        TextView mTvTageshotItem;
        @BindView(R.id.img_tags_qianjin)
        ImageView mImageView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
