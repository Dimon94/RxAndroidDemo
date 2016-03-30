package com.dimon.rxandroiddemo.db;

import com.dimon.rxandroiddemo.db.entity.News;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dimon on 2016/3/29.
 */
public class GanWuData {
    public Result results;
    public List<String> category;
    private boolean error;

    public class Result {
        @SerializedName("Android")
        public List<News> androidList;

        @SerializedName("休息视频")
        public List<News> 休息视频List;

        @SerializedName("iOS")
        public List<News> iOSList;

        @SerializedName("福利")
        public List<News> 妹纸List;

        @SerializedName("拓展资源")
        public List<News> 拓展资源List;

        @SerializedName("瞎推荐")
        public List<News> 瞎推荐List;

        @SerializedName("App")
        public List<News> appList;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
