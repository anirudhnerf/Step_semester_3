package encapsulation.class_problems;

// P3: Seat Booking Encapsulation Guard
public class CineScreen {

    private static final int MAX_SEATS = 300;

    // private, and only ever changed by the validated methods below
    private final int seatsTotal;
    private int seatsAvailable;

    // A screen can never be created with a nonsensical seat count
    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0 || seatsTotal > MAX_SEATS) {
            throw new IllegalArgumentException("seatsTotal must be between 1 and " + MAX_SEATS);
        }
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    // Rule that must always hold: 0 <= seatsAvailable <= seatsTotal
    void bookSeat() {
        if (seatsAvailable == 0) {
            return; // nothing left to take - silently rejected
        }
        seatsAvailable--;
    }

    void cancelBooking() {
        if (seatsAvailable == seatsTotal) {
            return; // nothing genuine to undo - silently rejected
        }
        seatsAvailable++;
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static void main(String[] args) {
        try {
            new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("new CineScreen(0): construction rejected");
        }

        CineScreen c = new CineScreen(2);
        c.bookSeat();
        c.bookSeat();
        c.bookSeat(); // rejected
        System.out.println("After 3 bookings: " + c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking(); // rejected
        System.out.println("After 3 cancellations: " + c.getSeatsAvailable());
    }
}