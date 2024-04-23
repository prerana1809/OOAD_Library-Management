package com.example.Payment.payment.model;

import java.util.ArrayList;
import java.util.List;

 public class Borrower {
    private String id;
    private String name;
    private String password;
    private int accountId;
    private int accountPin;
    private List<Material> currentOrder;
    private List<Material> orderHistory;

    // Constructor
    public Borrower(String id, String name, String password, int accountId, int accountPin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.accountId = accountId;
        this.accountPin = accountPin;
        this.currentOrder = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    // Getters and setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public List<Material> getCurrentOrder() {
        return currentOrder;
    }

    public List<Material> getOrderHistory() {
        return orderHistory;
    }

    public void borrowMat(Material material) {
        currentOrder.add(material);
    }

    public void buyMat(Material material) {
        currentOrder.add(material);
        // Payment logic here
        Payment.processPayment(currentOrder);
    }

    public void returnMat(Material material) {
        currentOrder.remove(material);
        orderHistory.add(material);
    }
    
}
