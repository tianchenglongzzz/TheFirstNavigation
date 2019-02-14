package com.example.mvp.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.ListFollowBean;
import com.example.mvp.myapplication.ui.my.activity.ListFollowActivity;
import com.example.mvp.myapplication.utils.DateUitis;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.ParseException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:AdapterFollow
 * @date :${DATA} 18:52
 */
public class AdapterFollow extends RecyclerView.Adapter {

    private final ArrayList<ListFollowBean.FollowListBean> mFollowListBeans;
    private final ListFollowActivity mListFollowActivity;

    public AdapterFollow(ArrayList<ListFollowBean.FollowListBean> followListBeans, ListFollowActivity listFollowActivity) {
        mFollowListBeans = followListBeans;
        mListFollowActivity = listFollowActivity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mListFollowActivity).inflate(R.layout.item_follow, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mSdvHeadImagePath.setImageURI(mFollowListBeans.get(position).getHeadImagePath());
        viewHolder.mNicknameTv.setText(mFollowListBeans.get(position).getNickname());
        Log.d("timeee",mFollowListBeans.get(position).getFollowTime());
        if (mFollowListBeans.get(position).getFollowTime() != null) {
            String s = DateUitis.CalculateTime(mFollowListBeans.get(position).getFollowTime());
            viewHolder.mTimeTv.setText(s);
        }
        viewHolder.mPersonalProfileTv.setText(mFollowListBeans.get(position).getPersonalProfile());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  mOnItemClick.onClick(position,mFollowListBeans.get(position).getFollowId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFollowListBeans.size();
    }


    static class ViewHolder extends    RecyclerView.ViewHolder {
        @NonNull
        @BindView(R.id.sdv_headImagePath)
        SimpleDraweeView mSdvHeadImagePath;
        @NonNull
        @BindView(R.id.nickname_tv)
        TextView mNicknameTv;
        @NonNull
        @BindView(R.id.personalProfile_tv)
        TextView mPersonalProfileTv;
        @NonNull
        @BindView(R.id.time_tv)
        TextView mTimeTv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
  public   interface OnItemClick{
        void  onClick(int p,String followId);
    }
    public OnItemClick mOnItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }
}
