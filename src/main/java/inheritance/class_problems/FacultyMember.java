package inheritance.class_problems;

// P2: hierarchical inheritance - a second branch straight off LibraryMember,
// completely independent of StudentMember
public class FacultyMember extends LibraryMember {

    private final String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    // P5: no memberId supplied
    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + getBooksBorrowed();
    }
}