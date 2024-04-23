package com.example.Payment.payment.model;

import java.util.Date;
import java.util.List;

// Interface for Transactions
interface Transaction {
    double calculateTotal();
    List<String> getMaterials();
    void setMaterials(List<String> materials);
    Date getTransactionDate();
    void setTransactionDate(Date transactionDate);
    String getCustomerName();
    void setCustomerName(String customerName);
}

// Class for Buying materials
class Buy implements Transaction {
    private List<String> materials;
    private Date transactionDate;
    private String customerName;
    private double totalPrice;

    public Buy(List<String> materials, Date transactionDate, String customerName, double totalPrice) {
        this.materials = materials;
        this.transactionDate = transactionDate;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public double calculateTotal() {
        return totalPrice;
    }

    @Override
    public List<String> getMaterials() {
        return materials;
    }

    @Override
    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    @Override
    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

// Class for Borrowing materials
class Borrow implements Transaction {
    private List<String> materials;
    private Date transactionDate;
    private String customerName;
    private Date dueDate;

    public Borrow(List<String> materials, Date transactionDate, String customerName, Date dueDate) {
        this.materials = materials;
        this.transactionDate = transactionDate;
        this.customerName = customerName;
        this.dueDate = dueDate;
    }

    @Override
    public double calculateTotal() {
        return 0; // No initial charge for borrowing
    }

    @Override
    public List<String> getMaterials() {
        return materials;
    }

    @Override
    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    @Override
    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

// Class for Returning materials
class Return {
    private Borrow originalBorrow;
    private Date returnDate;
    private double lateFee;

    public Return(Borrow originalBorrow, Date returnDate, double lateFee) {
        this.originalBorrow = originalBorrow;
        this.returnDate = returnDate;
        this.lateFee = lateFee;
    }

    public double calculateFee() {
        if (returnDate.after(originalBorrow.getDueDate())) {
            return lateFee;
        }
        return 0;
    }

    public Borrow getOriginalBorrow() {
        return originalBorrow;
    }

    public void setOriginalBorrow(Borrow originalBorrow) {
        this.originalBorrow = originalBorrow;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }
}

