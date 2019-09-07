package com.example.project_chachacha.template.src.myPage.MyChaChaCha;

public class MyChaChaChaItemData {

    private int chanum;
    private int storenum;
    private String imgurl;
    private String shopName;

    public MyChaChaChaItemData(int chanum, int storenum, String imgurl, String shopName) {
        this.chanum = chanum;
        this.storenum = storenum;
        this.imgurl = imgurl;
        this.shopName = shopName;
    }

    public void setStorenum(int storenum) {
        this.storenum = storenum;
    }

    public int getStorenum() {
        return storenum;
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
