package com.example.project_chachacha.template.src.Splash;

import com.example.project_chachacha.template.src.Splash.Interfaces.SplashInterface;
import com.example.project_chachacha.template.src.Splash.Interfaces.SplashView;
import com.example.project_chachacha.template.src.Splash.models.SplashResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

class SplashService {

    private final SplashView mSplashView;

    SplashService(SplashView splashView){
        this.mSplashView = splashView;
    }

    void getCheckToken(String userId){
        final SplashInterface splashInterface = getRetrofitToken().create(SplashInterface.class);
        splashInterface.getCheckJwt(userId).enqueue(new Callback<SplashResponse>() {
            @Override
            public void onResponse(@NotNull Call<SplashResponse> call, @NotNull Response<SplashResponse> response) {
                final SplashResponse splashResponse = response.body();
                if(splashResponse==null){
                    mSplashView.validateFailure(0);
                    return;
                }

                if(splashResponse.getCode()==115){
                    mSplashView.validateSuccess(115);
                }
                else{
                    mSplashView.validateFailure(201);
                }
            }

            @Override
            public void onFailure(@NotNull Call<SplashResponse> call, @NotNull Throwable t) {
                mSplashView.validateFailure(0);
            }
        });
    }
}
