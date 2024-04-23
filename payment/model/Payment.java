package com.example.Payment.payment.model;

import java.util.Iterator;
import java.util.List;

public class Payment {
    public static void processPayment(List<Material> order) {
        double grandTotal = calculateGrandTotal(order.iterator());
        System.out.println("Grand Total: " + grandTotal);
        System.out.println("Payment done."); // Dummy message
    }

    private static double calculateGrandTotal(Iterator<Material> iterator) {
        double grandTotal = 0;
        while (iterator.hasNext()) {
            Material material = iterator.next();
            grandTotal += material.getPrice();
        }
        return grandTotal;
    }

    public static void processFine(Borrower borrower, double fine) {
        // Display fine amount and pay button (frontend logic)
        System.out.println("Fine amount: " + fine);
        System.out.println("Payment done."); // Dummy message
    }
}
