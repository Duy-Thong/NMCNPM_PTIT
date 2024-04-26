package org.example.model;

import java.util.UUID;

public class MatHang96 {
    private String id;
    private String name;
    private float cost;
    private float price;
    private String description;

    public MatHang96() {
        this.id = UUID.randomUUID().toString();
    }
    // Constructor
    public MatHang96(String name, float cost, float price, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
