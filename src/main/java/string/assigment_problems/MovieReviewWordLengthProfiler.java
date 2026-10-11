package string.assigment_problems;

public class MovieReviewWordLengthProfiler {

    // Short = 1-4 letters, Medium = 5-8 letters, Long = 9+ letters
    static void classifyWordLengths(String review) {
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        String[] words = review.trim().split("\\s+");

        for (String word : words) {
            // Remove punctuation so only letters are counted
            String cleaned = word.replaceAll("[^a-zA-Z]", "");
            int length = cleaned.length();

            if (length == 0) {
                continue;
            }

            if (length <= 4) {
                shortCount++;
            } else if (length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}