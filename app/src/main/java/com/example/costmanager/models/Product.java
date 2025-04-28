package com.example.costmanager.models;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private String userId;

    public Product(int id, String name, int quantity, String userId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
} 