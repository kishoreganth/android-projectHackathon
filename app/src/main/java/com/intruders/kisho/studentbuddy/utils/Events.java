package com.intruders.kisho.studentbuddy.utils;

/**
 * Created by kisho on 07-08-2017.
 */

public class Events {

    private String EventName,EventTime,EventLocation,EventMember;


    public Events(String EventName, String EventTime, String EventLocation, String  EventMember){
        this.EventLocation = EventLocation;
        this.EventName = EventName;
        this.EventTime = EventTime;
        this.EventMember = EventMember;
    }
    public Events(){

    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String eventLocation) {
        EventLocation = eventLocation;
    }

    public String getEventTime() {
        return EventTime;
    }

    public void setEventTime(String eventTime) {
        EventTime = eventTime;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventMember() {
        return EventMember;
    }

    public void setEventMember(String eventMember) {
        EventMember = eventMember;
    }
}
