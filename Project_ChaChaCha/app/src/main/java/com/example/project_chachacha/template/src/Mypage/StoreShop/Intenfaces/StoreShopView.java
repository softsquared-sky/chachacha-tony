package com.example.project_chachacha.template.src.Mypage.StoreShop.Intenfaces;

import com.example.project_chachacha.template.src.Mypage.StoreShop.models.ResultStoreShop;

import java.util.List;

public interface StoreShopView {

    void validateSuccess(int code, String message, List<ResultStoreShop> resultItems);

    void validateFailure(int code, String message);
}
