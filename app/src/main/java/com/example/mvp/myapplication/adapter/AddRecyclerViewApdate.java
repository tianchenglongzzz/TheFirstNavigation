package com.example.mvp.myapplication.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvp.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:AddRecyclerViewApdate
 * @date :${DATA} 14:09
 */
public class AddRecyclerViewApdate extends RecyclerView.Adapter {
    private final ArrayList<String> add;
    private final Activity activity;
    private final ItemTouchHelper helper;
    private boolean isdrag=false;
    private  boolean isButton=false;

    public AddRecyclerViewApdate(ArrayList<String> add, Activity activity, ItemTouchHelper helper) {
        this.activity = activity;
        this.add = add;
        this.helper=helper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_add, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
                  ViewHolder viewHolder= (ViewHolder) holder;
                  viewHolder.mAddTv.setText(add.get(position));
                  if (isButton){
                      viewHolder.mRemoveBtn.setVisibility(View.VISIBLE);
                      mIButtonRemove.reove(viewHolder.mRemoveBtn,position);
                  }else {
                      viewHolder.mRemoveBtn.setVisibility(View.GONE);
                  }
                  viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                      @Override
                      public boolean onLongClick(View v) {
                            if (isdrag){
                                helper.startDrag(holder);
                            }else {

                            }
                          mOnItemClickListener.onItemLongClick(v,position);
                          return true;
                      }
                  });
                  viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                           mOnItemClickListener.onItemClick(v,position);
                      }
                  });


    }

    @Override
    public int getItemCount() {
        return add.size();
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

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.add_tv)
        TextView mAddTv;
        @BindView(R.id.remove_btn_a)
        Button mRemoveBtn;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setIsButton(boolean button) {
        isButton = button;
    }

    public void setIsdrag(boolean isdrag) {
        this.isdrag = isdrag;
        notifyDataSetChanged();
    }

    public void setIButtonRemove(IButtonRemove IButtonRemove) {
        mIButtonRemove = IButtonRemove;
    }

     IButtonRemove mIButtonRemove;
    public    interface  IButtonRemove{
          void  reove(Button button,int position);
    }


}
