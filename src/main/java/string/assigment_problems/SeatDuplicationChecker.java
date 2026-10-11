package string.assigment_problems;

public class SeatDuplicationChecker {

    // Compares every seat number with every other one (arrays and loops only)
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            // Skip this seat if the same number already appeared earlier,
            // so each duplicated seat number is printed only once
            boolean alreadyChecked = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyChecked = true;
                    break;
                }
            }
            if (alreadyChecked) {
                continue;
            }

            // Look for the same seat number later in the array
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}