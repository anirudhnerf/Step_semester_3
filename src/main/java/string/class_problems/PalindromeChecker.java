package string.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: compare characters from both ends moving toward the middle
    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: compare first and last, then recurse on the shrunken substring
    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: reverse into a new char array and compare with the original
    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return Arrays.equals(original, reversed);
    }

    static String label(boolean result) {
        return result ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        // Ignore case, spaces and punctuation so phrases also work
        String text = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        System.out.println("Iterative: " + label(isPalindromeIterative(text))
                + " | Recursive: " + label(isPalindromeRecursive(text))
                + " | Array Reversal: " + label(isPalindromeArrayReversal(text)));
        scanner.close();
    }
}