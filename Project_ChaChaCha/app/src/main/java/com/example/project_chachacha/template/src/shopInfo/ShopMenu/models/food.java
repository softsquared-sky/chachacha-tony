package com.example.project_chachacha.template.src.shopInfo.ShopMenu.models;

import com.google.gson.annotations.SerializedName;

public class food {

    @SerializedName("menuname")
    private String menuname;

    @SerializedName("menuprice")
    private String menuprice;

    public String getMenuname() {
        return menuname;
    }

    public String getMenuprice() {
        return menuprice;
    }
}
