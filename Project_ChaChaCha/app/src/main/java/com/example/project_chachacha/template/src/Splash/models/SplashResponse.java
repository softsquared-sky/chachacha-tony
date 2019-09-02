package com.example.project_chachacha.template.src.Splash.models;

import com.google.gson.annotations.SerializedName;

public class SplashResponse {

    @SerializedName("result")
    private SplashResponseResult result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public SplashResponseResult getResult() {
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
