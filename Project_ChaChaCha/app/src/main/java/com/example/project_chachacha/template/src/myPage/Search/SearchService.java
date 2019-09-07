package com.example.project_chachacha.template.src.myPage.Search;

import com.example.project_chachacha.template.src.myPage.Search.Interfaces.SearchInterface;
import com.example.project_chachacha.template.src.myPage.Search.Interfaces.SearchView;
import com.example.project_chachacha.template.src.myPage.Search.models.SearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class SearchService {

    private final SearchView mSearchView;

    SearchService(SearchView searchView){
        this.mSearchView = searchView;
    }

    void getSearch(String storeName, int page, int size){
        final SearchInterface searchInterface = getRetrofitToken().create(SearchInterface.class);
        searchInterface.getSearch(storeName,page,size).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                final SearchResponse searchResponse = response.body();
                if(searchResponse==null){
                    mSearchView.validateFailure("서버가 응답하지 않습니다.");
                    return;
                }

                mSearchView.validateSuccess(searchResponse.getCode(), searchResponse.getResult());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                mSearchView.validateFailure("서버가 응답하지 않습니다.");
            }
        });
    }
}
