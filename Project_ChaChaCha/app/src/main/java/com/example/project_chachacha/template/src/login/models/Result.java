package com.example.project_chachacha.template.src.login.models;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("jwt")
    private String jwt;

    public String getJwt() {
        return jwt;
    }
}
