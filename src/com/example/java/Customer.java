package com.example.java;

class Customer {
    //create variables to hold the customer name, phone number, address and square footage
    String customerName;
    String customerPhone;
    String customerAddress;
    double squareFootage;

    //method to display basic customer information to be used by the subclasses
    void displayCustomer() {
        System.out.println("\nCustomer Information");
        System.out.println("----------------------");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Address: " + customerAddress);
        System.out.println("Customer Phone: " + customerPhone);
    }
}