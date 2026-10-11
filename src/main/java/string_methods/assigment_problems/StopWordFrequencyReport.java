package string_methods.assigment_problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StopWordFrequencyReport {

    static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    static boolean isStopWord(String word) {
        for (String stop : STOP_WORDS) {
            if (stop.equals(word)) {
                return true;
            }
        }
        return false;
    }

    static void printFilteredWordFrequency(String feedback) {
        // Normalize: lowercase and strip punctuation using replace()
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "");

        String[] words = cleaned.trim().split("\\s+");

        // LinkedHashMap keeps first-appearance order, so ties come out in a stable order
        Map<String, Integer> frequency = new LinkedHashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue; // skip filler words
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Sort by count, highest first
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}