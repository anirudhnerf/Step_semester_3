package string_methods.class_problems;

public class CsvStudentRecordParser {

    // Splits "Name,RollNumber,Department" and prints a formatted record
    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        // A valid record has exactly 3 fields
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0].trim()
                + " | Roll No: " + fields[1].trim()
                + " | Dept: " + fields[2].trim());
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }
}