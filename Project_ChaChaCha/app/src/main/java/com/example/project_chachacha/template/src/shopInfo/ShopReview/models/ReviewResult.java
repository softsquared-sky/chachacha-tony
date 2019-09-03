package com.example.project_chachacha.template.src.shopInfo.ShopReview.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResult {

    @SerializedName("reviewcount")
    private List<ReviewCount> reviewCount = null;

    @SerializedName("review")
    private List<Review> review = null;

    public List<ReviewCount> getReviewCount() {
        return reviewCount;
    }

    public List<Review> getReview() {
        return review;
    }
}
