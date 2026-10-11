package encapsulation.assigment_problems;

// P1 (the four access levels) + P4 (JavaBean with write-once and write-only properties)
public class LibraryMember {

    // ----- P1: one field per access level, chosen by who genuinely needs it -----

    // private: nobody outside LibraryMember may touch the PIN
    private String membershipPin = "0000";

    // default (package-private): only classes in this package
    String branchCode = "MAIN";

    // protected: this package, plus subclasses in other packages (premium module)
    protected double finesOwed = 0;

    // public: reachable from anywhere
    public String displayName = "Guest";

    // ----- P4: JavaBean properties (all private, accessed through getX/setX/isX) -----

    private String membershipId;
    private boolean membershipIdAssigned = false; // makes membershipId write-once
    private String name;
    private boolean premiumMember;
    private String securityAnswerDigest; // write-only: stored one-way, no getter exists

    // JavaBean rule: public no-argument constructor
    public LibraryMember() {
    }

    // The PIN can be checked but never read back
    public boolean verifyPin(String pin) {
        return membershipPin.equals(pin);
    }

    public String getMembershipId() {
        return membershipId;
    }

    // Write-once: the setter exists for the framework, but only the first call counts
    public void setMembershipId(String id) {
        if (membershipIdAssigned) {
            return; // silently ignored
        }
        this.membershipId = id;
        this.membershipIdAssigned = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // boolean getter is isX(), not getX()
    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Write-only: only a one-way transformed value is kept, and there is no getter.
    // (hashCode is deterministic and one-way - fine for this exercise, not for real security)
    public void setSecurityAnswer(String answer) {
        if (answer == null) {
            this.securityAnswerDigest = null;
            return;
        }
        this.securityAnswerDigest = Integer.toHexString(answer.trim().toLowerCase().hashCode());
    }

    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();

        // P1: inside the same class, all four levels are reachable
        System.out.println("Display name (public): " + m.displayName);
        System.out.println("Branch code (default): " + m.branchCode);
        System.out.println("Fines owed (protected): " + m.finesOwed);
        System.out.println("PIN check (private, via method): " + m.verifyPin("0000"));

        // P4: JavaBean behaviour
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println("getMembershipId(): " + m.getMembershipId());

        m.setMembershipId("FAKE-0000"); // ignored
        System.out.println("getMembershipId() after 2nd set: " + m.getMembershipId());
        System.out.println("isPremiumMember(): " + m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
        System.out.println("Security answer stored - no method can read it back");
    }
}