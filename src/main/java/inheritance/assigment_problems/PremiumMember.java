package inheritance.assigment_problems;

// P1: single inheritance - memberId and monthlyFee live ONLY in GymMember
public class PremiumMember extends GymMember {

    private final String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee); // forward the shared fields upward
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    // P3: premium members get half off every late fee, reusing the parent's logic
    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
    }
}