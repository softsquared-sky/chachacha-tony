package com.example.project_chachacha.template.src.shopdetatil.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopDetailResponse {

    @SerializedName("result")
    private List<ShopDetailResult> result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public List<ShopDetailResult> getResult() {
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
