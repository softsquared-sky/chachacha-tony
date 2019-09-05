package com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.Interfaces;

import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.models.MenuResult;

public interface MenuView {

    void validateSuccess(int code, MenuResult menuResult);

    void validateFailure(String message);
}
