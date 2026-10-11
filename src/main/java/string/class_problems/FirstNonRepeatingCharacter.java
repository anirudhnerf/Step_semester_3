package string.class_problems;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Returns the first character that appears only once, or '\0' if none exists
    static char findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        // Pass 1: count how often each character appears
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // Pass 2: scan left to right and stop at the first count of 1
        for (char c : text.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
        scanner.close();
    }
}