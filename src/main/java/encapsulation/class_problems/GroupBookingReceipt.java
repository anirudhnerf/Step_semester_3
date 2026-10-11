package encapsulation.class_problems;

// P5: A group booking - also immutable, and itself final
public final class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }

    // Keeps groupSize when a seat is fixed, so the result is still a group receipt
    @Override
    protected BookingReceipt rebuild(String[] newSeats) {
        return new GroupBookingReceipt(getBookingId(), newSeats, groupSize);
    }
}