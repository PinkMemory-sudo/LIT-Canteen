package com.example.canteen.entity;

public class Foods {
    private String imgUrl;
    private String foodName;
    private String foodPrice;
    private String discount;
    private String like;

    public Foods(String imgUrl, String foodName, String foodPrice, String discount, String like) {
        this.imgUrl = imgUrl;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.discount = discount;
        this.like = like;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
