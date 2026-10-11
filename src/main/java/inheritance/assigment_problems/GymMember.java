package inheritance.assigment_problems;

import java.util.Arrays;

// Base class for every gym membership type (used by all five problems)
public class GymMember {

    // P5: ONE counter shared by every GymMember object
    private static int membersEnrolled = 0;

    // P5: final, so it can never be reassigned after construction or set from outside
    public final String membershipNumber;

    private final String memberId;
    private final int monthlyFee;
    private int sessionsAttended = 0;

    // P5: fee payments
    private int feesPaid = 0;
    private String lastPaymentMode;

    // P3: private late-fee ledger
    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;
    private int totalLateFees = 0;

    // P1: the ONLY place the memberId validation rule lives
    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("memberId must have at least 4 non-blank characters");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.membershipNumber = nextMembershipNumber();
    }

    // P5: no memberId supplied, so the generated membershipNumber doubles as the ID
    public GymMember(int monthlyFee) {
        this.monthlyFee = monthlyFee;
        this.membershipNumber = nextMembershipNumber();
        this.memberId = this.membershipNumber;
    }

    // Increments the shared counter once per object, then builds the number from it
    private static String nextMembershipNumber() {
        membersEnrolled++;
        return "GYM-" + (2000 + membersEnrolled);
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    // P5: flat-amount version holds the real logic
    public void payFee(int amount) {
        feesPaid += amount;
    }

    // P5 overload: records the mode, then reuses the flat version
    public void payFee(int amount, String mode) {
        this.lastPaymentMode = mode;
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public String getLastPaymentMode() {
        return lastPaymentMode;
    }

    // P2: every subclass overrides this to describe itself
    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    // P3: the one place late fees are applied AND recorded
    protected void chargeLateFee(int amount) {
        if (lateFeeCount == lateFeeHistory.length) {
            lateFeeHistory = Arrays.copyOf(lateFeeHistory, lateFeeHistory.length * 2);
        }
        lateFeeHistory[lateFeeCount] = amount;
        lateFeeCount++;
        totalLateFees += amount;
    }

    // P3: a defensive copy - changing it never touches the real history
    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        return totalLateFees;
    }

    // P5: exact format "G" + two digits + one uppercase letter, e.g. G45B (no regex)
    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false; // wrong length fails BEFORE any charAt() call
        }
        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }
}