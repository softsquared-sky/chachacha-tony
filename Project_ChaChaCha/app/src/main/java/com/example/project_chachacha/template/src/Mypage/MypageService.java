package com.example.project_chachacha.template.src.Mypage;

import android.util.Log;

import com.example.project_chachacha.template.config.XAccessTokenInterceptor;
import com.example.project_chachacha.template.src.Mypage.Interfaces.MypageInterface;
import com.example.project_chachacha.template.src.Mypage.Interfaces.MypageView;
import com.example.project_chachacha.template.src.Mypage.models.MypageResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class MypageService {

    private final MypageView mMypageView;

    MypageService(MypageView mypageView){
        this.mMypageView = mypageView;
    }

    void getMypage(String userid){
        System.out.println("실행?");
        final MypageInterface mypageInterface = getRetrofitToken().create(MypageInterface.class);
        mypageInterface.getMypage(userid).enqueue(new Callback<MypageResponse>() {
            @Override
            public void onResponse(Call<MypageResponse> call, Response<MypageResponse> response) {
                final MypageResponse mypageResponse = response.body();
                if(mypageResponse==null){
                    mMypageView.validateFailure(0, "response null");
                    return;
                }
                mMypageView.validateSuccess(mypageResponse.getCode(),mypageResponse.getMessage(),
                        mypageResponse.getResult().getName(),
                        mypageResponse.getResult().getWriting(),
                        mypageResponse.getResult().getEmail(),
                        mypageResponse.getResult().getPhone(),
                        mypageResponse.getResult().getSignuptime());
            }

            @Override
            public void onFailure(Call<MypageResponse> call, Throwable t) {
                Log.d("tag", "오류", t.getCause());
                mMypageView.validateFailure(0, "response fail");
            }
        });
    }
}
