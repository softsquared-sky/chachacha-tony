package com.example.project_chachacha.template.src.mypage.Myreview.models;

import com.google.gson.annotations.SerializedName;

public class ResultItem {

    @SerializedName("storename")
    private String storename;

    @SerializedName("star")
    private int star;

    @SerializedName("address")
    private String address;

    @SerializedName("text")
    private String text;

    public String getStorename() {
        return storename;
    }

    public int getStar() {
        return star;
    }

    public String getAddress() {
        return address;
    }

    public String getText() {
        return text;
    }
}
