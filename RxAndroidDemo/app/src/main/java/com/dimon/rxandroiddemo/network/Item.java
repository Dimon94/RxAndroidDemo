package com.dimon.rxandroiddemo.network;

/**
 * Created by Dimon on 2016/3/29.
 */
public class Item {
    public String description;
    public String url;
    public String who;

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", who='" + who + '\'' +
                '}';
    }
}
