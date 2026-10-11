package oop.class_problems;

// M5: Account Batch Payments - instanceof dispatch plus simple counters
public class BatchPaymentProcessor {

    static int hostelCount = 0;
    static int dayScholarCount = 0;

    static void processPayment(FeeAccount account, double amount) {
        // Check the subclass first: a HostelFeeAccount is also a FeeAccount
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount("RA001"),
            new HostelFeeAccount("RA002"),
            new FeeAccount("RA003"),
            new FeeAccount("RA004")
        };

        for (FeeAccount account : accounts) {
            processPayment(account, 60000);
        }

        System.out.println("Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}