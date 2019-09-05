package com.example.project_chachacha.template.src.myChaShopDetail.MyChaShop.Interfaces;

import com.example.project_chachacha.template.src.myChaShopDetail.MyChaShop.models.MyChaShopResult;

public interface MyChaShopView {

    void validateSuccess(int code, MyChaShopResult result);

    void validateFailure(String message);
}
