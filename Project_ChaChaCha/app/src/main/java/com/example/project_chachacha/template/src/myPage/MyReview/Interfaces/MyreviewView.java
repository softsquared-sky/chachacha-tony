package com.example.project_chachacha.template.src.myPage.MyReview.Interfaces;

import com.example.project_chachacha.template.src.myPage.MyReview.models.ResultItem;

import java.util.List;

public interface MyreviewView {
    void validateSuccess(int code, String message, List<ResultItem> resultItems);

    void validateFailure(int code, String message);
}
