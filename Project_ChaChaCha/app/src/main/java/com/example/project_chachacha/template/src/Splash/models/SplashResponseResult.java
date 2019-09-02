package com.example.project_chachacha.template.src.Splash.models;

import com.google.gson.annotations.SerializedName;

public class SplashResponseResult {

    @SerializedName("name")
    private String name;

    @SerializedName("tvWriting")
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
