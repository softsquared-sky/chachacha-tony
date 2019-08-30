package com.example.project_chachacha.template.src.Login;

import android.util.Log;

import com.example.project_chachacha.template.src.Login.Interfaces.LoginInterface;
import com.example.project_chachacha.template.src.Login.Interfaces.LoginView;
import com.example.project_chachacha.template.src.Login.models.LoginResponse;
import com.google.gson.JsonObject;

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

    LoginService(final LoginView loginView){
        this.mLoginView = loginView;
    }

    void getLogin(String userid, String userpw){
        JSONObject params = new JSONObject();
        try {
            params.put("userid", userid);
            params.put("userpw", userpw);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final LoginInterface mLoginInterface = getRetrofit().create(LoginInterface.class);
        mLoginInterface.PostLogin(RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if(loginResponse==null){
                    mLoginView.validateFailure(0, "response null");

                    return;
                }
                if(loginResponse.getCode()==113){
                    mLoginView.validateSuccess(loginResponse.getCode(), loginResponse.getMessage(), loginResponse.getResult().getJwt());
                }
                else{
                    mLoginView.validateFailure(loginResponse.getCode(), loginResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("tag", "오류", t.getCause());
                t.getCause();
                mLoginView.validateFailure(0, "로그인 response fail");
            }
        });
    }
}
