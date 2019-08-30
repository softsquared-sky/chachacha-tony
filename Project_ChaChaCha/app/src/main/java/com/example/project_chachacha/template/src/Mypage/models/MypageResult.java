package com.example.project_chachacha.template.src.Mypage.models;

import com.google.gson.annotations.SerializedName;

public class MypageResult {

    @SerializedName("name")
    private String name;

    @SerializedName("writing")
    private String writing;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("signuptime")
    private String signuptime;

    public String getName() {
        return name;
    }

    public String getWriting() {
        return writing;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSignuptime() {
        return signuptime;
    }
}
