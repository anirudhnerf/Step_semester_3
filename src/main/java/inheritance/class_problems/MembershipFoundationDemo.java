package inheritance.class_problems;

// P1 demo: Library Membership Foundation & Batch Enrollment Validator
public class MembershipFoundationDemo {

    public static void main(String[] args) {
        try {
            new LibraryMember("LB1", 3);
            System.out.println("new LibraryMember(\"LB1\", 3): accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("new LibraryMember(\"LB1\", 3): construction rejected");
        }

        StudentMember s = new StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println("s.getBooksBorrowed(): " + s.getBooksBorrowed());

        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(MembershipRegistry.enrollBatch(ids, 3));
    }
}