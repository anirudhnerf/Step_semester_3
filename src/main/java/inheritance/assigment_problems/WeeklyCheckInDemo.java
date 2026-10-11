package inheritance.assigment_problems;

// P5 demo: Membership Numbers, Referral Codes & the Weekly Check-in Settlement
// (run in its own JVM, so the shared counter starts fresh and the first number is GYM-2001)
public class WeeklyCheckInDemo {

    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);
        System.out.println("m1.membershipNumber: " + m1.membershipNumber);
        System.out.println("getMembersEnrolled(): " + GymMember.getMembersEnrolled());

        System.out.println("G45B: " + GymMember.isValidReferralCode("G45B"));
        System.out.println("G4B: " + GymMember.isValidReferralCode("G4B"));
        System.out.println("X45B: " + GymMember.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println("m1.getFeesPaid(): " + m1.getFeesPaid());

        GymMember[] batch = {
            new GroupClassMember(1500, "Zumba"),
            null,
            new GymMember(1000)
        };
        System.out.println(GymRegistry.processWeeklyCheckIn(batch));
    }
}