package string_methods.class_problems;

public class MaskedPhoneNumberFormatter {

    // Shows XXXXXX-<last 4 digits> for a valid 10-digit phone number
    static String maskPhoneNumber(String phone) {
        // Must be exactly 10 characters
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // All 10 characters must be digits
        for (int i = 0; i < phone.length(); i++) {
            char ch = phone.charAt(i);
            if (ch < '0' || ch > '9') {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append(phone.substring(6)); // last 4 digits
        masked.insert(6, "-");             // dash between the mask and the digits
        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}