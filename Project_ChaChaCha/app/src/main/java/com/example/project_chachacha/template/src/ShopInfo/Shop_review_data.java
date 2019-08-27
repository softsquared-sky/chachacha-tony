package com.example.project_chachacha.template.src.ShopInfo;

public class Shop_review_data {
    private String name;
    private String rate;
    private String content;

    public Shop_review_data(String name, String rate, String content) {
        this.name = name;
        this.rate = rate;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
