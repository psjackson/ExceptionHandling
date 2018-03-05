package com.example.java;

import java.text.NumberFormat;

/**
 * Residential class that is a sub class of Customer
 */
public class Residential extends Customer {
    /**
     * senior Variable to hold if a senior discount is applicable for the customer
     */
    private boolean senior;

    /**
     * constructor method to collect the passed arguments and save them as variables
     * @param customerName Variable to hold the customers name
     * @param customerAddress Variable to hold the customers address
     * @param customerPhone Variable to hold the customers phone number
     * @param squareFootage Variable to hold the area to be mowed
     * @param senior Variable to hold is a senior discount is applicable
     */
    Residential(String customerName, String customerAddress, String customerPhone, double squareFootage, boolean senior) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.squareFootage = squareFootage;
        this.senior = senior;
    }

    /**
     * residentialCharges method
     * calculate the amount owed and display information to the user
     */
    public void residentialCharges(){
        /**
         * @param nf Used to create an instance of the number format method
         * use number formatting to reformat to 2 decimal places
         */
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        /**
         * @param rate to hold the rate as a double
         * @param residentialRate To hold the rate of 6.00 which is charged per 1000 square foot to be mowed
         * set rate to the residential rate multiplied by square footage divided by 1000
         * if the senior discount is applicable provide a 15% discount by multiplying the rate by .85
         * use the number format instance to reformat the rate
         */
        double rate;
        double residentialRate = 6.00;
        rate = residentialRate * (squareFootage / 1000);
        if (senior) rate = rate * 0.85;
        String weeklyRate = nf.format(rate);

        /**
         * call the displayCustomer method to display the common customer information
         * display the residential specific information to the user
         * use conditional display if a senior discount is available
         * display the weekly charge to the user
         */
        displayCustomer();
        System.out.println("\nProperty Information");
        System.out.println("----------------------");
        System.out.println("Total area to be mowed " + squareFootage + " sq ft.");
        if (senior) {
            System.out.println("Senior discount: Yes");
        }
        else {
            System.out.println("Senior discount: No");
        }
        System.out.println("Total weekly charge is: $" + weeklyRate);
    }
}