package inheritance.assigment_problems;

// P2 demo: Three Tiers of Gym Membership
public class GymTiersDemo {

    public static void main(String[] args) {
        System.out.println(new GymMember("MEM1", 1000).displayInfo());
        System.out.println(new PremiumMember("MEM2", 2000, "Coach Riya").displayInfo());
        System.out.println(new EliteMember("MEM3", 3000, "Coach Arjun", "L12").displayInfo());
        System.out.println(new GroupClassMember("MEM4", 1500, "Zumba").displayInfo());

        PremiumMember premiumMember = new PremiumMember("MEM5", 2000, "Coach Riya");
        EliteMember eliteMember = new EliteMember("MEM6", 3000, "Coach Arjun", "L12");
        GroupClassMember groupClassMember = new GroupClassMember("MEM7", 1500, "Zumba");

        for (int i = 0; i < 3; i++) {
            premiumMember.attendSession();
        }
        for (int i = 0; i < 2; i++) {
            eliteMember.attendSession();
        }
        for (int i = 0; i < 4; i++) {
            groupClassMember.attendSession();
        }

        System.out.println(GymRegistry.classifyGeneration(eliteMember));
        System.out.println(GymRegistry.classifyGeneration(groupClassMember));

        GymMember[] mixed = {premiumMember, eliteMember, groupClassMember};
        System.out.println("Total sessions attended: " + GymRegistry.getTotalSessionsAttended(mixed));
    }
}