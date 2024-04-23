package com.example.Payment.payment.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Payment.payment.model.BorrowCart;
import com.example.Payment.payment.model.Borrower;
import com.example.Payment.payment.model.BuyCart;
import com.example.Payment.payment.model.CartItem;
import com.example.Payment.payment.model.Librarian;
import com.example.Payment.payment.model.Material;
import com.example.Payment.payment.model.MaterialFactory;
import com.example.Payment.payment.service.CartService;


@RestController
public class LibraryController {
    private CartService cartService = new CartService();
    private BorrowCart borrowCart = new BorrowCart();
    private BuyCart buyCart = new BuyCart();
    private CartItem cartItem = new CartItem();
    private static List<Material> books = new ArrayList<>();
    private static List<Material> journals = new ArrayList<>();
    private static List<Material> magazines = new ArrayList<>();

    private static List<Borrower> borrowers = new ArrayList<>();
    private static List<Librarian> librarians = new ArrayList<>();

    // Constructor
    public LibraryController(CartService cartService) {
        this.cartService = new CartService();
        this.borrowCart = new BorrowCart();
        this.buyCart = new BuyCart();
        this.cartItem = null;
        // Initialize data
        initializeData();
    }
    
    // Method to initialize data
    // @GetMapping("/")
    private void initializeData() {
        // Sample books
        MaterialFactory materialFactory = new MaterialFactory();
        Material book1 = materialFactory.createMaterial("book", "978-3-16-148410-0", "Introduction to Computer Science", "David J. Malan", 2019, 45.99, 15);
        Material book2 = materialFactory.createMaterial("book", "978-3-16-148410-1", "Fundamentals of Mathematics", "James Stewart", 2015, 55.50, 20);
        Material book3 = materialFactory.createMaterial("book", "978-3-16-148410-2", "An Introduction to Programming with C++", "Diane Zak", 2018, 38.75, 30);
        Material book4 = materialFactory.createMaterial("book", "978-3-16-148410-3", "Data Structures and Algorithm Analysis in Java", "Mark Allen Weiss", 2017, 60.25, 25);
        Material book5 = materialFactory.createMaterial("book", "978-3-16-148410-4", "Principles of Physics", "David Halliday, Robert Resnick, Jearl Walker", 2018, 75.00, 18);
        Material journal1 = materialFactory.createMaterial("journal", "978-3-16-148410-5", "Journal of Applied Physics", "American Institute of Physics", 2021, 20.99, 10);
        Material journal2 = materialFactory.createMaterial("journal", "978-3-16-148410-6", "Journal of Chemical Education", "American Chemical Society", 2021, 18.99, 15);
        Material magazine1 = materialFactory.createMaterial("magazine", "978-3-16-148410-7", "IEEE Spectrum", "IEEE", 2021, 10.99, 25);
        Material magazine2 = materialFactory.createMaterial("magazine", "978-3-16-148410-8", "National Academy of Sciences", "National Academy of Sciences", 2021, 12.99, 30);
        Material journal3 = materialFactory.createMaterial("journal", "978-3-16-148410-9", "Nature", "Nature Publishing Group", 2021, 25.99, 8);
        Material journal4 = materialFactory.createMaterial("journal", "978-3-16-148410-10", "Science", "American Association for the Advancement of Science", 2021, 23.99, 12);
        Material journal5 = materialFactory.createMaterial("journal", "978-3-16-148410-11", "The New England Journal of Medicine", "Massachusetts Medical Society", 2021, 27.99, 7);

        Material magazine3 = materialFactory.createMaterial("magazine", "978-3-16-148410-12", "National Geographic", "National Geographic Society", 2021, 15.99, 20);
        Material magazine4 = materialFactory.createMaterial("magazine", "978-3-16-148410-13", "Time", "Time USA, LLC", 2021, 8.99, 35);
        Material magazine5 = materialFactory.createMaterial("magazine", "978-3-16-148410-14", "The Economist", "The Economist Newspaper Limited", 2021, 12.99, 25);

        // Sample borrower and librarian
        Borrower borrower = new Borrower("B001", "John Doe", "password", 1001, 1234);
        Librarian librarian = new Librarian("L001", "Jane Smith", "password");

        // Add books, borrowers, and librarians to lists
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        journals.add(journal1);
        journals.add(journal2);
        journals.add(journal3);
        journals.add(journal4);
        journals.add(journal5);
        magazines.add(magazine1);
        magazines.add(magazine2);
        magazines.add(magazine3);
        magazines.add(magazine4);
        magazines.add(magazine5);

        borrowers.add(borrower);
        librarians.add(librarian);

        // Borrow books
        borrowMaterial(borrower, book1);
        borrowMaterial(borrower, journal1);

        // Return material
        returnMaterial(borrower, book1);

        // Buy material
        buyMaterial(borrower, magazine1);

        // Simulate overdue return
        checkReturnDate(librarian, borrower, new Date(), new Date(System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000)); // 10 days overdue

        // Process payment for the current order
        double totalAmount = calculateTotalAmount(borrower.getCurrentOrder());
        processPayment(totalAmount);
    }
    @GetMapping("/materials")
    public List<Material> getMaterials() {
        List<Material> allMaterials = new ArrayList<>();
        allMaterials.addAll(books);
        allMaterials.addAll(journals);
        allMaterials.addAll(magazines);
        return allMaterials;
    }
    // Method to borrow a material
    private static void borrowMaterial(Borrower borrower, Material material) {
        borrower.borrowMat(material);
        int currqty=material.getQty();
        material.setQty(currqty-1);
        if ((currqty-1) <= 0) {
            material.setQty(15);
        }
        System.out.println(borrower.getName() + " borrowed " + material.getName());
        System.out.println("qty=" + material.getQty());

    }

    // Method to return a material
    private static void returnMaterial(Borrower borrower, Material material) {
        borrower.returnMat(material);
        System.out.println(borrower.getName() + " returned " + material.getName());
    }

    // Method to buy a material
    private static void buyMaterial(Borrower borrower, Material material) {
        borrower.buyMat(material);
        int currqty=material.getQty();
        material.setQty(currqty-1);
        if ((currqty-1) <= 0) {
            material.setQty(15);
        }
        System.out.println(borrower.getName() + " bought " + material.getName());
        System.out.println("qty=" + material.getQty());
    }

    @PostMapping("/cart/borrow")
    public ResponseEntity<String> addToBorrowCart(@RequestBody CartItem cartItem) {
        // System.out.println(cartItem.getMaterialId()+ "helllll");
        if (cartService.addToBorrowCart(cartItem)) {
            return ResponseEntity.ok("Item successfully added to the borrow cart");
        } else {
            return ResponseEntity.badRequest().body("Failed to add item to borrow cart");
        }
    }

    @PostMapping("/cart/buy")
    public ResponseEntity<String> addToBuyCart(@RequestBody CartAdditionRequest request) {
        if (cartService.addToBuyCart(buyCart, cartItem)) {
            return ResponseEntity.ok("Item successfully added to the buy cart");
        } else {
            return ResponseEntity.badRequest().body("Failed to add item to buy cart");
        }
    }


    @GetMapping("/cart/borrow")
    public ResponseEntity<List<CartItem>> getBorrowCartItems() {
        List<CartItem> items = cartService.getBorrowCartItems();
        System.out.println(items);
        if (items != null) {
            return ResponseEntity.ok(items);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/cart/buy")
    public ResponseEntity<List<CartItem>> getBuyCartItems() {
        List<CartItem> items = cartService.getBuyCartItems();
        System.out.println(items);
        if (items != null) {
            return ResponseEntity.ok(items);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    static class CartAdditionRequest {
        private String materialId;
        private int quantity;

        // Getters and setters
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

    // Method to check return date and apply fines if necessary
    private static void checkReturnDate(Librarian librarian, Borrower borrower, Date currentDate, Date returnDate) {
        if (returnDate.after(currentDate)) {
            double fine = calculateFine(returnDate, currentDate);
            System.out.println("Fine applied: " + fine);
            // Logic to apply fine to the borrower's account
        }
    }

    // Method to calculate fine based on overdue days
    private static double calculateFine(Date returnDate, Date currentDate) {
        long diffInMillis = currentDate.getTime() - returnDate.getTime();
        long diffInDays = diffInMillis / (24 * 60 * 60 * 1000);
        return diffInDays * 5; // Assuming $5 fine per day
    }

    // Method to calculate total amount for the current order
    private static double calculateTotalAmount(List<Material> order) {
        double totalAmount = 0;
        for (Material material : order) {
            totalAmount += material.getPrice();
        }
        return totalAmount;
    }

    // Method to process payment
    private static void processPayment(double amount) {
        System.out.println("Total Amount: " + amount);
        System.out.println("Payment done."); // Dummy message
    }
}
