package encapsulation.assigment_problems;

// P3: Book Copy Circulation Guard
public class BookInventory {

    private static final int MAX_COPIES = 500;

    // private: the only way to change copiesAvailable is checkOut() / checkIn()
    private final int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0 || copiesTotal > MAX_COPIES) {
            throw new IllegalArgumentException("copiesTotal must be between 1 and " + MAX_COPIES);
        }
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    // Invariant that must hold at every moment: 0 <= copiesAvailable <= copiesTotal
    void checkOut() {
        if (copiesAvailable == 0) {
            return; // nothing left to check out - silently rejected
        }
        copiesAvailable--;
    }

    void checkIn() {
        if (copiesAvailable == copiesTotal) {
            return; // already full, nothing genuine to return - silently rejected
        }
        copiesAvailable++;
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {
        BookInventory b = new BookInventory(3);

        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut(); // 4th attempt: rejected
        System.out.println("After 4 check-outs: " + b.getCopiesAvailable());

        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn(); // 4th attempt: rejected
        System.out.println("After 4 check-ins: " + b.getCopiesAvailable());
    }
}