package com.example.project_chachacha.template.src.myPage.MyPageMain.models;

import com.google.gson.annotations.SerializedName;

public class MypageMainResponse {

    @SerializedName("result")
    private MypageMainResult result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public MypageMainResult getResult() {
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
