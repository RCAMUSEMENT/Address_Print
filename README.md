# 📬 Address Label Generator

A robust **Java-based CLI tool** that takes user input and transforms it into a perfectly formatted, standardized mailing label.

## ✨ Key Features
* **⌨️ Interactive Input:** Uses `Scanner` to collect real-time user data.
* **🛡️ Robust Validation:** Ensures Zip Codes are exactly **5 numeric digits**.
* **🔡 Auto-Formatting:** Automatically fixes capitalization for names and cities.
* **📜 Professional Layout:** Outputs data in a standard mailing label format.

---

## 🚀 Java Source Code

/*
 * File: AddressPrint.java
 * Purpose: Interactive mailing label generator with input validation.
 */

import java.util.Scanner;

public class AddressPrint {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // --- 1. Input Section with Auto-Capitalization ---
        System.out.println("--- Please enter your details ---");
        
        System.out.print("First Name: ");
        String firstName = capitalize(input.nextLine());
        
        System.out.print("Last Name: ");
        String lastName = capitalize(input.nextLine());
        
        System.out.print("Street Address: ");
        String streetAddress = input.nextLine(); // Kept as-is for address format
        
        System.out.print("City: ");
        String city = capitalize(input.nextLine());
        
        // --- 2. Zip Code Validation Loop ---
        String zipCode = "";
        while (true) {
            System.out.print("Zip Code (5 digits): ");
            zipCode = input.nextLine();
            
            // Regex check: Ensures exactly 5 digits (0-9)
            if (zipCode.matches("\\d{5}")) {
                break; // Exit loop if valid
            } else {
                System.out.println(">> Error: Please enter a valid 5-digit numeric zip code.");
            }
        }
        
        // --- 3. Formatted Mailing Label Output ---
        System.out.println("\n--- MAILING LABEL ---");
        System.out.println(firstName + " " + lastName);
        System.out.println(streetAddress);
        System.out.println(city + ", " + zipCode);
        System.out.println("---------------------");
        
        input.close();
    }

    /**
     * Helper method to capitalize the first letter and lowercase the rest.
     * Example: "dAMiEn" becomes "Damien"
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
