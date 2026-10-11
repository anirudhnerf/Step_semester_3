package inheritance.assigment_problems;

import java.util.Arrays;

// P3 demo: The Premium Loyalty Discount & Late-Fee Ledger
public class LateFeeLedgerDemo {

    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println("p.getTotalLateFees(): " + p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        history[0] = 999; // tampering with the copy
        System.out.println("p.getLateFeeHistory(): " + Arrays.toString(p.getLateFeeHistory()));
    }
}