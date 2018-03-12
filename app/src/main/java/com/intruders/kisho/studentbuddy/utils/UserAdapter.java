package com.intruders.kisho.studentbuddy.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.intruders.kisho.studentbuddy.R;

import java.util.List;

/**
 * Created by kisho on 26-08-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private List<User> userList;

    public UserAdapter(List<User> userList){
        this.userList = userList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.MyViewHolder holder, int position) {

        User user = userList.get(position);
        holder.Username.setText(user.getUsername());


    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView Username;
        public MyViewHolder(View itemView) {
            super(itemView);

            Username = (TextView)itemView.findViewById(R.id.textview_friend);


        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
