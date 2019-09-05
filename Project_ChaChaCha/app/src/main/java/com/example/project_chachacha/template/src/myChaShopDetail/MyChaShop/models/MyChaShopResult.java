package com.example.project_chachacha.template.src.myChaShopDetail.MyChaShop.models;

import com.google.gson.annotations.SerializedName;

public class MyChaShopResult {

    @SerializedName("storename")
    private String storename;

    @SerializedName("mode")
    private String mode;

    @SerializedName("storewriting")
    private String storewriting;

    @SerializedName("imageurl")
    private String imageurl;

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
