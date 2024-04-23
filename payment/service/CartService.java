package com.example.Payment.payment.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Payment.payment.model.BorrowCart;
import com.example.Payment.payment.model.BuyCart;
import com.example.Payment.payment.model.CartItem;

@Service
public class CartService {
    BorrowCart borrowCart = new BorrowCart();
    BuyCart buyCart = new BuyCart();

    public boolean addToBorrowCart(CartItem item) {
        System.out.println(item+"cart");
        this.borrowCart.addItem(item);
        return true ;
    }

    public boolean addToBuyCart(BuyCart buyCart, CartItem item) {
        buyCart.addItem(item);
        return true;
    }
    public List<CartItem> getBorrowCartItems() {
        System.out.println(borrowCart.getItems());
        return this.borrowCart.getItems();
         // Assuming there's a getItems method returning List<CartItem>
    }
    public List<CartItem> getBuyCartItems() {
        System.out.println(buyCart.getItems());
        return this.buyCart.getItems();
         // Assuming there's a getItems method returning List<CartItem>
    }
}