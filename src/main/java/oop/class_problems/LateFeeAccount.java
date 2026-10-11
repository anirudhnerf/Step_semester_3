package oop.class_problems;

// M3: Late Fees - final methods that no subclass can override
public class LateFeeAccount {

    String regNo;
    double totalFee;

    public LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    // Locked: 1% of the total fee per day late
    final double calculateLateFee(int daysLate) {
        if (daysLate <= 0) {
            return 0;
        }
        return totalFee * daysLate / 100;
    }

    // Locked: on-time accounts are skipped, late ones get a full summary
    final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
            return;
        }
        System.out.println(regNo + " | Total Fee: Rs " + totalFee
                + " | Late Fee: Rs " + calculateLateFee(daysLate));
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {
            LateFeeAccount account = new LateFeeAccount(regNos[i], totalFees[i]);
            account.printSummary(daysLate[i]);
        }
    }
}