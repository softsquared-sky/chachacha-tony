package com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.models;

import com.google.gson.annotations.SerializedName;

public class MenuResponse {

    @SerializedName("result")
    private MenuResult result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public MenuResult getResult() {
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
