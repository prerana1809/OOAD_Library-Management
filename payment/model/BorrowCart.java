package com.example.Payment.payment.model;

import java.util.ArrayList;
import java.util.List;

public class BorrowCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        System.out.println(item+"additem");
        this.items.add(item);
    }

    public List<CartItem> getItems() {
        System.out.println(items+ "getitem");
        return this.items;
    }
}