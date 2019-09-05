package com.example.project_chachacha.template.src.myChaShopDetail.MyChaShop.models;

import com.google.gson.annotations.SerializedName;

public class MyChaShopResponse {

    @SerializedName("result")
    private MyChaShopResult result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public MyChaShopResult getResult() {
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
