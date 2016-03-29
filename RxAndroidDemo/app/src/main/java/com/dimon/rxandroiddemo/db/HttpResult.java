package com.dimon.rxandroiddemo.db;

import java.util.List;

/**
 * Created by Dimon on 2016/3/28.
 */
public class HttpResult<T> {

    //用来模仿resultCode和resultMessage
    private List<String> category;
    private boolean error;
    private T results;


    //用来模仿Data


    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}