package com.example.hellotest.entity;

public class Canteen {
    private String titleName;
    private double level;
    private String desc;
    private String imgUrl;

    public Canteen(String titleName, double level, String desc, String imgUrl) {
        this.titleName = titleName;
        this.level = level;
        this.desc = desc;
        this.imgUrl = imgUrl;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
