package com.example.project_chachacha.template.src.shop.shopdetatil.Interfaces;

import com.example.project_chachacha.template.src.shop.shopdetatil.models.ShopDetailResult;

import java.util.List;

public interface ShopDetailView {

    void validateSuccess(int code, String message, List<ShopDetailResult> results);

    void validateFailure(int code, String message);
}
