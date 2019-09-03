package com.example.project_chachacha.template.src.shopInfo.ShopMenu.Interfaces;

import com.example.project_chachacha.template.src.shopInfo.ShopMenu.models.MenuResult;

public interface MenuView {

    void validateSuccess(int code, MenuResult menuResult);

    void validateFailure(String message);
}
