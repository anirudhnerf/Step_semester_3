package inheritance.assigment_problems;

// P2: multilevel inheritance - GymMember -> PremiumMember -> EliteMember
public class EliteMember extends PremiumMember {

    private final String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + getTrainerName()
                + " | Locker: " + lockerNumber
                + " | Sessions: " + getSessionsAttended();
    }
}