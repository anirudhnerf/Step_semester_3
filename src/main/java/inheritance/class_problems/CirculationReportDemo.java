package inheritance.class_problems;

// P4 demo: The Weekly Circulation Report
public class CirculationReportDemo {

    public static void main(String[] args) {
        // IDs are 4+ characters: the sheet's "LB5" / "LB6" would be rejected by the P1 rule
        LibraryMember[] members = {
            new LibraryMember("LIB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };
        System.out.println(MembershipRegistry.batchPrint(members));

        // The unsafe cast that batchPrint avoids: compiles fine, fails when it runs
        LibraryMember plain = new LibraryMember("LIB6", 3);
        try {
            StudentMember bad = (StudentMember) plain;
            System.out.println("cast succeeded: " + bad);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}