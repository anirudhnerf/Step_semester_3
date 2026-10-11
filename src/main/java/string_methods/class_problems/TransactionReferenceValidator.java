package string_methods.class_problems;

public class TransactionReferenceValidator {

    // Trims spaces and uppercases only the first 3 characters (the bank code)
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        int n = Math.min(3, trimmed.length());
        return trimmed.substring(0, n).toUpperCase() + trimmed.substring(n);
    }

    // Valid format: 3 letters + 6 digits (ddMMyy) + 5 digits (sequence) = 14 characters
    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence must be digits";
            }
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(reference.substring(0, 3)).append("] DATE: ")
                .append(reference.substring(3, 5)).append("/")   // dd
                .append(reference.substring(5, 7)).append("/")   // MM
                .append(reference.substring(7, 9))               // yy
                .append(" | SEQ: ").append(reference.substring(9));
        return formatted.toString();
    }

    public static void main(String[] args) {
        String[] inputs = {" hdf03022600042 ", "12F03022600042", "hdf0302260004", "hdf03022600A42"};

        for (String input : inputs) {
            String normalized = normalizeReference(input);
            System.out.println(validateAndFormat(normalized));
        }
    }
}