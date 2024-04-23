package com.example.Payment.payment.model;

public class CartItem {
    private String materialId;
    private int quantity;

    public CartItem()
    {}
    // Constructor, getters, and setters
    public CartItem(String materialId, int quantity) {
        this.materialId = materialId;
        this.quantity = quantity;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
}
}