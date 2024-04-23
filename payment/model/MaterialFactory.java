package com.example.Payment.payment.model;

public class MaterialFactory {
    public Material createMaterial(String type, String id, String name, String author, int publishingYear, double price, int qty) {
        switch (type.toLowerCase()) {
            case "book":
                return new Book(id, name, author, publishingYear, price, qty);
            case "magazine":
                return new Magazine(id, name, author, publishingYear, price, qty);
            case "journal":
                return new Journal(id, name, author, publishingYear, price, qty);
            case "researchpaper":
                return new ResearchPaper(id, name, author, publishingYear, price, qty);
            default:
                throw new IllegalArgumentException("Invalid material type: " + type);
        }
    }
}
