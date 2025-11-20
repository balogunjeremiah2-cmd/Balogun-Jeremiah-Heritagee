/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.planebooking;
import java. util. Scanner;
/**
 *
 * @author USER
 */
public class PlaneBooking {

    public static void main(String[] args) {
        // 1. Setup variables
        // We use a 2D array to represent the plane. 
        // 5 rows and 4 seats per row.
        char[][] seats = new char[5][4]; 
        
        // We will use a Scanner to get input from the user
        Scanner scanner = new Scanner(System.in);

        // 2. Initialize the seats
        // We loop through the array and set every seat to '_' (Empty)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j] = '_';
            }
        }

        System.out.println("Welcome to HeritageAirways Reservation System!");

        // 3. Main Program Loop
        // This loop keeps running forever until the user decides to exit
        while (true) {
            // Print the current seating chart
            System.out.println("\n   1 2 3 4"); // Column numbers for display
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + "  "); // Print Row Number
                for (int j = 0; j < 4; j++) {
                    System.out.print(seats[i][j] + " ");
                }
                System.out.println(); // New line after every row
            }

            // 4. Get User Input
            System.out.println("\nEnter a Row number (1-5) or 0 to Exit:");
            int row = scanner.nextInt();

            // Check if user wants to quit
            if (row == 0) {
                System.out.println("Thank you for using our system. Goodbye!");
                break; // Breaks out of the while loop
            }

            System.out.println("Enter a Seat number (1-4):");
            int col = scanner.nextInt();

            // 5. Validate Input
            // We check if the numbers are within the size of our plane
            if (row < 1 || row > 5 || col < 1 || col > 4) {
                System.out.println("ERROR: Invalid row or seat number. Please try again.");
            } 
            else {
                // 6. Book the Seat
                // IMPORTANT: Arrays start at index 0, but humans count from 1.
                // So we subtract 1 from the user's input.
                int rowIndex = row - 1;
                int colIndex = col - 1;

                // Check if the seat is already taken ('X')
                if (seats[rowIndex][colIndex] == 'X') {
                    System.out.println("Sorry, that seat is already taken!");
                } else {
                    // Mark the seat as taken
                    seats[rowIndex][colIndex] = 'X';
                    System.out.println("Success! Your seat at Row " + row + ", Seat " + col + " is booked.");
                }
            }
        }
        
        scanner.close();
    }
}
