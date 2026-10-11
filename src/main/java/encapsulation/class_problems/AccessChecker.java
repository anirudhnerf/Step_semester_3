package encapsulation.class_problems;

// P1 + P2: checks an access attempt against Java's four access levels
public class AccessChecker {

    private static boolean isValidModifier(String m) {
        return m.equals("private") || m.equals("default")
                || m.equals("protected") || m.equals("public");
    }

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
                // Through the subclass's own type (this / a PremiumMovieTicket variable)
                allowed = fieldModifier.equals("protected") || fieldModifier.equals("public");
                break;
            case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
                // Through a variable declared as the parent type: Java goes by the
                // declared type, so protected does NOT apply here
            case "DIFFERENT_PACKAGE":
                allowed = fieldModifier.equals("public");
                break;
            default:
                throw new IllegalArgumentException("Unknown context: " + accessorContext);
        }

        return allowed ? "ALLOWED" : "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {
            if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));

        String[][] attempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeBatch(attempts));
    }
}