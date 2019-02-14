package com.example.mvp.myapplication.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:IinsertApdater
 * @date :${DATA} 15:07
 */
public class IinsertApdater extends RecyclerView.Adapter {

    private final ArrayList<Uri> mUris;
    private final Activity mActivity;

    public IinsertApdater(ArrayList<Uri> uris, Activity activity) {
        mUris = uris;
        mActivity = activity;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_addimg, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
             ViewHolder viewHolder= (ViewHolder) holder;
             viewHolder.mSdvAddimgItem.setImageURI(mUris.get(position));
    }

    @Override
    public int getItemCount() {
        return mUris.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv_addimg_item)
        SimpleDraweeView mSdvAddimgItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
