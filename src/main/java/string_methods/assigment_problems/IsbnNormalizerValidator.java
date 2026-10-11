package string_methods.assigment_problems;

public class IsbnNormalizerValidator {

    // Trims spaces and uppercases only the first 3 characters (the publisher code)
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        int n = Math.min(3, trimmed.length());
        return trimmed.substring(0, n).toUpperCase() + trimmed.substring(n);
    }

    // Valid format: 3 letters + 4 digits (year) + 6 digits (catalog number) = 13 characters
    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year and catalog number must be digits";
            }
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(code.substring(0, 3)).append("] YEAR: ")
                .append(code.substring(3, 7))
                .append(" | CATALOG: ").append(code.substring(7));
        return formatted.toString();
    }

    public static void main(String[] args) {
        String[] inputs = {" pen2026004251 ", "12N2026004251", "pen202600425", "pen2026A04251"};

        for (String input : inputs) {
            String normalized = normalizeCode(input);
            System.out.println(validateAndFormat(normalized));
        }
    }
}