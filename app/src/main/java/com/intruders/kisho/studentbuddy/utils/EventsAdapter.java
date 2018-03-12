package com.intruders.kisho.studentbuddy.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.intruders.kisho.studentbuddy.R;

import java.util.List;

/**
 * Created by kisho on 07-08-2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder>{

    private List<Events> eventsList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Events events = eventsList.get(position);
        holder.EventName.setText(events.getEventName());
        holder.EventTime.setText(events.getEventTime());
        holder.EventLocation.setText(events.getEventLocation());
        holder.EventMember.setText(events.getEventMember());

    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView EventName,EventTime,EventLocation,EventMember;
        public MyViewHolder(View itemView) {
            super(itemView);

            EventName = (TextView)itemView.findViewById(R.id.event_name);
            EventTime = (TextView)itemView.findViewById(R.id.event_time);
            EventLocation = (TextView)itemView.findViewById(R.id.event_location);
            EventMember = (TextView)itemView.findViewById(R.id.event_members);

        }
    }

    public EventsAdapter(List<Events> eventsList){
        this.eventsList = eventsList;
    }
}
