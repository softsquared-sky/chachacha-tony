package com.example.project_chachacha.template.src.myPage.MyChaChaCha;

public class MyChaChaChaItemData {

    private int chanum;
    private String imgurl;
    private String shopName;

    public MyChaChaChaItemData(int chanum, String imgurl, String shopName) {
        this.chanum = chanum;
        this.imgurl = imgurl;
        this.shopName = shopName;
    }

    public int getChanum() {
        return chanum;
    }

    public void setChanum(int chanum) {
        this.chanum = chanum;
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
}
