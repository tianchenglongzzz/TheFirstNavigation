package com.example.mvp.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
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

    public TagsHotAdapter(ArrayList<TagsHotBean> tagsHotBeans, FragmentActivity activity) {
        mTagsHotBeans = tagsHotBeans;
        mActivity = activity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_tagshot, null);
          return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (position==0) {

            viewHolder.mTvTageshotItem.setText("热门分类标签");
            viewHolder.mImageView.setVisibility(View.GONE);
        }else {
            viewHolder.mTvTageshotItem.setText(mTagsHotBeans.get(position-1).getTag());
        }
    }

    @Override
    public int getItemCount() {
        return mTagsHotBeans.size()+1;
    }

    static class ViewHolder  extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_tageshot_item)
        TextView mTvTageshotItem;
        @BindView(R.id.img_tags_qianjin)
        ImageView mImageView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
