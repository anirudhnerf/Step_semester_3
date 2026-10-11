package oop.class_problems;

// M4: Reference copies and object identity
public class IdCard {

    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);

        // Not a new object: both variables now point at the SAME object
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;

        // A genuinely separate object that just has identical field values
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}