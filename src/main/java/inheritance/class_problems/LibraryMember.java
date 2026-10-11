package inheritance.class_problems;

import java.util.Arrays;

// Base class for every membership type (used by all five problems)
public class LibraryMember {

    // P5: ONE counter shared by every LibraryMember object
    private static int membersEnrolled = 0;

    // P5: final, so it can never be reassigned after construction or set from outside
    public final String memberNumber;

    private final String memberId;
    private final int borrowLimit;
    private int booksBorrowed = 0;
    private String lastGenre;

    // P3: private fine ledger
    private int[] fineHistory = new int[10];
    private int fineCount = 0;
    private int totalFine = 0;

    // P1: the ONLY place the memberId validation rule lives
    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("memberId must have at least 4 non-blank characters");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.memberNumber = nextMemberNumber();
    }

    // P5: no memberId supplied, so the generated memberNumber doubles as the ID
    public LibraryMember(int borrowLimit) {
        this.borrowLimit = borrowLimit;
        this.memberNumber = nextMemberNumber();
        this.memberId = this.memberNumber;
    }

    // Increments the shared counter once per object, then builds the number from it
    private static String nextMemberNumber() {
        membersEnrolled++;
        return "LIB-" + (100 + membersEnrolled);
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    // How many books this member may hold; subclasses can raise it
    protected int allowedBooks() {
        return borrowLimit;
    }

    public void borrowBook() {
        if (booksBorrowed < allowedBooks()) {
            booksBorrowed++;
        }
    }

    // P5 overload: records the genre, then reuses the no-argument version
    public void borrowBook(String genre) {
        this.lastGenre = genre;
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getLastGenre() {
        return lastGenre;
    }

    // P2: every subclass overrides this to describe itself
    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    // P3: the one place fines are applied AND recorded
    protected void chargeFine(int amount) {
        if (fineCount == fineHistory.length) {
            fineHistory = Arrays.copyOf(fineHistory, fineHistory.length * 2);
        }
        fineHistory[fineCount] = amount;
        fineCount++;
        totalFine += amount;
    }

    // P3: a defensive copy - changing it never touches the real history
    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        return totalFine;
    }

    // P5: exact format "R" + two digits + one uppercase letter, e.g. R12A (no regex)
    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false; // wrong length fails BEFORE any charAt() call
        }
        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }
}