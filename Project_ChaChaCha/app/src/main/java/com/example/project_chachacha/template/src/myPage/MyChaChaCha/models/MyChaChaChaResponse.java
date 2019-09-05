package com.example.project_chachacha.template.src.myPage.MyChaChaCha.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyChaChaChaResponse {

    @SerializedName("result")
    private List<MyChaChaChaResult> result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public List<MyChaChaChaResult> getResult() {
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
