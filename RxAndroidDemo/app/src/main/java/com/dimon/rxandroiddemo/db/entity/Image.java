package com.dimon.rxandroiddemo.db.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dimon on 2016/4/10.
 */
public class Image {
    /**
     * "_id": "56f36e8b67765933d8be9133",
     * "createdAt": "2016-03-24T12:35:23.841Z",
     * "desc": "3.24",
     * "publishedAt": "2016-03-25T11:23:49.570Z",
     * "source": "chrome",
     * "type": "福利",
     * "url": "http://ww1.sinaimg.cn/large/7a8aed7bjw1f27uhoko12j20ez0miq4p.jpg",
     * "used": true,
     * "who": "张涵宇"
     */
    @SerializedName("_id")
    public String id;
    public String type;
    public String desc;
    public String url;
    public String who;
    public String createdAt;
    public String publishedAt;
    private boolean used;

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                ", who='" + who + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", used=" + used +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
