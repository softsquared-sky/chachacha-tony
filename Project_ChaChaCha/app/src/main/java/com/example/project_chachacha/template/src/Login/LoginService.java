package com.example.project_chachacha.template.src.Login;

import android.util.Log;

import com.example.project_chachacha.template.src.Login.Interfaces.LoginInterface;
import com.example.project_chachacha.template.src.Login.Interfaces.LoginView;
import com.example.project_chachacha.template.src.Login.models.LoginResponse;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofit;

public class LoginService {

    private final LoginView mLoginView;

    LoginService(final LoginView loginView) {
        this.mLoginView = loginView;
    }

    void postLogin(String userid, String userpw) {
        JSONObject params = new JSONObject();
        try {
            params.put("userid", userid);
            params.put("userpw", userpw);
        } catch (JSONException e) {
            mLoginView.validateFailure(-1, "ID와 비밀번호를 올바르게 입력해주세요.");
            return;
        }

        final LoginInterface mLoginInterface = getRetrofit().create(LoginInterface.class);
        mLoginInterface.postLogin(RequestBody.create(params.toString(), MEDIA_TYPE_JSON)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if (loginResponse == null) {
                    mLoginView.validateFailure(0, "response null");

                    return;
                }
                if (loginResponse.getCode() == 113) {
                    mLoginView.validateSuccess(loginResponse.getCode(), loginResponse.getMessage(), loginResponse.getResult().getJwt());
                } else {
                    mLoginView.validateFailure(loginResponse.getCode(), loginResponse.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {
                Log.d("tag", "오류", t.getCause());
                t.getCause();
                mLoginView.validateFailure(0, "로그인 response fail");
            }
        });
    }
}
