package com.example.Payment.payment.model;

public class CartRequest {
    private String materialId;
    private int quantity;
    private String cartType;

    // Constructors, Getters, and Setters
    public CartRequest() {}

    public CartRequest(String materialId, int quantity, String cartType) {
        this.materialId = materialId;
        this.quantity = quantity;
        this.cartType = cartType;
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

    public String getCartType() {
        return cartType;
    }

    public void setCartType(String cartType) {
        this.cartType = cartType;
    }
}
