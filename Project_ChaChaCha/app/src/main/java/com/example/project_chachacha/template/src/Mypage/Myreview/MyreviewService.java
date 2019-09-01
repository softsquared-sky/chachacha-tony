package com.example.project_chachacha.template.src.Mypage.Myreview;

import com.example.project_chachacha.template.src.Mypage.Myreview.Interfaces.MyreviewInterface;
import com.example.project_chachacha.template.src.Mypage.Myreview.Interfaces.MyreviewView;
import com.example.project_chachacha.template.src.Mypage.Myreview.models.MyreviewResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class MyreviewService {

    private final MyreviewView mMyreviewView;

    MyreviewService(MyreviewView myreviewView){
        this.mMyreviewView = myreviewView;
    }

    void getUserReview(String userid){
        final MyreviewInterface myreviewInterface = getRetrofitToken().create(MyreviewInterface.class);
        myreviewInterface.getMyReview(userid).enqueue(new Callback<MyreviewResponse>() {
            @Override
            public void onResponse(@NotNull Call<MyreviewResponse> call, @NotNull Response<MyreviewResponse> response) {
                final MyreviewResponse myreviewResponse = response.body();
                if(myreviewResponse==null){
                    mMyreviewView.validateFailure(0,"응답 null");
                    return;
                }

                mMyreviewView.validateSuccess(myreviewResponse.getCode(),myreviewResponse.getMessage(),myreviewResponse.getResultItemList());
            }

            @Override
            public void onFailure(@NotNull Call<MyreviewResponse> call, @NotNull Throwable t) {
                mMyreviewView.validateFailure(0,"응답 fail");
            }
        });
    }
}
