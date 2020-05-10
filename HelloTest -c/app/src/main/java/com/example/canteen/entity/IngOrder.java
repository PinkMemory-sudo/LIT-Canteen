package com.example.canteen.entity;

public class IngOrder {
    private String id;
    private String foodName;
    private String taste;

    public IngOrder(String id, String foodName, String taste) {
        this.id = id;
        this.foodName = foodName;
        this.taste = taste;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
