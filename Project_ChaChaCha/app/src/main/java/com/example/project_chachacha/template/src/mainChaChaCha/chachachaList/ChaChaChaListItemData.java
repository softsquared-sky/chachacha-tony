package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList;

public class ChaChaChaListItemData {

    private String shopName;
    private String mood;
    private String writing;
    private String imgurl;
    private int storenum;

    public ChaChaChaListItemData(String shopName, String mood, String writing, String imgurl, int storenum) {
        this.shopName = shopName;
        this.mood = mood;
        this.writing = writing;
        this.imgurl = imgurl;
        this.storenum = storenum;
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

    public int getStorenum() {
        return storenum;
    }

    public void setStorenum(int storenum) {
        this.storenum = storenum;
    }
}
