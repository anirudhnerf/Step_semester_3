package encapsulation.class_problems;

// P4: A JavaBean with a write-only OTP property
public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp; // write-only: there is deliberately no getOtp() anywhere

    // JavaBean rule: public no-argument constructor
    public MovieBookingProfile() {
    }

    // Convenience constructor: calls this() instead of repeating its work
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // boolean getter is isX(), not getX()
    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        if (otp == null || !otp.matches("\\d{4,6}")) {
            throw new IllegalArgumentException("OTP must be a 4-6 digit number");
        }
        this.otp = otp;
    }

    public static void main(String[] args) {
        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        System.out.println("getName(): " + p.getName());

        p.setConfirmed(true);
        System.out.println("isConfirmed(): " + p.isConfirmed());

        p.setOtp("4471");
        System.out.println("OTP stored - no method can read it back");
    }
}