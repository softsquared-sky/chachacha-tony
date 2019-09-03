package com.example.project_chachacha.template.src.mypage.Myreview.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyreviewResponse {

    @SerializedName("result")
    private List<ResultItem> resultItemList = null;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public List<ResultItem> getResultItemList() {
        return resultItemList;
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
