package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.models;

import com.google.gson.annotations.SerializedName;

public class ChaListResult {

    @SerializedName("storenum")
    private int storenum;

    @SerializedName("storename")
    private String storename;

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
