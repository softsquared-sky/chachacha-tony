package com.example.project_chachacha.template.src.myPage.MyChaChaCha.models;

import com.google.gson.annotations.SerializedName;

public class MyChaChaChaDeleteResponse {


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
