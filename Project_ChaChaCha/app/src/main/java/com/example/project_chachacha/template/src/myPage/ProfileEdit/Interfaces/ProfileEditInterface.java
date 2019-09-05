package com.example.project_chachacha.template.src.myPage.ProfileEdit.Interfaces;

import com.example.project_chachacha.template.src.myPage.ProfileEdit.models.ProfileEditResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface ProfileEditInterface {

    @PATCH("/user/{userid}")
    Call<ProfileEditResponse> patchprofile(@Path ("userid") String userid, @Body RequestBody params);
}
