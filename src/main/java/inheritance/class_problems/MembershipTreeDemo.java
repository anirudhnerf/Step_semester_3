package inheritance.class_problems;

// P2 demo: Three Branches of the Membership Tree
public class MembershipTreeDemo {

    public static void main(String[] args) {
        System.out.println(new LibraryMember("STU1", 3).displayInfo());
        System.out.println(new StudentMember("STU2", 3, "CSE").displayInfo());
        System.out.println(new HonorsStudentMember("STU3", 3, "ECE", 2).displayInfo());
        System.out.println(new FacultyMember("STU4", 5, "Physics").displayInfo());

        StudentMember studentMember = new StudentMember("STU5", 3, "CSE");
        HonorsStudentMember honorsMember = new HonorsStudentMember("STU6", 3, "ECE", 2);
        FacultyMember facultyMember = new FacultyMember("FAC7", 5, "Physics");

        studentMember.borrowBook();
        studentMember.borrowBook();
        honorsMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();

        System.out.println(MembershipRegistry.classifyGeneration(honorsMember));
        System.out.println(MembershipRegistry.classifyGeneration(facultyMember));

        LibraryMember[] mixed = {studentMember, honorsMember, facultyMember};
        System.out.println("Total books borrowed: " + MembershipRegistry.getTotalBooksBorrowed(mixed));
    }
}