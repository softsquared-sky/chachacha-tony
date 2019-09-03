package com.example.project_chachacha.template.src.shopInfo.ShopMenu.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuResult {

    @SerializedName("food")
    private List<food> foodList=null;

    @SerializedName("drink")
    private List<food> drinkList = null;

    public List<food> getFoodList() {
        return foodList;
    }

    public List<food> getDrinkList() {
        return drinkList;
    }
}
