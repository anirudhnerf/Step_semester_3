package encapsulation.assigment_problems;

// P1 + P2: Membership Field Reach Checker and Reference Desk Subclass Reach
public class AccessChecker {

    private static final String[] MODIFIERS = {"private", "default", "protected", "public"};

    private static boolean isValidModifier(String m) {
        return indexOfModifier(m) >= 0;
    }

    private static int indexOfModifier(String m) {
        for (int i = 0; i < MODIFIERS.length; i++) {
            if (MODIFIERS[i].equals(m)) {
                return i;
            }
        }
        return -1;
    }

    // Decided purely from Java's visibility rules - no hardcoded field names
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (!isValidModifier(fieldModifier)) {
            throw new IllegalArgumentException("Unknown modifier: " + fieldModifier);
        }

        boolean allowed;
        switch (accessorContext) {
            case "SAME_CLASS":
                // Everything is visible inside its own class
                allowed = true;
                break;
            case "SAME_PACKAGE":
                // Everything except private
                allowed = !fieldModifier.equals("private");
                break;
            case "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE":
                // Through the subclass's own type: protected works
                allowed = fieldModifier.equals("protected") || fieldModifier.equals("public");
                break;
            case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
                // Through a variable declared as the parent type: Java goes by the
                // declared type, so protected does NOT work here
            case "DIFFERENT_PACKAGE":
                allowed = fieldModifier.equals("public");
                break;
            default:
                throw new IllegalArgumentException("Unknown context: " + accessorContext);
        }

        return allowed ? "ALLOWED" : "DENIED";
    }

    // P1: grouped by modifier. Built around the four modifiers themselves, so a
    // modifier with zero attempts still shows up as "0 allowed / 0 denied".
    static String summarizeByModifier(String[][] attempts) {
        int[] allowed = new int[MODIFIERS.length];
        int[] denied = new int[MODIFIERS.length];

        for (String[] attempt : attempts) {
            int idx = indexOfModifier(attempt[0]);
            if (idx < 0) {
                throw new IllegalArgumentException("Unknown modifier: " + attempt[0]);
            }
            if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) {
                allowed[idx]++;
            } else {
                denied[idx]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MODIFIERS.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(MODIFIERS[i]).append(": ")
              .append(allowed[i]).append(" allowed / ")
              .append(denied[i]).append(" denied");
        }
        return sb.toString();
    }

    // P2: early-exit scan - stops at the first denial, never builds a full result list
    static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            if (classifyAccess(attempts[i][0], attempts[i][1]).equals("DENIED")) {
                return attempts[i][0] + " via " + attempts[i][1] + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] batch = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(batch));

        String[][] scan1 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(scan1));

        String[][] scan2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(scan2));
    }
}