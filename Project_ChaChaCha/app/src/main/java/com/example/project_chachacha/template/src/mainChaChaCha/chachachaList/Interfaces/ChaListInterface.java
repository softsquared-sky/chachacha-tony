package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.Interfaces;

import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.models.ChaChaChaListResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ChaListInterface {

    @POST("/stores/recommend")
    Call<ChaChaChaListResponse> postChaList(@Body RequestBody params);
}
