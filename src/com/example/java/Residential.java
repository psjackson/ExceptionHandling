package com.example.java;

import java.text.NumberFormat;

public class Residential extends Customer {
    //variables to hold a senior discount that was not defined in the customer class
    private boolean senior;

    //accepts arguments and assigns them to the variables
    Residential(String customerName, String customerAddress, String customerPhone, double squareFootage, boolean senior) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.squareFootage = squareFootage;
        this.senior = senior;
    }

    public void residentialCharges(){
        //use number formatting to set numbers to 2 decimal places
        NumberFormat nf = NumberFormat.getNumberInstance() ; //we get the instance of the number
        nf.setGroupingUsed(true) ; // group by threes
        nf.setMaximumFractionDigits(2) ; //set the max number of decimal digits.
        nf.setMinimumFractionDigits(2) ; //set the min number of decimal digits.

        //create a variable to hold the rate to be charged to the customer
        double rate;
        //set the base rate as 5 to be multiplied by the area and any applicable discounts
        double residentialRate = 6.00;
        //set the rate to the residentialRate multiplied by the area to be mowed
        rate = residentialRate * (squareFootage / 1000);
        //multiple the rate by .85 to give a 15% discount if a senior discount is applicable
        if (senior) rate = rate * 0.85;

        //use number formatting to set the rate to 2 decimal places
        String weeklyRate = nf.format(rate);

        //call the customer display method that was created in the superclass to display basic customer information
        displayCustomer();
        //display the rest of the information to the user
        System.out.println("\nProperty Information");
        System.out.println("----------------------");
        System.out.println("Total area to be mowed " + squareFootage + " sq ft.");
        //use of a conditional to display if a discount was applied
        if (senior) {
            System.out.println("Senior discount: Yes");
        }
        else {
            System.out.println("Senior discount: No");
        }
        //display the weekly rate to the user
        System.out.println("Total weekly charge is: $" + weeklyRate);
    }
}
