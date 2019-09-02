package com.example.project_chachacha.template.src.Mypage.MyChaChaCha;

public class MyChaChaChaItemData {

    private String imgurl;
    private String shopName;

    public MyChaChaChaItemData(String imgurl, String shopName) {
        this.imgurl = imgurl;
        this.shopName = shopName;
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
