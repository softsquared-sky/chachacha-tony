package com.example.project_chachacha.template.src.myPage.MyChaChaCha.models;

import com.google.gson.annotations.SerializedName;

public class MyChaChaChaResult {

    @SerializedName("chanum")
    private int chanum;

    @SerializedName("storename")
    private String storename;

    @SerializedName("imageurl")
    private String imageurl;

    public int getChanum() {
        return chanum;
    }

    public String getStorename() {
        return storename;
    }

    public String getImageurl() {
        return imageurl;
    }
}
