package com.example.project_chachacha.template.src.Mypage.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MypageResponse {

    @SerializedName("result")
    private MypageResult result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public MypageResult getResult() {
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
