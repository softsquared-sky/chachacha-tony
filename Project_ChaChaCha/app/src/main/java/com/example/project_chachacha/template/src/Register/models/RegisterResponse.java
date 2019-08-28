package com.example.project_chachacha.template.src.Register.models;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("isSuccess")
    private String isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public String getIsSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
