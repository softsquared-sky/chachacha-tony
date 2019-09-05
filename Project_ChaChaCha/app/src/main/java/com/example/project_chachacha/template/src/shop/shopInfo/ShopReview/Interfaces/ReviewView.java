package com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.Interfaces;

import com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.models.ReviewResult;

public interface ReviewView {

    void validateSuccess(int code, String message, ReviewResult reviewResult);

    void validateFailure(String message);
}
