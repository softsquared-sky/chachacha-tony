package com.example.project_chachacha.template.src.shop.Interfaces;

import com.example.project_chachacha.template.src.shop.models.ShopChaChaChaResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ShopChaChaChaInterface {

    @POST("/user/{userid}/store")
    Call<ShopChaChaChaResponse> postSaveMyChaChaCha(@Path("userid") String userid, @Body RequestBody params);
}
