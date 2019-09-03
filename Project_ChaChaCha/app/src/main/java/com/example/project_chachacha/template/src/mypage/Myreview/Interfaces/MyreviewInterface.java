package com.example.project_chachacha.template.src.mypage.Myreview.Interfaces;

import com.example.project_chachacha.template.src.mypage.Myreview.models.MyreviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyreviewInterface {

    @GET("/user/{userid}/review")
    Call<MyreviewResponse> getMyReview(@Path("userid") String userid);
}
