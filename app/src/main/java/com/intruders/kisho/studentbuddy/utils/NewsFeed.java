package com.intruders.kisho.studentbuddy.utils;

/**
 * Created by kisho on 26-08-2017.
 */

public class NewsFeed {

    private String NewsTitle,NewsDesc,NewsTime;

    public NewsFeed(String NewsTitle,String NewsDesc,String NewsTime){

        this.NewsTitle =NewsTitle;
        this.NewsDesc=NewsDesc;
        this.NewsTime=NewsTime;
    }

    public NewsFeed() {

    }




    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsDesc() {
        return NewsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        NewsDesc = newsDesc;
    }

    public String getNewsTime() {
        return NewsTime;
    }

    public void setNewsTime(String newsTime) {
        NewsTime = newsTime;
    }
}
