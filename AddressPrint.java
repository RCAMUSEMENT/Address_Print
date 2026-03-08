/**
 * Student Name: Ryley Carlson
 * CSC320 Module 1 Critical Thinking - Option 1
 * Program: Address Generator With Validation and Formatting
 * Description: This program prompts the user for their first name, last name, street address, city, and zip code.
 * It validates the zip code to ensure it is a 5-digit numeric value and formats the output as a mailing label.
 * The program also includes auto-capitalization for names and cities to enhance readability.
 */

import java.util.Scanner;

public class AddressPrint {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            // --- Input Section with Auto-Capitalization ---
            System.out.print("First Name: ");
            String firstName = capitalize(input.nextLine());
            
            System.out.print("Last Name: ");
            String lastName = capitalize(input.nextLine());
            
            System.out.print("Street Address: ");
            String streetAddress = input.nextLine();
            
            System.out.print("City: ");
            String city = capitalize(input.nextLine());
            
            // --- Zip Code Validation ---
            String zipCode = "";
            while (true) {
                System.out.print("Zip Code (5 digits): ");
                zipCode = input.nextLine();
                if (zipCode.matches("\\d{5}")) break;
                System.out.println(">> Error: Enter a valid 5-digit numeric zip code.");
            }
            
            // --- Formatted Output ---
            System.out.println("\n--- MAILING LABEL ---");
            System.out.println(firstName + " " + lastName);
            System.out.println(streetAddress);
            System.out.println(city + ", " + zipCode);
            System.out.println("---------------------");
        }
    }

    /**
     * Helper method to capitalize the first letter of a string and make the rest lowercase.
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        // Capitalize the first letter and make the rest lowercase
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}