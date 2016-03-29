package com.dimon.rxandroiddemo.db;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dimon on 2016/3/28.
 *
 */
public class Results {
    @SerializedName("Android") public List<News> androidList;
    @SerializedName("休息视频") public List<News> 休息视频List;
    @SerializedName("iOS") public List<News> iOSList;
    @SerializedName("福利") public List<News> 妹纸List;
    @SerializedName("拓展资源") public List<News> 拓展资源List;
    @SerializedName("瞎推荐") public List<News> 瞎推荐List;
    @SerializedName("App") public List<News> appList;

    public Results(List<News> androidList) {
        this.androidList = androidList;
    }

    public List<News> get休息视频List() {
        return 休息视频List;
    }

    public void set休息视频List(List<News> 休息视频List) {
        this.休息视频List = 休息视频List;
    }

    public List<News> getAndroidList() {
        return androidList;
    }

    public void setAndroidList(List<News> androidList) {
        this.androidList = androidList;
    }

    public List<News> getiOSList() {
        return iOSList;
    }

    public void setiOSList(List<News> iOSList) {
        this.iOSList = iOSList;
    }

    public List<News> get妹纸List() {
        return 妹纸List;
    }

    public void set妹纸List(List<News> 妹纸List) {
        this.妹纸List = 妹纸List;
    }

    public List<News> get拓展资源List() {
        return 拓展资源List;
    }

    public void set拓展资源List(List<News> 拓展资源List) {
        this.拓展资源List = 拓展资源List;
    }

    public List<News> get瞎推荐List() {
        return 瞎推荐List;
    }

    public void set瞎推荐List(List<News> 瞎推荐List) {
        this.瞎推荐List = 瞎推荐List;
    }

    public List<News> getAppList() {
        return appList;
    }

    public void setAppList(List<News> appList) {
        this.appList = appList;
    }
}
