package com.adaptercontroller.test;

/**
 * Created by kingwu on 2016/3/22.
 */
public class RecyclerModel {
    private String url;

    private String text;

    public RecyclerModel(String url,String text){
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
