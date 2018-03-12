package com.intruders.kisho.studentbuddy.utils;

/**
 * Created by kisho on 26-08-2017.
 */

public class College {

    private String Cid;
    private String Name;
    public College(String Cid,String Name){
        this.Cid = Cid;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }
}
