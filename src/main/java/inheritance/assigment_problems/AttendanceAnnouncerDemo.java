package inheritance.assigment_problems;

// P4 demo: The Monthly Attendance Announcer
public class AttendanceAnnouncerDemo {

    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(GymRegistry.batchPrint(members));

        // The unsafe cast that batchPrint avoids: compiles fine, fails when it runs
        GymMember plain = new GymMember("MEM8", 1000);
        try {
            PremiumMember bad = (PremiumMember) plain;
            System.out.println("cast succeeded: " + bad);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}