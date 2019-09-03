package com.example.project_chachacha.template.src.mypage.StoreShop.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoreShopResponse {
    @SerializedName("result")
    private List<ResultStoreShop> result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public List<ResultStoreShop> getResult() {
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
