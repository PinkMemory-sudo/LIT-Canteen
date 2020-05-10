package com.example.hellotest.entity;

public class CarOrder {
    private String foodName;
    private double price;
    private String imgUrl;
    private String Date;
    private String taste;

    public CarOrder(String foodName, double price, String imgUrl, String date, String taste) {
        this.foodName = foodName;
        this.price = price;
        this.imgUrl = imgUrl;
        Date = date;
        this.taste = taste;
    }

    public String getFoodName() {
        return foodName;
    }

    @Override
    public String toString() {
        return "CarOrder{" +
                "foodName='" + foodName + '\'' +
                ", price=" + price +
                ", imgUrl='" + imgUrl + '\'' +
                ", Date='" + Date + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
