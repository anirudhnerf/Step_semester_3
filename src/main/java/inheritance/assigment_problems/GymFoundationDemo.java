package inheritance.assigment_problems;

// P1 demo: Gym Membership Foundation & Batch Trial Sign-up Validator
public class GymFoundationDemo {

    public static void main(String[] args) {
        try {
            new GymMember("GM1", 1000);
            System.out.println("new GymMember(\"GM1\", 1000): accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("new GymMember(\"GM1\", 1000): construction rejected");
        }

        PremiumMember p = new PremiumMember("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println("p.getSessionsAttended(): " + p.getSessionsAttended());

        String[] ids = {"MEM1", "GM1", "MEM2", " ", "MEM3"};
        System.out.println(GymRegistry.signUpBatch(ids, 1000));
    }
}