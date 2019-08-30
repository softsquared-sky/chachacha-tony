package com.example.project_chachacha.template.src.Mypage.Myreview;

public class review_item {
    private int profile;
    private String shopName;
    private String rate;
    private String address;
    private String content;

    public review_item(int profile, String shopName, String rate, String address, String content) {
        this.profile = profile;
        this.shopName = shopName;
        this.rate = rate;
        this.address = address;
        this.content = content;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
