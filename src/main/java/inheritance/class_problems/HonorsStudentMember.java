package inheritance.class_problems;

// P2: multilevel inheritance - LibraryMember -> StudentMember -> HonorsStudentMember
public class HonorsStudentMember extends StudentMember {

    private final int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    // Honors members may hold extra books on top of the normal limit
    @Override
    protected int allowedBooks() {
        return super.allowedBooks() + bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + getCourse()
                + " | Bonus Limit: " + bonusLimit
                + " | Books Borrowed: " + getBooksBorrowed();
    }
}