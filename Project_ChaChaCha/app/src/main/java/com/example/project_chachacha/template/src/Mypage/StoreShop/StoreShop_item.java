package com.example.project_chachacha.template.src.Mypage.StoreShop;

public class StoreShop_item {
    String shopName;
    String mood;

    public StoreShop_item(String shopName, String mood) {
        this.shopName = shopName;
        this.mood = mood;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
