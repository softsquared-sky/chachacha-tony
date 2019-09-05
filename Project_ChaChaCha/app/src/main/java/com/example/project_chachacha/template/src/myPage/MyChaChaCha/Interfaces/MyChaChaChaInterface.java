package com.example.project_chachacha.template.src.myPage.MyChaChaCha.Interfaces;

import com.example.project_chachacha.template.src.myPage.MyChaChaCha.models.MyChaChaChaDeleteResponse;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.models.MyChaChaChaResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyChaChaChaInterface {

    @GET("/user/{userid}/store")
    Call<MyChaChaChaResponse> getMyChaChaCha(@Path("userid") String userid);

    @DELETE("/user/{userid}/store/{chaNum}")
    Call<MyChaChaChaDeleteResponse> deleteMyChaChaCha(@Path("userid") String userid, @Path("chaNum") int chaNum);
}
