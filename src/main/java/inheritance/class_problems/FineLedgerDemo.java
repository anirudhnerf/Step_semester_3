package inheritance.class_problems;

import java.util.Arrays;

// P3 demo: The Student Discount & Fine Ledger
public class FineLedgerDemo {

    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println("s.getTotalFine(): " + s.getTotalFine());

        int[] history = s.getFineHistory();
        history[0] = 999; // tampering with the copy
        System.out.println("s.getFineHistory(): " + Arrays.toString(s.getFineHistory()));
    }
}