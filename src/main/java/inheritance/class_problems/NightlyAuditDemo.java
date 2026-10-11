package inheritance.class_problems;

// P5 demo: Membership Numbers, Renewal Codes & the Nightly Circulation Audit
// (run in its own JVM, so the shared counter starts fresh and the first number is LIB-101)
public class NightlyAuditDemo {

    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        System.out.println("m1.memberNumber: " + m1.memberNumber);
        System.out.println("getMembersEnrolled(): " + LibraryMember.getMembersEnrolled());

        System.out.println("R12A: " + LibraryMember.isValidRenewalCode("R12A"));
        System.out.println("R1A: " + LibraryMember.isValidRenewalCode("R1A"));
        System.out.println("X12A: " + LibraryMember.isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println("m1.getBooksBorrowed(): " + m1.getBooksBorrowed());

        LibraryMember[] batch = {
            new FacultyMember(5, "Physics"),
            null,
            new LibraryMember(3)
        };
        System.out.println(MembershipRegistry.processNightlyAudit(batch));
    }
}