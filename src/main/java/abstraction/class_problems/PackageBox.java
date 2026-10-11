package abstraction.class_problems;

// P2: implements Printable, with no parent class and no link to Invoice
public class PackageBox implements Printable {

    private final String trackingId;

    public PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String printLabel() {
        return "Package label: " + trackingId;
    }
}