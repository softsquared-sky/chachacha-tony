package com.example.project_chachacha.template.src.myChaShopDetail.myChaShop.Interfaces;

import com.example.project_chachacha.template.src.myChaShopDetail.myChaShop.models.MyChaShopResult;

public interface MyChaShopView {

    void validateSuccess(int code, MyChaShopResult result);

    void validateFailure(String message);
}
