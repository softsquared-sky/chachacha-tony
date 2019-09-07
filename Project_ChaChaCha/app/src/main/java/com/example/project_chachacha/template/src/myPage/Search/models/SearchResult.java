package com.example.project_chachacha.template.src.myPage.Search.models;

import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("storename")
    private String storename;

    @SerializedName("storenum")
    private int storenum;

    @SerializedName("mode")
    private String mode;

    @SerializedName("storewriting")
    private String storewriting;

    @SerializedName("imageurl")
    private String imageurl;

    public int getStorenum() {
        return storenum;
    }

    public String getStorename() {
        return storename;
    }

    public String getMode() {
        return mode;
    }

    public String getStorewriting() {
        return storewriting;
    }

    public String getImageurl() {
        return imageurl;
    }
}
