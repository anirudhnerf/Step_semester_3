package encapsulation.class_problems;

import java.util.Objects;

// P5: An immutable booking receipt.
// NOTE: the task asks for a final class, but GroupBookingReceipt must extend it
// (it is stored in a BookingReceipt[] and checked with instanceof), and a final
// class cannot be extended. So the class is kept open for that one subclass and
// locked down everywhere else: final fields, final methods, final subclass,
// defensive copies in and out.
public class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        Objects.requireNonNull(bookingId, "bookingId");
        Objects.requireNonNull(seatNumbers, "seatNumbers");
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone(); // copy IN
    }

    public final String getBookingId() {
        return bookingId;
    }

    final String[] getSeatNumbers() {
        return seatNumbers.clone(); // copy OUT
    }

    // "Changing" a receipt returns a brand-new object; this one never changes
    final BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updated = getSeatNumbers();
        updated[index] = newSeat;
        return rebuild(updated);
    }

    // Lets a subclass keep its own extra data when a new copy is made
    protected BookingReceipt rebuild(String[] newSeats) {
        return new BookingReceipt(bookingId, newSeats);
    }
}