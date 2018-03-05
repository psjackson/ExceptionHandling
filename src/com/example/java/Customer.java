package com.example.java;

/**
 * Customer class, a superclass of Commercial and Residential subclasses
 */
class Customer {
    /**
     * customerName Variable to hold the customers name
     * customerPhone Variable to hold the customers phone number
     * customerAddress Variable to hold the customers address
     * squareFootage Variable to hold the total area to be mowed
     */
    String customerName;
    String customerPhone;
    String customerAddress;
    double squareFootage;

    /**
     * displayCustomer method to display the common customer information to the user
     */
    void displayCustomer() {
        System.out.println("\nCustomer Information");
        System.out.println("----------------------");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Address: " + customerAddress);
        System.out.println("Customer Phone: " + customerPhone);
    }
}