package abstraction.class_problems;

// P5: logs a mixed array of notes (run-time polymorphism)
public class DeliveryLog {

    static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }

    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));

        DeliveryNote ref = p; // upcasting: ParcelNote stored as its parent type

        System.out.println("--- logAll ---");
        logAll(new DeliveryNote[]{ref, new LetterNote("TRK-2")});
    }
}