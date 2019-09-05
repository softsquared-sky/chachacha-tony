package com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.models;

import com.google.gson.annotations.SerializedName;

public class ReviewResponse {

    @SerializedName("result")
    private ReviewResult result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public ReviewResult getResult() {
        return result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
