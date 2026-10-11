package oop.assigment_problems;

// M1: From parallel arrays to a class - Library Inventory
public class BookInventory {

    String title;
    String author;
    int copiesAvailable;

    // Sets all three fields in one go, so the data can never go out of sync
    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Prints one formatted line for this book
    void printEntry() {
        String word = (copiesAvailable == 1) ? "copy" : "copies";
        System.out.println(title + " by " + author + " - " + copiesAvailable + " " + word + " available");
    }

    public static void main(String[] args) {
        // One array of objects replaces the three parallel arrays
        BookInventory[] books = new BookInventory[4];
        books[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
        books[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        books[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        books[3] = new BookInventory("Design Patterns", "GoF", 2);

        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}