package com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu;

import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.Interfaces.MenuInterface;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.Interfaces.MenuView;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.models.MenuResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

class MenuService {

    private final MenuView mMenuView;

    MenuService(MenuView menuView){
        this.mMenuView = menuView;
    }

    void getShopMenu(int storeNum){
        final MenuInterface menuInterface = getRetrofitToken().create(MenuInterface.class);
        menuInterface.getShopMenu(storeNum).enqueue(new Callback<MenuResponse>() {
            @Override
            public void onResponse(Call<MenuResponse> call, Response<MenuResponse> response) {
                final MenuResponse menuResponse = response.body();
                if(menuResponse==null){
                    mMenuView.validateFailure("응답 null");
                    return;
                }

                mMenuView.validateSuccess(menuResponse.getCode(), menuResponse.getResult());
            }

            @Override
            public void onFailure(Call<MenuResponse> call, Throwable t) {
                mMenuView.validateFailure("응답 fail");
            }
        });
    }
}
