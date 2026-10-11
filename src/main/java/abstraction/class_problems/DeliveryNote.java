package abstraction.class_problems;

// P5: abstract note with an abstract confirmDelivery() and an overloaded version with a signature
public abstract class DeliveryNote {

    private final String trackingId;

    public DeliveryNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getTrackingId() {
        return trackingId;
    }

    // Each kind of note words its own confirmation
    public abstract String confirmDelivery();

    // Overload (compile-time polymorphism): the core message still lives in ONE place
    String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}