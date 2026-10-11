package encapsulation.class_problems;

import java.util.Arrays;

// P5: Nightly settlement - instanceof dispatch that never throws on a null entry
public class NightlySettlement {

    static String processNightlySettlement(BookingReceipt[] receipts) {
        int groupCount = 0;
        int individualCount = 0;
        int nullSkipped = 0;

        for (BookingReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
            } else if (receipt instanceof GroupBookingReceipt) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        int processed = groupCount + individualCount;
        return processed + " processed | " + nullSkipped + " null skipped | "
                + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        // Copy OUT: changing the returned array must not change the receipt
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println("b.getSeatNumbers()[0] = " + b.getSeatNumbers()[0]);

        // Copy IN: changing the array we passed in must not change the receipt
        String[] original = {"D1", "D2"};
        BookingReceipt c = new BookingReceipt("CH-4004", original);
        original[0] = "Z";
        System.out.println("c.getSeatNumbers()[0] = " + c.getSeatNumbers()[0]);

        // Wither: new object, old one untouched
        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println("b       = " + Arrays.toString(b.getSeatNumbers()));
        System.out.println("updated = " + Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] batch = {
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(batch));
    }
}