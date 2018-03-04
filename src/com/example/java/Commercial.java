package com.example.java;

import java.text.NumberFormat;

public class Commercial extends Customer{
    //variables to hold property name and multi-property discount that are not defined in the customer class
    private String propertyName;
    private boolean multiProperty;

    //accepts arguments and assigns them to the variables
    Commercial(String customerName, String customerAddress, String customerPhone, double squareFootage, String propertyName, boolean multiProperty) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.squareFootage = squareFootage;
        this.propertyName = propertyName;
        this.multiProperty = multiProperty;
    }

    public void commercialCharges(){
        //use number formatting to set numbers to 2 decimal places
        NumberFormat nf = NumberFormat.getNumberInstance() ; //we get the instance of the number
        nf.setGroupingUsed(true) ; // group by threes
        nf.setMaximumFractionDigits(2) ; //set the max number of decimal digits.
        nf.setMinimumFractionDigits(2) ; //set the min number of decimal digits.

        //create a variable to hold the rate to be charged to the customer
        double rate;
        //set the base rate as 5 to be multiplied by the area and any applicable discounts
        double commercialRate = 5.00;
        //set the rate to the commercialRate multiplied by the area to be mowed
        rate = commercialRate * (squareFootage / 1000);
        //multiple the rate by .9 to give a 10% discount if a multi-property discount is applicable
        if (multiProperty) rate = rate * 0.90;

        //use number formatting to set the rate to 2 decimal places
        String weeklyRate = nf.format(rate);

        //call the customer display method that was created in the superclass to display basic customer information
        displayCustomer();
        //display the rest of the information to the user
        System.out.println("\nProperty Information");
        System.out.println("----------------------");
        System.out.println("Property Name: " + propertyName);
        System.out.println("Total area to be mowed " + squareFootage + " sq ft.");
        //use of a conditional to display if a discount was applied
        if (multiProperty) {
            System.out.println("Multi-Property discount: Yes");
        }
        else {
            System.out.println("Multi-Property discount: No");
        }
        //display the weekly rate to the user
        System.out.println("Total weekly charge is: $" + weeklyRate);
    }
}