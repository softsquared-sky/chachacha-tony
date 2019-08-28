package com.example.project_chachacha.template.src.Register.Interfaces;

import com.example.project_chachacha.template.src.Register.models.RegisterResponse;
import com.example.project_chachacha.template.src.Register.models.Register_boss_data;
import com.example.project_chachacha.template.src.Register.models.Register_customer_data;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Register_interface {

    @POST("/guest")
    Call<RegisterResponse> post_register_customer(@Body RequestBody params);

    @POST("/boss")
    Call<RegisterResponse> post_register_boss(@Body RequestBody params);
}