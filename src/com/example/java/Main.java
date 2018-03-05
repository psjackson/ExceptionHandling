package com.example.java;

import java.util.*;

/**
 * Main class
 * Based on the type of customer Residential or Commercial get information from the user
 * Pass the information to the relevant class
 * Display all information to the user
 */
public class Main {

    /**
     * main method to show menu function to the user and get customer details based on the type of customer they are
     * @param args An array of String values
     */
    public static void main(String[] args) {

        /**
         * scanner Variable to use the scanner to get user from the user
         */
        Scanner scanner = new Scanner(System.in);

        /**
         * Get from the user if they are a Residential or Commercial client or they they finished with the application
         * @param choice Used to hold the menu choice from the user
         * @param response Used to repeat the while loop if no valid input entered
         */
        int choice = 0;
        boolean response = true;
        while (response) {
            System.out.println("Option 1: Commercial Contract.");
            System.out.println("Option 2: Residential Contract.");
            System.out.println("Option 3: Done.");
            System.out.print("Please select an option (1-3):");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
            }

            /**
             * switch statement to call the relevant method depending on the option selected
             * 1 for commercial, 2 for residential, 3 to exit
             * then break out of loop
             * default prompts user of invalid selection and re-requests
             */
            switch (choice) {
                case 1:
                    commercial();
                    response = false;
                    break;
                case 2:
                    residential();
                    response = false;
                    break;
                case 3:
                    System.out.println("\nHave a nice day.");
                    response = false;
                    break;
                default:
                    System.out.println("\nThat is not a valid input.");
                    System.out.println("Please enter the number of the option you wish to select.");
            }
        }
    }

    /**
     * getCustomerName method that gets input from the user and returns a String value
     * method created as this functionality is used by both residential and commercial clients
     * @return the customers name to the calling method
     */
    private static String getCustomerName() {
        /**
         * use the scanner to get user from the user
         */
        Scanner scanner = new Scanner(System.in);

        /**
         * @param customerName To hold the customers name and return it to the calling method
         * @param again Used to repeat the internal while loop if no valid input entered
         * do-while loop repeated if no alphabetical, spaces or comma's are used
         * try/catch block used to get exceptions
         */
        String customerName = "Default";
        do {
            boolean again = true;
            while (again) {
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

    /**
     * getCustomerPhone method that gets input from the user and returns a String value
     * method created as this functionality is used by both residential and commercial clients
     * @return the customers phone number to the calling method
     */
    private static String getCustomerPhone() {

        /**
         * use the scanner to get user from the user
         */
        Scanner scanner = new Scanner(System.in);

        /**
         * @param customerPhone To hold the customers phone and return it to the calling method
         * @param again Used to repeat the internal while loop if no valid input entered
         * do-while loop repeated if no numerical, spaces, /'s or ()'s are used
         * try/catch block used to get exceptions
         */
        String customerPhone = "default";
        do {
            boolean again = true;
            while (again) {
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


    /**
     * getCustomerAddress method that gets input from the user and returns a String value
     * method created as this functionality is used by both residential and commercial clients
     * @return the customers address to teh calling function
     */
    private static String getCustomerAddress() {

        /**
         * use the scanner to get user from the user
         */
        Scanner scanner = new Scanner(System.in);

        /**
         * @param customerAddress To hold the customers address and return it to the calling method
         * @param again Used to repeat the internal while loop if no valid input entered
         * do-while loop repeated if no alphanumerical, spaces, /'s or commas are used
         * try/catch block used to get exceptions
         */
        String customerAddress = "default";
        do {
            Boolean again = true;
            while (again) {
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

    /**
     * getSquareFootage method that gets input from the user and returns a Double value
     * method created as this functionality is used by both residential and commercial clients
     * @return the square footage to be mowed to the calling method
     */
    private static Double getSquareFootage() {

        /**
         * use the scanner to get user from the user
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * @param squareFootage To hold the area to be mowed and return it to the calling method
         * @param again Used to repeat the while loop if no valid input entered
         * try/catch block used to get exceptions
         */
        Double squareFootage = 0.00;
        boolean again = true;
        while (again) {
            try {
                System.out.print("Please enter the total square footage to be mowed(Numbers Only): ");
                String footage = scanner.nextLine();
                squareFootage = Double.parseDouble(footage);
                again = false;
            } catch (NumberFormatException e) {
                System.out.println("That's an invalid input.");
            }
        }
        return squareFootage;
    }

    /**
     * commercial method that called the relevant method that get common user information
     * gets commercial specific information from the user and stores it as variables
     */
    private static void commercial() {

        /**
         * @param multiProperty To hold the where a discount for multiple properties is applicable
         * use the scanner to get user from the user
         * display what the application does to the user
         */
        boolean multiProperty;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCommercial Customer");
        System.out.println("-------------------");

        /**
         * @param customerName Call the getCustomerName method and store the returned value
         * @param customerPhone Call the getCustomerPhone method and store the returned value
         * @param customerAddress Call the getCustomerAddress method and store the returned value
         */
        String customerName = getCustomerName();
        String customerPhone = getCustomerPhone();
        String customerAddress = getCustomerAddress();

        /**
         * @param propertyName To hold the name of the property from the user
         * @param again Used to repeat the while loop if no valid input entered
         * do-while loop repeated if no alphanumerical, spaces, /'s or commas are used
         * try/catch block used to get exceptions
         */
        String propertyName = "default";
        do {
            Boolean again = true;
            while (again) {
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

        /**
         * @param squareFootage Call the getSquareFootage method and store the returned value
         */
        Double squareFootage = getSquareFootage();

        /**
         * @param discount To hold whether a multiple property discount will be applicable
         * @param again Used to repeat the while loop if no valid input entered
         * @param multiProperty Set to true if discount is Y or y, false if discount is N or n
         * do-while loop repeated if no nNyY characters are used
         * try/catch block used to get exceptions
         */
        String discount = "0";
        do {
            Boolean again = true;
            while (again) {
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
        multiProperty = (discount.equals("y")) || (discount.equals("Y"));

        /**
         * @param comCustomer Instance of the Commercial class, passing values of the customers name, customers phone
         * customers address, size of are to be mowed, name of the property, and if a multi property discount is applicable
         * using the comCustomer instance call the commercialCharges method in the Commercial class
         */
        Commercial comCustomer = new Commercial(customerName, customerPhone, customerAddress, squareFootage, propertyName, multiProperty);
        comCustomer.commercialCharges();
    }

    /**
     * residential method that called the relevant method that get common user information
     * gets commercial specific information from the user and stores it as variables
     */
    private static void residential() {

        /**
         * @param multiProperty To hold the where a discount for multiple properties is applicable
         * use the scanner to get user from the user
         * display what the application does to the user
         */
        boolean senior;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nResidential Customer");
        System.out.println("--------------------");

        /**
         * @param customerName Call the getCustomerName method and store the returned value
         * @param customerPhone Call the getCustomerPhone method and store the returned value
         * @param customerAddress Call the getCustomerAddress method and store the returned value
         * @param squareFootage Call the getSquareFootage method and store the returned value
         */
        String customerName = getCustomerName();
        String customerPhone = getCustomerPhone();
        String customerAddress = getCustomerAddress();
        Double squareFootage = getSquareFootage();

        /**
         * @param seniorDis To hold whether a multiple property discount will be applicable
         * @param again Used to repeat the while loop if no valid input entered
         * @param multiProperty Set to true if discount is Y or y, false if discount is N or n
         * do-while loop repeated if no nNyY characters are used
         * try/catch block used to get exceptions
         */
        String seniorDis = "0";
        do {
            Boolean again = true;
            while (again) {
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
        senior = (seniorDis.equals("y")) || (seniorDis.equals("Y"));

        /**
         * @param resCustomer Instance of the Residential class, passing values of the customers name, customers phone
         * customers address, size of are to be mowed, and if a senior discount is applicable
         * using the resCustomer instance, call the residentialCharges method in the Residential class
         */
        Residential resCustomer = new Residential(customerName, customerPhone, customerAddress, squareFootage, senior);
        resCustomer.residentialCharges();
    }
}