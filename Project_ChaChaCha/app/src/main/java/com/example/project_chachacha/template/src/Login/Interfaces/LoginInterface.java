package com.example.project_chachacha.template.src.Login.Interfaces;

import com.example.project_chachacha.template.src.Login.models.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterface {

    @POST("/token")
    Call<LoginResponse> PostLogin(@Body RequestBody params);
}
