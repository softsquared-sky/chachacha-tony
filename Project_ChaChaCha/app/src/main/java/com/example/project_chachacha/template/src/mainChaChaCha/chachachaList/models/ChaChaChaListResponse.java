package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChaChaChaListResponse {

    @SerializedName("result")
    private List<ChaListResult> result = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public List<ChaListResult> getResult() {
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
