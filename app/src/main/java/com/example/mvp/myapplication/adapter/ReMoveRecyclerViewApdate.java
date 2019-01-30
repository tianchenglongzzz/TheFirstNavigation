package com.example.mvp.myapplication.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.Headers;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:AddRecyclerViewApdate
 * @date :${DATA} 14:09
 */
public class ReMoveRecyclerViewApdate extends RecyclerView.Adapter {

    private final ArrayList<String> mRemove;
    private Activity activity;

    public ReMoveRecyclerViewApdate(ArrayList<String> remove, Activity activity) {
        mRemove = remove;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_remove, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
              ViewHolder viewHolder= (ViewHolder) holder;
              viewHolder.mAdd.setText(mRemove.get(position));
              viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                       mOnItemClickListener.onItemClick(v,position);
                  }
              });
    }

    @Override
    public int getItemCount() {
        return mRemove.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.remove_tv)
        TextView mAdd;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
   public interface OnItemClickListener {
       void onItemClick(View view, int position);

       void onItemLongClick(View view, int position);
   }

   private OnItemClickListener mOnItemClickListener;

   //在Activity中调用
   public void setOnItemClickListener(OnItemClickListener listener) {
       this.mOnItemClickListener = listener;
   }
}
