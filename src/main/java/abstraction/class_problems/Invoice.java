package abstraction.class_problems;

// P2: implements Printable, with no parent class and no link to PackageBox
public class Invoice implements Printable {

    private final String invoiceNumber;

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}