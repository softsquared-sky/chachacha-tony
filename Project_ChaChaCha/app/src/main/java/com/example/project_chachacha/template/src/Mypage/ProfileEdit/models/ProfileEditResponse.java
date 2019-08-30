package com.example.project_chachacha.template.src.Mypage.ProfileEdit.models;

import com.google.gson.annotations.SerializedName;

public class ProfileEditResponse {

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

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
