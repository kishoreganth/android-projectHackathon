package com.intruders.kisho.studentbuddy.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.intruders.kisho.studentbuddy.R;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by kisho on 26-08-2017.
 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {

    List<NewsFeed> newsFeedList;
    Context context;

    public NewsFeedAdapter(List<NewsFeed> newsFeedList, Context context){
        this.newsFeedList = newsFeedList;
        this.context = context;
    }
    public NewsFeedAdapter(List<NewsFeed> newsFeedList){
        this.newsFeedList=newsFeedList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news_feed,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        NewsFeed newsFeed1 = newsFeedList.get(position);

        holder.NewsFeedTitle.setText(newsFeed1.getNewsTitle());
        holder.NewsFeedDesc.setText(newsFeed1.getNewsDesc());
        holder.NewsTime.setText(newsFeed1.getNewsTime());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         TextView NewsFeedTitle;
            TextView NewsTime;
         TextView NewsFeedDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            NewsFeedTitle = (TextView)itemView.findViewById(R.id.news_title);
            NewsFeedDesc = (TextView)itemView.findViewById(R.id.news_feed_desc);

            NewsTime = (TextView)itemView.findViewById(R.id.news_time);

        }
    }


    @Override
    public int getItemCount() {
        return newsFeedList.size();
    }
}