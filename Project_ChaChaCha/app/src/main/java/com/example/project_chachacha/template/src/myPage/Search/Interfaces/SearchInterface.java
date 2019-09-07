package com.example.project_chachacha.template.src.myPage.Search.Interfaces;

import com.example.project_chachacha.template.src.myPage.Search.models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchInterface {

    @GET("/stores/search")
    Call<SearchResponse> getSearch(@Query("storeName") String storeName, @Query("page") int page, @Query("size") int size);
}
