package com.example.project_chachacha.template.src.Shopdetatil.Interfaces;

import com.example.project_chachacha.template.src.Shopdetatil.models.ShopDetailResult;

import java.util.List;

public interface ShopDetailView {

    void validateSuccess(int code, String message, List<ShopDetailResult> results);

    void validateFailure(int code, String message);
}
