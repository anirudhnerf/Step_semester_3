package string_methods.assigment_problems;

public class PinLengthValidator {

    // Only checks the length: no loop needed, just length() and if / else.
    // \u2014 is the em dash character used in the expected output.
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN \u2014 must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }
}