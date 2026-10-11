package string.assigment_problems;

public class TypingAccuracyChecker {

    // Compares the typed text with the original, character by character
    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: both texts must be the same length");
            return;
        }
        int total = original.length();
        if (total == 0) {
            System.out.println("Error: the text is empty");
            return;
        }

        int matched = 0;
        int firstMismatch = -1; // index of the first wrong character

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / total;

        String mismatchInfo;
        if (firstMismatch == -1) {
            mismatchInfo = "No Mismatches";
        } else {
            // Position is shown starting from 1
            mismatchInfo = "First Mismatch at position " + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch) + "' vs '" + typed.charAt(firstMismatch) + "')";
        }

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | %s%n", matched, total, accuracy, mismatchInfo);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}