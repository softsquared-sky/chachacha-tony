package com.example.project_chachacha.template.src.myPage.StoreShop;

public class StoreShopItemData {
    String shopName;
    String mood;
    String writing;
    String imgurl;

    public StoreShopItemData(String shopName, String mood, String writing, String imgurl) {
        this.shopName = shopName;
        this.mood = mood;
        this.writing = writing;
        this.imgurl = imgurl;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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
