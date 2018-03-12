package com.intruders.kisho.studentbuddy.utils;

/**
 * Created by kisho on 26-08-2017.
 */

public class Year {

    private String Yid,Year;
    public Year(String Yid,String Year){
        this.Yid=Yid;
        this.Year=Year;
    }

    public String getYid() {
        return Yid;
    }

    public void setYid(String yid) {
        Yid = yid;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
