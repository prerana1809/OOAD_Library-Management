package com.example.Payment.payment.model;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Date;

public interface Material {
    String getId();
    void setId(String id);
    String getName();
    void setName(String name);
    String getAuthor();
    void setAuthor(String author);
    int getPublishingYear();
    void setPublishingYear(int publishingYear);
    double getPrice();
    void setPrice(double price);
    int getQty();
    void setQty(int qty);
}

class Book implements Material {
    private String id;
    private String name;
    private String author;
    private int publishingYear;
    private double price;
    private int qty;

    public Book(String id, String name, String author, int publishingYear, double price, int qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.price = price;
        this.qty = qty;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAuthor() {
        return author;
    }
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public int getPublishingYear() {
        return publishingYear;
    }
    @Override
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public int getQty() {
        return qty;
    }
    @Override
    public void setQty(int qty) {
        this.qty = qty;
    }
}

class Magazine implements Material {
    private String id;
    private String name;
    private String author;
    private int publishingYear;
    private double price;
    private int qty;

    public Magazine(String id, String name, String author, int publishingYear, double price, int qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.price = price;
        this.qty = qty;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAuthor() {
        return author;
    }
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public int getPublishingYear() {
        return publishingYear;
    }
    @Override
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public int getQty() {
        return qty;
    }
    @Override
    public void setQty(int qty) {
        this.qty = qty;
    }
}

class Journal implements Material {
    private String id;
    private String name;
    private String author;
    private int publishingYear;
    private double price;
    private int qty;

    public Journal(String id, String name, String author, int publishingYear, double price, int qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAuthor() {
        return author;
    }
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public int getPublishingYear() {
        return publishingYear;
    }
    @Override
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
    @Override
    public double getPrice() {
        //System.out.println("journals are free!");
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = 0.0;
    }
    @Override
    public int getQty() {
        return qty;
    }
    @Override
    public void setQty(int qty) {
        this.qty = qty;
    }
}

class ResearchPaper implements Material {
    private String id;
    private String name;
    private String author;
    private int publishingYear;
    private double price;
    private int qty;

    public ResearchPaper(String id, String name, String author, int publishingYear, double price, int qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAuthor() {
        return author;
    }
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public int getPublishingYear() {
        return publishingYear;
    }
    @Override
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
    @Override
    public double getPrice() {
        System.out.println("research papers are free!");
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = 0.0;
    }
    @Override
    public int getQty() {
        return qty;
    }
    @Override
    public void setQty(int qty) {
        this.qty = 1;
    }
}

// class MaterialFactory {
//     public Material createMaterial(String type, String id, String name, String author, int publishingYear, double price, int qty) {
//         switch (type.toLowerCase()) {
//             case "book":
//                 return new Book(id, name, author, publishingYear, price, qty);
//             case "magazine":
//                 return new Magazine(id, name, author, publishingYear, price, qty);
//             case "journal":
//                 return new Journal(id, name, author, publishingYear, price, qty);
//             case "researchpaper":
//                 return new ResearchPaper(id, name, author, publishingYear, price, qty);
//             default:
//                 throw new IllegalArgumentException("Invalid material type: " + type);
//         }
//     }
// }


