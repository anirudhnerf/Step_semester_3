package oop.assigment_problems;

// A5 (support class): a card payment is a kind of Payment, with a 2% fee
public class CardPayment extends Payment {

    double payWithProcessingFee(double amount) {
        double total = amount + amount * 0.02;
        System.out.println("Charged (card, incl. fee): Rs " + total);
        return total;
    }
}