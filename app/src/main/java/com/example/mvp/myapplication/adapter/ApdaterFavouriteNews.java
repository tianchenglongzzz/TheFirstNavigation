package com.example.mvp.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.FavouriteNewsBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:ApdaterFavouriteNews
 * @date :${DATA} 21:36
 */
public class ApdaterFavouriteNews extends RecyclerView.Adapter {

    private final ArrayList<FavouriteNewsBean.FavouritNewsListBean> mFavouriteNewsBeans;
    private final FragmentActivity mFavouriteNewsFragment;
     Map<Integer,Boolean> mMap=new HashMap<>();

    public ApdaterFavouriteNews(ArrayList<FavouriteNewsBean.FavouritNewsListBean> favouriteNewsBeans, FragmentActivity favouriteNewsFragment) {
        mFavouriteNewsBeans = favouriteNewsBeans;
        mFavouriteNewsFragment = favouriteNewsFragment;


    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mFavouriteNewsFragment).inflate(R.layout.item_favour_news, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

               ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.mFavourNewsItemTv.setText(mFavouriteNewsBeans.get(position).getTitle());
               viewHolder.mFavourNewsItemCb.setOnCheckedChangeListener(null);
               viewHolder.mFavourNewsItemCb.setChecked(mMap.get(position));
               viewHolder.mFavourNewsItemCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                           mMap.put(position,isChecked);
                           if (isChecked){
                               mApdaterCheckedChangedListener.onCheckedChang(mFavouriteNewsBeans.get(position).getFavouritId(),isChecked,position);
                           }else {
                               mApdaterCheckedChangedListener.onCheckedChang(mFavouriteNewsBeans.get(position).getFavouritId(),isChecked,position);
                           }
                   }
               });

    }

    @Override
    public int getItemCount() {
        return mFavouriteNewsBeans.size();
    }

    public void setMap() {
        for (int i = 0; i <mFavouriteNewsBeans.size() ; i++) {
             mMap.put(i,false);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.favour_news_item_cb)
        CheckBox mFavourNewsItemCb;
        @BindView(R.id.favour_news_item_tv)
        TextView mFavourNewsItemTv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setApdaterCheckedChangedListener(ApdaterCheckedChangedListener apdaterCheckedChangedListener) {
        mApdaterCheckedChangedListener = apdaterCheckedChangedListener;
    }

    ApdaterCheckedChangedListener mApdaterCheckedChangedListener;
   public interface ApdaterCheckedChangedListener{
         void  onCheckedChang(String favouritId,boolean isCheck,int p);

    }
}
