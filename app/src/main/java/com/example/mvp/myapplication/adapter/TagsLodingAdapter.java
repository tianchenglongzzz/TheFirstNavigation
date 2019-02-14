package com.example.mvp.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:TagsHotAdapter
 * @date :${DATA} 20:45
 */
public class TagsLodingAdapter extends RecyclerView.Adapter {

    private final ArrayList<TagsHotBean> mTagsHotBeans;
    private final FragmentActivity mActivity;
    private  ArrayList<ViewHolder>vh=new ArrayList<>();
    //是否显示单选框,默认false
    private boolean isshowBox = false;
    // 存储勾选框状态的map集合
    private  HashMap<Integer,Boolean>map=new HashMap<>();

    public TagsLodingAdapter(ArrayList<TagsHotBean> tagsHotBeans, FragmentActivity activity) {
        mTagsHotBeans = tagsHotBeans;
        mActivity = activity;
            initMap();



    }

    private void initMap() {
        for (int i = 0; i <mTagsHotBeans.size() ; i++) {
            map.put(i,false);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_tagshot_loding, null);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
   //绑定视图管理者
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
         ViewHolder viewHolder = (ViewHolder) holder;
         viewHolder.mTvTageshotItem.setText(mTagsHotBeans.get(position).getTag());
        viewHolder.mCheckBox.setOnCheckedChangeListener(null);
        Log.e("tian",map.get(position)+""+position);
        viewHolder.mCheckBox.setChecked(map.get(position));
        viewHolder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItemOnChcke.onCheckItem(buttonView, isChecked, mTagsHotBeans.get(position).getTag(), position);
                    map.put(position,isChecked);
                }
            });




    }

    @Override
    public int getItemCount() {
        return mTagsHotBeans.size();
    }

    static class ViewHolder  extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_tageshot_item_loding)
        TextView mTvTageshotItem;
        @BindView(R.id.cb_tags)
        CheckBox mCheckBox;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setItemOnChcke(ItemOnChcke itemOnChcke) {
        mItemOnChcke = itemOnChcke;
    }

    private  ItemOnChcke mItemOnChcke;
    public interface  ItemOnChcke{
        void onCheckItem(View v,boolean check,String str,int  position);
    }
}
