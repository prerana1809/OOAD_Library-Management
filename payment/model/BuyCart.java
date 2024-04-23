package com.example.Payment.payment.model;

import java.util.ArrayList;
import java.util.List;

public class BuyCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        this.items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }
}