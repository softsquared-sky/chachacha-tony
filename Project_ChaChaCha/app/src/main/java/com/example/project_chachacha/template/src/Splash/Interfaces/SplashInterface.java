package com.example.project_chachacha.template.src.Splash.Interfaces;

import com.example.project_chachacha.template.src.Splash.models.SplashResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SplashInterface {

    @GET("/user/{userid}")
    Call<SplashResponse> getCheckJwt(@Path("userid") String userid);
}
