package com.ajones;

public class Main {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        System.out.println(print(9));
        final long endTime = System.nanoTime();

        final long startTime1 = System.nanoTime();
        System.out.println(printSB(9));
        final long endTime1 = System.nanoTime();

        System.out.println("Method 1: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Method 2: " + (endTime1 - startTime1) + " nanoseconds");
    }
  
// OUTPUT: 
//    *
//   ***
//  *****
//   ***
//    *

//    *
//   ***
//  *****
//   ***
//    *

// Method 1: 5519241 nanoseconds
// Method 2: 533629 nanoseconds
  

    // METHOD 1
    public static String print(int n) {
        if (n % 2 == 0 || n <= 0) {
            return null;
        }
        String output = "";
        for (int row = 0; row <= n; row++) {
            if (row < n / 2) {
                for (int i = 0; i < n / 2 - row; i++) {
                    output += " ";
                }
                for (int j = 0; j < (row * 2) + 1; j++) {
                    output += "*";
                }
                output += "\n";
            } else if (row == n / 2 + 1) {
                for (int k = 0; k < n; k++) {
                    output += "*";
                }
                output += "\n";
            } else if (row > n / 2) {
                for (int i = 0; i < row - n / 2 - 1; i++) {
                    output += " ";
                }
                for (int j = 0; j < n - 2 * (row - (n / 2 + 1)); j++) {
                    output += "*";
                }
                output += "\n";
            }
        }
        return output;
    }

    // METHOD 2
    public static String printSB(int n) {
        if (n % 2 == 0 || n <= 0) {
            return null;
        }
        StringBuilder output = new StringBuilder();
        for (int row = 0; row <= n; row++) {
            if (row < n / 2) {
                output.append(" ".repeat(Math.max(0, n / 2 - row)));
                output.append("*".repeat(Math.max(0, (row * 2) + 1)));
                output.append("\n");
            } else if (row == n / 2 + 1) {
                output.append("*".repeat(n));
                output.append("\n");
            } else if (row > n / 2) {
                output.append(" ".repeat(Math.max(0, row - n / 2 - 1)));
                output.append("*".repeat(Math.max(0, n - 2 * (row - (n / 2 + 1)))));
                output.append("\n");
            }
        }
        return output.toString();
    }
}
