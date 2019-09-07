package com.example.project_chachacha.template.src.myPage.Search.Interfaces;

import com.example.project_chachacha.template.src.myPage.Search.models.SearchResult;

import java.util.List;

public interface SearchView {

    void validateSuccess(int code, List<SearchResult> result);

    void validateFailure(String msg);
}
