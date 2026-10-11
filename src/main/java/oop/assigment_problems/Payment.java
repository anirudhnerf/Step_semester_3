package oop.assigment_problems;

// A5 (support class): a plain cash payment
public class Payment {

    // Prints the amount paid and returns it, so the caller can keep a running total
    double pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
        return amount;
    }
}