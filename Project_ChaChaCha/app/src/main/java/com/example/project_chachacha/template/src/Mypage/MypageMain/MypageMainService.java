package com.example.project_chachacha.template.src.Mypage.MypageMain;

import android.util.Log;

import com.example.project_chachacha.template.src.Mypage.MypageMain.Interfaces.MypageMainInterface;
import com.example.project_chachacha.template.src.Mypage.MypageMain.Interfaces.MypageMainView;
import com.example.project_chachacha.template.src.Mypage.MypageMain.models.MypageMainResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

class MypageMainService {

    private final MypageMainView mMypageMainView;

    MypageMainService(MypageMainView mypageMainView) {
        this.mMypageMainView = mypageMainView;
    }

    void getMypage(String userid) {
        System.out.println("실행?");
        final MypageMainInterface mypageMainInterface = getRetrofitToken().create(MypageMainInterface.class);
        mypageMainInterface.getMypage(userid).enqueue(new Callback<MypageMainResponse>() {
            @Override
            public void onResponse(@NotNull Call<MypageMainResponse> call, @NotNull Response<MypageMainResponse> response) {
                final MypageMainResponse mypageMainResponse = response.body();
                if (mypageMainResponse == null) {
                    mMypageMainView.validateFailure(0, "response null");
                    return;
                }
                mMypageMainView.validateSuccess(mypageMainResponse.getCode(), mypageMainResponse.getMessage(),
                        mypageMainResponse.getResult().getName(),
                        mypageMainResponse.getResult().getWriting(),
                        mypageMainResponse.getResult().getEmail(),
                        mypageMainResponse.getResult().getPhone(),
                        mypageMainResponse.getResult().getSignuptime());
            }

            @Override
            public void onFailure(@NotNull Call<MypageMainResponse> call, @NotNull Throwable t) {
                Log.d("tag", "오류", t.getCause());
                mMypageMainView.validateFailure(0, "response fail");
            }
        });
    }
}
