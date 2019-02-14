package com.example.mvp.myapplication.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.MoreFollowBean;
import com.example.mvp.myapplication.ui.my.activity.UserHomePageActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:MoreRVAdapter
 * @date :${DATA} 15:45
 */
public class MoreRVAdapter extends RecyclerView.Adapter {

    private final ArrayList<MoreFollowBean.MoreFollowListBean> mMoreFollowListBeans;
    private final FragmentActivity mActivity;

    public MoreRVAdapter(ArrayList<MoreFollowBean.MoreFollowListBean> moreFollowListBeans, FragmentActivity activity) {
        mMoreFollowListBeans = moreFollowListBeans;
        mActivity = activity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mActivity).inflate(R.layout.item_morefollow, null);
        return  new ViewHolderMore(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
          final ViewHolderMore viewHolderMore= (ViewHolderMore) holder;
          viewHolderMore.mMoreFollowFollowersItemTv.setText(mMoreFollowListBeans.get(position).getFollowers()+"关注");
          viewHolderMore.mMoreFollowNicknameItemTv.setText(mMoreFollowListBeans.get(position).getNickname());
          viewHolderMore.mMorefollowItemSdv.setImageURI(Uri.parse(mMoreFollowListBeans.get(position).getHeadImagePath()));
          viewHolderMore.morCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        
              }
          });
          viewHolderMore.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(mActivity, UserHomePageActivity.class);
                  intent.putExtra("id",mMoreFollowListBeans.get(position).getUserId());
                  mActivity.startActivity(intent);
              }
          });
    }

    @Override
    public int getItemCount() {
        return mMoreFollowListBeans.size();
    }

    static class ViewHolderMore extends RecyclerView.ViewHolder{
        @BindView(R.id.add_more)
        CheckBox morCB;
        @BindView(R.id.morefollow_item_sdv)
        SimpleDraweeView mMorefollowItemSdv;
        @BindView(R.id.moreFollow_nickname_item_tv)
        TextView mMoreFollowNicknameItemTv;
        @BindView(R.id.moreFollow_followers_item_tv)
        TextView mMoreFollowFollowersItemTv;

        ViewHolderMore(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setOnClicKFollower(OnClicKFollower onClicKFollower) {
        mOnClicKFollower = onClicKFollower;
    }

    OnClicKFollower mOnClicKFollower;
    interface  OnClicKFollower{
          void  onClick(String userid);
    }
}
