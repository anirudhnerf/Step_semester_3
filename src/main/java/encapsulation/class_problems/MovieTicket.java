package encapsulation.class_problems;

// P1 (support class): one field at each of Java's four access levels,
// chosen by who genuinely needs to reach it
public class MovieTicket {

    // private: only MovieTicket itself touches the seat; everyone else uses the getter
    private int seatNumber;

    // default (package-private): only booking code in this package needs the screen
    int screenId;

    // protected: subclasses such as PremiumMovieTicket (even in another package) need the price
    protected double ticketPrice;

    // public: the title is shown to everyone
    public String movieTitle;

    public MovieTicket(int seatNumber, int screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket(14, 3, 250.0, "Interstellar");

        // Inside the same class, all four fields are reachable
        System.out.println("Seat (private, same class): " + ticket.seatNumber);
        System.out.println("Screen (default): " + ticket.screenId);
        System.out.println("Price (protected): " + ticket.ticketPrice);
        System.out.println("Title (public): " + ticket.movieTitle);
    }
}