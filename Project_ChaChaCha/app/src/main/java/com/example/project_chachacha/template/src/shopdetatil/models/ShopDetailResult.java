package com.example.project_chachacha.template.src.shopdetatil.models;

import com.google.gson.annotations.SerializedName;

public class ShopDetailResult {
    @SerializedName("storename")
    private String storename;

    @SerializedName("mode")
    private String mode;

    @SerializedName("storewriting")
    private String storewriting;

    @SerializedName("address")
    private String address;

    @SerializedName("opentime")
    private String opentime;

    @SerializedName("closstime")
    private String closstime;

    @SerializedName("imageurl")
    private String imageurl;

    @SerializedName("phone")
    private String phone;

    public String getPhone() {
        return phone;
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

    public String getAddress() {
        return address;
    }

    public String getOpentime() {
        return opentime;
    }

    public String getClosstime() {
        return closstime;
    }

    public String getImageurl() {
        return imageurl;
    }
}
