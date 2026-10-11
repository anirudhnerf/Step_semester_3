package string.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    // Builds the reversed name in a new array, so the original stays unchanged
    static String reverseCustomerName(String customerName) {
        char[] original = customerName.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
        scanner.close();
    }
}