package com.intruders.kisho.studentbuddy.utils;

/**
 * Created by kisho on 26-08-2017.
 */

public class Dept {

    private String Did, Dept;

    public Dept(String Did,String Dept){
        this.Did = Did;
        this.Dept = Dept;
    }

    public String getDid() {
        return Did;
    }

    public void setDid(String did) {
        Did = did;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }
}
