package com.example.project_chachacha.template.src.Mypage.Interfaces;


import com.example.project_chachacha.template.src.Mypage.models.MypageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MypageInterface {

    @GET("/user/{userid}")
    Call<MypageResponse> getMypage(@Path("userid") String userid);
}
