package com.example.project_chachacha.template.src.Mypage.MypageMain.Interfaces;


import com.example.project_chachacha.template.src.Mypage.MypageMain.models.MypageMainResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MypageMainInterface {

    @GET("/user/{userid}")
    Call<MypageMainResponse> getMypage(@Path("userid") String userid);
}
