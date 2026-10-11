package string_methods.assigment_problems;

public class ProductInventoryCsvParser {

    // Splits "ProductName,SKU,Quantity" and prints a formatted record
    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        // A valid record has exactly 3 fields
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + fields[0].trim()
                + " | SKU: " + fields[1].trim()
                + " | Qty: " + fields[2].trim());
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }
}