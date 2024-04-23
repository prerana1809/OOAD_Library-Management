package com.example.Payment.payment.model;

import java.sql.Date;

public class Librarian {
    // encapsulation (private attributes, public methods for accessing them)
    private String id;
    private String name;
    // private String contact;
    private String password;

    public Librarian(String id, String name, String password) {
        this.id = id;
        this.name = name;
        // this.contact = contact;
        this.password = password;
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
    // public String getContact() {
    //     return contact;
    // }
    // public void setContact(String contact) {
    //     this.contact = contact;
    // }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void checkReturnDate(Date returnDate, Date dueDate) {
        if (returnDate.after(dueDate)) {
            Payment payment = new Payment();
            payment.processFine(null, 0);//borrower details
        }
    }

    public void restock(Material material) {
        int currentQty = material.getQty();
        if (currentQty == 0) {
            material.setQty(15);
        }
    }
}