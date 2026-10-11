package inheritance.class_problems;

// P1: single inheritance - memberId and borrowLimit live ONLY in LibraryMember
public class StudentMember extends LibraryMember {

    private final String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit); // forward the shared fields upward
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    // P3: students get half off every fine, reusing the parent's logic
    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
    }
}