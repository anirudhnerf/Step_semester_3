package abstraction.class_problems;

// P2: one method that works on any mix of Printable things
public class LabelPrinter {

    static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {
        PackageBox p = new PackageBox("TRK-88");
        System.out.println(p.printLabel());

        Invoice i = new Invoice("INV-42");
        System.out.println(i.printLabel());

        System.out.println("--- printAll ---");
        printAll(new Printable[]{p, i});
    }
}