package inheritance.assigment_problems;

// Static helpers that work on whole lists of memberships (P1, P2, P4, P5)
public class GymRegistry {

    // P1: try to build each member and count rejections - no pre-validation here
    static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    // P2: instanceof checks alone, most specific type first
    // (an EliteMember is also a PremiumMember and a GymMember)
    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof PremiumMember) {
            return "Single inheritance child (direct subclass)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Base class (root of the hierarchy)";
    }

    // P2: polymorphism - each object's own getSessionsAttended() runs, no type checks
    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        for (GymMember m : members) {
            total += m.getSessionsAttended();
        }
        return total;
    }

    // P4: one StringBuilder for the whole announcement; displayInfo() is called polymorphically
    static String batchPrint(GymMember[] members) {
        StringBuilder announcement = new StringBuilder();

        for (GymMember m : members) {
            announcement.append(m.displayInfo());

            // instanceof first, then the downcast - never cast and hope
            if (m instanceof PremiumMember) {
                PremiumMember premium = (PremiumMember) m;
                announcement.append(" [Trainer via downcast: ").append(premium.getTrainerName()).append("]");
            }

            announcement.append(" | ");
        }

        return announcement.toString();
    }

    // P5: instanceof separates group from individual; a null entry is skipped, never thrown on
    static String processWeeklyCheckIn(GymMember[] members) {
        int group = 0;
        int individual = 0;
        int nullSkipped = 0;

        for (GymMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else if (m instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        int processed = group + individual;
        return processed + " processed | " + nullSkipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }
}