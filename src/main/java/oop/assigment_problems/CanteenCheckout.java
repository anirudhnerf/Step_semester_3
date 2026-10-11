package oop.assigment_problems;

// A5: instanceof Inside a Loop - Canteen Closing-Time Payment Dispatch
public class CanteenCheckout {

    // Returns the amount actually charged, so main can add it to the running total
    static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment card = (CardPayment) payment; // safe: instanceof just confirmed it
            return card.payWithProcessingFee(amount);
        } else {
            return payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        // 3 CardPayment and 2 plain Payment objects, stored together as Payment references
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};

        double totalCollected = 0;
        for (int i = 0; i < payments.length; i++) {
            totalCollected += processTransaction(payments[i], amounts[i]);
        }

        System.out.println("Total Collected: Rs " + totalCollected);
    }
}