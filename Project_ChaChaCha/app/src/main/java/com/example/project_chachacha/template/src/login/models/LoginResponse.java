package com.example.project_chachacha.template.src.login.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("result")
    private Result result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public Result getResult() {
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
