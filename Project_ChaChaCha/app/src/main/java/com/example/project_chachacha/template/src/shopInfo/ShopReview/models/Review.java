package com.example.project_chachacha.template.src.shopInfo.ShopReview.models;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("name")
    private String name;

    @SerializedName("text")
    private String text;

    @SerializedName("star")
    private int star;

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getStar() {
        return star;
    }
}
