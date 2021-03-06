package com.dimon.rxandroiddemo.db.entity;

/**
 * Created by Dimon on 2016/3/29.
 */
public class Item {
    public String date;
    public String description;
    public String url;
    public String who;
    public String imageurl;

    @Override
    public String toString() {
        return "Item{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", who='" + who + '\'' +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
