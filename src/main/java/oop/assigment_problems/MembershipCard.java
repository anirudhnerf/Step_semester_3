package oop.assigment_problems;

// A4: Static Block - Library Membership Card Setup
public class MembershipCard {

    // Static fields: one copy shared by every card
    static String libraryName;
    static String validUntil;

    // Runs exactly once, when the class is first loaded - never per object
    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    // Instance field: every card has its own student
    String studentName;

    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        for (String n : names) {
            MembershipCard card = new MembershipCard(n);
            System.out.println("Membership card issued: " + card.studentName);
        }
    }
}