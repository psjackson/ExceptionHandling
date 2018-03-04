package com.example.java;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int choice = 0;
        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);
        //create a variable to use a condition for a while loop
        boolean response = true;
        //while the variable is true show menu to the user
        while (response) {
            //ask for input from the user that corresponds to a menu option
            System.out.println("Option 1: Commercial Contract.");
            System.out.println("Option 2: Residential Contract.");
            System.out.println("Option 3: Done.");
            System.out.print("Please select an option (1-3):");
            //try-catch block to validate the users input
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
            }
            //switch statement based on the choice
            switch (choice) {
                //selecting 1 will prompt the user to set up a commercial client
                case 1:
                    //call the commercial method
                    commercial();
                    //set the response variable to false to break out of the while loop
                    response = false;
                    //break out of the switch statement
                    break;
                //selecting 2 will prompt the user to set up a residential client
                case 2:
                    //call the residential method
                    residential();
                    //set the response variable to false to break out of the while loop
                    response = false;
                    //break out of the switch statement
                    break;
                //selecting 3 will end the application
                case 3:
                    //display an exit message to the user
                    System.out.println("\nHave a nice day.");
                    //set the response variable to false to break out of the while loop
                    response = false;
                    //break out of the switch statement
                    break;
                //if none of the options are selected the menu options will repeat as the variable is left as true
                default:
                    //display a message to request the user selects a menu option
                    System.out.println("\nThat is not a valid input.");
                    System.out.println("Please enter the number of the option you wish to select.");
            }
        }
    }

    private static String getCustomerName() {

        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);

        //get and save the name of client to a variable
        String customerName = "Default";
        do {
            boolean again = true;
            while (again) {
                //try-catch block to validate the users input
                try {
                    System.out.print("Please enter the name of the customer: ");
                    customerName = scanner.nextLine();
                    again = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } while (!customerName.matches("[a-zA-Z ,]+"));
        return customerName;
    }

    private static String getCustomerPhone() {

        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);

        //get and save the phone number of the client as a variable
        String customerPhone = "default";
        do {
            boolean again = true;
            while (again) {
                //try-catch block to validate the users input
                try {
                    System.out.print("Please enter the phone number of the customer(Numbers Only): ");
                    customerPhone = scanner.nextLine();
                    again = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } while (!customerPhone.matches("[0-9()\\- ]+"));
        return customerPhone;
    }

    private static String getCustomerAddress() {

        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);

        //get and save the address of the client as a variable
        String customerAddress = "default";
        do {
            Boolean again = true;
            while (again) {
                //try-catch block to validate the users input
                try {
                    System.out.print("Please enter the address of the customer: ");
                    customerAddress = scanner.nextLine();
                    again = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } while (!customerAddress.matches("[a-zA-Z 0-9,/]+"));
        return customerAddress;
    }

    private static Double getSquareFootage() {

        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);

        //get and save the area to be mowed as a variable, get as a string then parse and save as a double
        Double squareFootage = 0.00;
        boolean againSq = true;
        //use input validation as the variable needs to be a double
        while (againSq) {
            //try-catch block to validate the users input
            try {
                System.out.print("Please enter the total square footage to be mowed(Numbers Only): ");
                String footage = scanner.nextLine();
                squareFootage = Double.parseDouble(footage);
                againSq = false;
            } catch (NumberFormatException e) {
                System.out.println("That's an invalid input.");
            }
        }
        return squareFootage;
    }


    private static void commercial() {
        //create a multiProperty variable that will hold if a multi-property discount is applicable for the client
        boolean multiProperty;

        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);

        //display a series of questions to the user, and save the answers as variables using the scanner
        System.out.println("\nCommercial Customer");
        System.out.println("-------------------");

        //call method to get the customer name and assign it to a variable
        String customerName = getCustomerName();
        //call method to get the customer phone and assign it to a variable
        String customerPhone = getCustomerPhone();
        //call method to get the customer address and assign it to a variable
        String customerAddress = getCustomerAddress();

        //get and save the name of the property as a variable
        String propertyName = "default";
        do {
            Boolean again = true;
            while (again) {
                //try-catch block to validate the users input
                try {
                    System.out.print("Please enter the name of the property to be mowed: ");
                    propertyName = scanner.nextLine();
                    again = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } while (!propertyName.matches("[a-zA-Z 0-9,/]+"));

        //call method to get the square footage and assign it to a variable
        Double squareFootage = getSquareFootage();

        //get and save if a multi-property discount is applicable in the form of y or n
        String discount = "0";
        //loop to verify the user gives a value within selected range
        do {
            Boolean again = true;
            while (again) {
                //try-catch block to validate the users input
                try {
                    System.out.print("Please enter if there is a multi-property discount (y/n): ");
                    discount = scanner.nextLine();
                    again = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } while ((!discount.matches("[nNyY]")));
        //if the user entered y or Y multiProperty variable is set to true
        multiProperty = (discount.equals("y")) || (discount.equals("Y"));

        //create a instance of the Commercial class and pass all the collected variables to it
        Commercial comCustomer = new Commercial(customerName, customerPhone, customerAddress, squareFootage, propertyName, multiProperty);
        //call the commercialCharges method with the instance just created
        comCustomer.commercialCharges();
    }

    private static void residential() {

        //create a senior variable that will hold if a senior discount is applicable for the client
        boolean senior;

        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);

        //display a series of questions to the user, and save the answers as variables using the scanner
        System.out.println("\nResidential Customer");
        System.out.println("--------------------");

        //call method to get the customer name and assign it to a variable
        String customerName = getCustomerName();
        //call method to get the customer phone and assign it to a variable
        String customerPhone = getCustomerPhone();
        //call method to get the customer address and assign it to a variable
        String customerAddress = getCustomerAddress();
        //call method to get the square footage and assign it to a variable
        Double squareFootage = getSquareFootage();

        //get and save if a senior discount is applicable in the form of y or n
        String seniorDis = "0";
        //loop to verify the user gives a value within selected range
        do {
            Boolean again = true;
            while (again) {
                //try-catch block to validate the users input
                try {
                    System.out.print("Please enter if there is a senior discount (y/n): ");
                    seniorDis = scanner.nextLine();
                    again = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } while ((!seniorDis.matches("[nNyY]")));
        //if the user entered y or Y multiProperty variable is set to true
        senior = (seniorDis.equals("y")) || (seniorDis.equals("Y"));

        //create a instance of the residential class and pass all the collected variables to it
        Residential resCustomer = new Residential(customerName, customerPhone, customerAddress, squareFootage, senior);
        //call the residentialCharges method with the instance just created
        resCustomer.residentialCharges();
    }
}