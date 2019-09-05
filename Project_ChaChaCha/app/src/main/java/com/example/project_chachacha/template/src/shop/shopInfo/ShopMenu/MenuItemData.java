package com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu;

public class MenuItemData {

    private String foodName;
    private String price;

    public MenuItemData(String foodName, String price) {
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
