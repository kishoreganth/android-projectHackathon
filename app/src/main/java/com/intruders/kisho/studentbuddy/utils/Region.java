package com.intruders.kisho.studentbuddy.utils;

/**
 * Created by kisho on 25-08-2017.
 */

public class Region {

    private int id;
    private String region;

    public Region(int id,String region){
        this.id = id;
        this.region=region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
