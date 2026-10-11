package inheritance.assigment_problems;

// P2: hierarchical inheritance - a second branch straight off GymMember,
// completely independent of PremiumMember
public class GroupClassMember extends GymMember {

    private final String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    // P5: no memberId supplied
    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended();
    }
}