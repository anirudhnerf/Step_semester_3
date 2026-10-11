package oop.class_problems;

// M1: From parallel arrays to a class
public class PlacementRecord {

    String studentName;
    String company;
    double packageLpa;

    // Sets all three fields in one go, so the data can never go out of sync
    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Prints one formatted line for this record
    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        // One array of objects replaces the three parallel arrays
        PlacementRecord[] records = new PlacementRecord[3];
        records[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        records[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        records[2] = new PlacementRecord("Karthik", "Infosys", 4.0);

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}