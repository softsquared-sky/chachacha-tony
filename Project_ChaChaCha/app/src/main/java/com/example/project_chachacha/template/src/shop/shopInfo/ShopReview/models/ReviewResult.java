package com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResult {

    @SerializedName("reviewcount")
    private int reviewCount;

    @SerializedName("review")
    private List<Review> review = null;

    public int getReviewCount() {
        return reviewCount;
    }

    public List<Review> getReview() {
        return review;
    }
}
