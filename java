/*

A theater seating table is implemented as a two-dimensional array of fares, as follows:
10 10 10 10 10 10 10 10 10 10
10 10 10 10 10 10 10 10 10 10
10 10 10 10 10 10 10 10 10 10
10 10 20 20 20 20 20 20 10 10
10 10 20 20 20 20 20 20 10 10
10 10 20 20 20 20 20 20 10 10
20 20 30 30 40 40 30 30 20 20
20 30 30 40 50 50 40 30 30 20
30 40 50 50 50 50 50 50 40 30
 
 Write a program that prompts the user to select a seat or ticket price. Mark the bits by changing the ticket price to 0. If a user specifies a seat, make sure that seat is not sold. When the user specifies, find any seat corresponding to the fare.


*/

import java.util.Scanner;

public class Problem4 {

    private static final int[][] fares = {
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
            {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
            {30, 40, 50, 50, 50, 50, 50, 50, 40, 30}
    };

    public static void main(String[] args) {
        displaySeatingArrangement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the fare or seat number (1 to 90): ");
        int input = scanner.nextInt();
        scanner.close();

        if (input >= 1 && input <= 90) {
            int row, col;
            if (input >= 20 && input <= 50) {
                int fare = input;
                for (row = 0; row < fares.length; row++) {
                    for (col = 0; col < fares[row].length; col++) {
                        if (fares[row][col] == fare) {
                            markBits(row, col, fare);
                            break;
                        }
                    }
                }
            } else {
                row = (input - 1) / 10;
                col = (input - 1) % 10;
                if (fares[row][col] != 0) {
                    markBits(row, col, fares[row][col]);
                } else {
                    System.out.println("The seat is already sold.");
                }
            }
        } else {
            System.out.println("Invalid input. Please enter a fare or seat number between 1 and 90.");
        }
    }

    private static void markBits(int row, int col, int fare) {
        System.out.println("Seat " + (row * 10 + col + 1) + " is reserved at a price of " + fare + ".");
        fares[row][col] = 0;
    }


    private static void displaySeatingArrangement() {
        System.out.println("Current Seating Arrangement:");
        for (int[] row : fares) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}   
