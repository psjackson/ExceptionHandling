package com.example.java;

import java.text.NumberFormat;

/**
 * Commercial class that is a sub class of Customer
 */
public class Commercial extends Customer{
    /**
     * propertyName Variable to hold the name of the customers property
     * multiProperty Variable to hold if the customer is entitled to a discount for owning multiple properties
     */
    private String propertyName;
    private boolean multiProperty;

    /**
     * constructor method to collect the passed arguments and save them as variables
     * @param customerName Variable to hold the customers name
     * @param customerAddress Variable to hold the customers address
     * @param customerPhone Variable to hold the customers phone number
     * @param squareFootage Variable to hold the area to be mowed
     * @param propertyName Variable to hold the name of the property
     * @param multiProperty Variable to hold if a multi property discount is applicable
     */
    Commercial(String customerName, String customerAddress, String customerPhone, double squareFootage, String propertyName, boolean multiProperty) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.squareFootage = squareFootage;
        this.propertyName = propertyName;
        this.multiProperty = multiProperty;
    }

    /**
     * commercialCharges method
     * calculate the amount owed and display information to the user
     */
    public void commercialCharges(){
        /**
         * @param nf Used to create an instance of the number format method
         * use number formatting to reformat to 2 decimal places
         */
        NumberFormat nf = NumberFormat.getNumberInstance() ;
        nf.setGroupingUsed(true) ;
        nf.setMaximumFractionDigits(2) ;
        nf.setMinimumFractionDigits(2) ;

        /**
         * @param rate to hold the rate as a double
         * @param commercialRate To hold the rate of 5.00 which is charged per 1000 square foot to be mowed
         * set rate to the commercial rate multiplied by square footage divided by 1000
         * if the multiple property discount is applicable provide a 10% discount by multiplying the rate by .9
         * use the number format instance to reformat the rate
         */
        double rate;
        double commercialRate = 5.00;
        rate = commercialRate * (squareFootage / 1000);
        if (multiProperty) rate = rate * 0.90;
        String weeklyRate = nf.format(rate);

        /**
         * call the displayCustomer method to display the common customer information
         * display the commercial specific information to the user
         * use conditional display if a multiple property discount is available
         * display the weekly charge to the user
         */
        displayCustomer();
        System.out.println("\nProperty Information");
        System.out.println("----------------------");
        System.out.println("Property Name: " + propertyName);
        System.out.println("Total area to be mowed " + squareFootage + " sq ft.");
        if (multiProperty) {
            System.out.println("Multi-Property discount: Yes");
        }
        else {
            System.out.println("Multi-Property discount: No");
        }
        System.out.println("Total weekly charge is: $" + weeklyRate);
    }
}