package com.example.mvp.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.ListProfessionBean;
import com.example.mvp.myapplication.ui.my.activity.ProfessionActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:ProfessionAdapter
 * @date :${DATA} 12:47
 */
public class ProfessionAdapter extends RecyclerView.Adapter {



    private  String mId;
    private ProfessionActivity mProfessionActivity;
    private final Map<Integer, Boolean> mMap;
    private final List<ListProfessionBean.ProfessionListBean> mProfessionList;


    public ProfessionAdapter(ListProfessionBean listProfessionBeans, String id, ProfessionActivity professionActivity) {
        mProfessionList = listProfessionBeans.getProfessionList();
        mId = id;
        mProfessionActivity = professionActivity;
        mMap = new HashMap<>();
        for (int i = 0; i < mProfessionList.size(); i++) {
              mMap.put(i,false);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mProfessionActivity).inflate(R.layout.item_pfi, null);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
                ViewHolder viewHolder= (ViewHolder) holder;
                viewHolder.mPfiTv.setText(mProfessionList.get(position).getProfessionName());
                if (mProfessionList.get(position).getProfessionName().equals(mId)){
                     viewHolder.mPfiCb.setChecked(true);
                }
                viewHolder.mPfiCb.setOnCheckedChangeListener(null);
                viewHolder.mPfiCb.setChecked(mMap.get(position));
                viewHolder.mPfiCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                             if (isChecked){

                                 mOnCheckListener.onCheck(mProfessionList.get(position).getProfessionId(),mProfessionList.get(position).getProfessionName());
                                 for (int i = 0; i <mMap.size() ; i++) {
                                     if (i!=position){
                                         mMap.put(i,false);
                                     }else {
                                         mMap.put(i,true);
                                     }
                                     notifyDataSetChanged();
                                 }
                             }else {
                                  mOnCheckListener.onCheck("","");
                             }
                    }
                });


    }

    @Override
    public int getItemCount() {
        return mProfessionList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.pfi_tv)
        TextView mPfiTv;
        @BindView(R.id.pfi_cb)
        CheckBox mPfiCb;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setOnCheckListener(onCheckListener onCheckListener) {
        mOnCheckListener = onCheckListener;
    }

    onCheckListener mOnCheckListener;
   public interface  onCheckListener{
        void  onCheck(String pfi,String name);
    }

}
